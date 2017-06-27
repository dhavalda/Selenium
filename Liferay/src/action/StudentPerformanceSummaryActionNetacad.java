package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.concurrent.TimeUnit;

import modules.GradebookRemediationNetacad;
import modules.StudentPerformanceSummaryNetacad;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import utility.Log;

public class StudentPerformanceSummaryActionNetacad {
	
	private static WebDriver driver = null;
	static int d=0;
	
	static FirefoxProfile prof = new FirefoxProfile();
	WebDriver driver1 = new FirefoxDriver(prof);
	
	
	public static void executePerformanceSummary(WebDriver driver) throws Exception{
		
//		GradebookRemediation.clickAssignment(driver).click();
		
		driver.get("https://12320241.netacad.com/courses/384521/");
		String url_assign = driver.getCurrentUrl();
		String newurl = url_assign+"/assignments";
		Log.info(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
		driver.get(newurl);
		Log.info("ITN 5.1 Russian Sanity Test | 6.16.16");
		
		int divsOfChapters= StudentPerformanceSummaryNetacad.numberOfDivs(driver);
		System.out.println("Divis in pages "+divsOfChapters);
		Log.info("Groups in Assignments page "+divsOfChapters);
//Counts number of groups in Assignments page.
		
		for(int c=1;c<=divsOfChapters;c++)
		{
			
		int list=StudentPerformanceSummaryNetacad.xxx(driver,c);
		System.out.println("listlislistlis'''''''''"+list);
		Log.info("No. of Chapters in current group: "+list);	
		
		for(int j=1;j<=list;j++)
	    {
			String chapterName=StudentPerformanceSummaryNetacad.chapterClicks(driver,c,j).getText();
			System.out.println("chapter name----"+chapterName);
			Log.info("Chapter name----"+chapterName);
				
		if(chapterName.contains("Packet Tracer")|| chapterName.contains("Instructor Use Only"))
		{
			System.err.println("Exam is PT or Instructor Use Only");
			Log.info("Exam is PT or Instructor Use Only");
		}
		else
		{
			StudentPerformanceSummaryNetacad.chapterClicks(driver,c,j).click();
			Thread.sleep(1000);
			Log.info("Clicked on chapter");
			Thread.sleep(1000);
			
			int frames = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Number of frames "+frames);
			Log.info("Number of frames "+frames);
			
		    if(frames>1)
		    {
			   WebDriver frameName= driver.switchTo().frame(1);

		    if(StudentPerformanceSummaryNetacad.studentPerformanceLength(driver)>0)
			{
			   StudentPerformanceSummaryNetacad.studentPerformanceLink(driver).click();
			}
			}
			
		    else 
			if(frames==0)
			{
				System.err.println("Student performance is not found");
				Log.info("Student performance link is not found");
				StudentPerformanceSummaryNetacad.backLinkForChapter(driver).click();	
			}
			
			Log.info("Clicked on Student performance link");

			String form=StudentPerformanceSummaryNetacad.formName(driver).getText();
			Log.info("-----------------Language Form-----------------"+form);
		
			List<WebElement> options = StudentPerformanceSummaryNetacad.subScores(driver).getOptions();
			Log.info("Total number of subscores in dropdown: "+options.size());
			
			int dropdownsize=StudentPerformanceSummaryNetacad.dropdownsize(driver);
			System.out.println("DROPDOWN   "+options.size());
			Log.info("---DROPDOWN---"+options.size());

		for(int drop=0;drop<options.size();)
		{
			StudentPerformanceSummaryNetacad.dropdownselect(driver).selectByIndex(drop++);
			Thread.sleep(1000); 
			System.out.println("DROP DOWN is in  "+drop);	
            Log.info("Current DROP DOWN option no. is: "+drop);
			 
            int studentsize=StudentPerformanceSummaryNetacad.studentsize(driver);
			System.out.println("STUDENT SIZE  "+studentsize);
			Log.info("No. of STUDENTS: "+studentsize);
			
		for(int students=1; students<=studentsize;students++)
		{ 
			Thread.sleep(5000);
			int examsize=StudentPerformanceSummaryNetacad.examsize(driver);
			System.out.println("EXAM SIZE  "+examsize);
			Log.info("No. of QUESTIONS: "+examsize);
			 
		for(int exams=1;exams<=examsize;exams++)
		{
			String scoresread=StudentPerformanceSummaryNetacad.readingscores(driver, students, exams).getText();
			System.out.println("SCORE   "+scoresread);
            Log.info("SCORE   "+scoresread);
            
			if(scoresread.matches("-?\\d+(\\.\\d+)?\\%?"))
			{
			 System.out.println("student "+students+" score is "+scoresread);
			 Log.info("student "+students+" score is "+scoresread);
			}
			
			else
			{
			 System.out.println("student "+students+" not taken exam");
			 Log.info("student "+students+" not taken exam");
			}

		} //exams
	} //students 
 
} //dropdown
			 
		int max = Integer.MIN_VALUE;
		int id = 0;
		
	for(int h=0;h<options.size();)
	{				 
		int[] array = new int[options.size()];
		System.out.println("size " +Arrays.toString(array));
		Log.info("size " +Arrays.toString(array));
					
	for(int i=0;i<(array.length);i++)
	{	
		StudentPerformanceSummaryNetacad.dropdownselect(driver).selectByIndex(h++);
		Thread.sleep(10000);
						
		array[i] = StudentPerformanceSummaryNetacad.examsize(driver);
		System.out.println("EXAM SIZE for dropdown "+h+" : " +array[i]);
		Log.info("No.of QUESTIONS for dropdown "+h+" : " +array[i]);
						
		if(array[i] > max)
		{
		 max = array[i];
		 id = i;
		}				 
	 }//array
						
	 } //dropdown
		System.out.println("Max value "+max);
		Log.info("Maximum no.of questions: "+max);
			 
		System.out.println("Max value i "+(id+1));
		Log.info("Dropdown option which contains maximum no. of questions:"+(id+1));
			 
		StudentPerformanceSummaryNetacad.dropdownselect(driver).selectByIndex(id);
			 
		int noOfQuest=	StudentPerformanceSummaryNetacad.sizeOfExams(driver);
		Log.info("Number of chapters :"+noOfQuest);
		
	for(int mc=1;mc<=noOfQuest;mc++)
	{
		System.out.println("--------------------------------"+mc);
		Log.info("--------------------------------"+mc);
		
		StudentPerformanceSummaryNetacad.clickOnExam(driver,mc).click();
		Thread.sleep(10000);
			
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
				
	for(String windowHandle:handles)
	{
	  
		if (!windowHandle.equals(parentWindow)) 
	    {
		 driver.switchTo().window(windowHandle);
		 Thread.sleep(1000);
				
		if(StudentPerformanceSummaryNetacad.itemFeedback(driver)== false && StudentPerformanceSummaryNetacad.liDisplay(driver)==false)
		{
		  Log.info("Item feed back and LI is present");
		}
			
		else
		  Log.error("item feed back and LI is not present");
	    Thread.sleep(5000);
				
	    if(StudentPerformanceSummaryNetacad.checkMCMA(driver)==true)
	    {
		  Log.info("Question is MCMA");
		}
				
		else if(StudentPerformanceSummaryNetacad.checkMCSA(driver)==true)
		{
		  Log.info("Question is MCSA");
		}
				
		else if(StudentPerformanceSummaryNetacad.checkFIB(driver)==true)
		{
		  Log.info("Question is FIB");
		}

		else 
		{
		  Log.info("Question is Drag and Drop");
		}
			
		  Thread.sleep(1000);
		  driver.close();
		}
					
		Thread.sleep(1000);	
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame(1);
	}
 }
			
	int stud1= StudentPerformanceSummaryNetacad.noOfStudents(driver);
	for(int students =1 ;students<=stud1;students++)
	{
	   String percentage = StudentPerformanceSummaryNetacad.percentageLink(driver, students).getText();
	   System.out.println("Percentage---"+percentage);
	   Log.info("Percentage---"+percentage);
			
	   StudentPerformanceSummaryNetacad.percentageLink(driver, students).click();
	   Log.info("Clicked on percentage: "+percentage);
	   Thread.sleep(1000);
			
	   String parentWindow = driver.getWindowHandle();
	   Set<String> handles = driver.getWindowHandles();				
		
	for(String windowHandle:handles)
	{
		if (!windowHandle.equals(parentWindow)) 
		{		  
		  driver.switchTo().window(windowHandle);	
		  Thread.sleep(10000);
							
		  int links = StudentPerformanceSummaryNetacad.sizeOfLink(driver);
		  Log.info("Number of links   "+links);
							
		if(links==1)
	    {			
		   String linkname =StudentPerformanceSummaryNetacad.linkClicks(driver).getText();
		   Log.info("Link found is "+linkname);
		   System.out.println("Link found is "+linkname);
		   Log.info("Link found is "+linkname);
					
		   StudentPerformanceSummaryNetacad.linkClicks(driver).click();
					
		if(StudentPerformanceSummaryNetacad.loadingPT(driver) > 0)
		{
		   Robot object=new Robot();
		   object.keyPress(KeyEvent.VK_DOWN);
		   object.keyRelease(KeyEvent.VK_DOWN);
		   System.out.println("Select Save File:" +object);
		   Log.info("Select Save File:" +object);
		   
		   object.keyPress(KeyEvent.VK_ENTER);
		   object.keyRelease(KeyEvent.VK_ENTER);
		   StudentPerformanceSummaryNetacad.skipPT(driver).click();
		}
					
		else
		   System.out.println("No packet tracer found");
		   Log.info("No packet tracer found");
					
	for(int LI =1;LI<=1;LI++)
	{				 
		if(StudentPerformanceSummaryNetacad.liItemFeedback(driver, LI)==false)
		{
		   Log.info("LI is present");
		}
		else
		{
		   Log.error("LI is not present");
		}
	}
								
}			
	 else
	 if(links==2)
	{
	 for(int l=2;l<=links;l++)	
	{
	    StudentPerformanceSummaryNetacad.personalizedFeedback(driver).click();
		Log.info("Clicked on personalizedFeedback");
					
		String name=StudentPerformanceSummaryNetacad.studentName(driver).getText();
		Log.info("Personalized feedback for  "+name);
		Thread.sleep(1000);
						
		System.out.println("before click on backlink");
		Log.info("before clicking backlink");
		StudentPerformanceSummaryNetacad.backLink(driver).click();
		System.out.println(" Clicked on back link");
		Log.info("Clicked on back link");
		Thread.sleep(1000);
							
		StudentPerformanceSummaryNetacad.itemFeedbackLink(driver).click();
		Log.info("Clicked on ItemFeed ");
		Thread.sleep(2000);
					
		if(StudentPerformanceSummaryNetacad.loadingPT(driver) > 0)
		{
		   Robot object=new Robot();
		   object.keyPress(KeyEvent.VK_DOWN);
		   object.keyRelease(KeyEvent.VK_DOWN);
		   System.out.println("Select Save File:" +object);
		   Log.info("Select Save File:" +object);
		   
		   object.keyPress(KeyEvent.VK_ENTER);
		   object.keyRelease(KeyEvent.VK_ENTER);
		   StudentPerformanceSummaryNetacad.skipPT(driver).click();
		}
		else
		   System.out.println("No packet tracer found");
		   Log.info("No packet tracer found");
	
	int questItemFeedback =	StudentPerformanceSummaryNetacad.numberOfQuestions(driver);
	Log.info("Number of questions: "+questItemFeedback);
					
	for(int LI =1;LI<=questItemFeedback;LI++)
	{			 
		if(StudentPerformanceSummaryNetacad.liItemFeedback(driver, LI)==false)
		{
		  Log.info("LI is present");
		}
							
		else
		{
		  Log.error("LI is not present");
		}
	 }
  }
}
	 else 
	{
	  Log.error("Links not found for student  "+students);
	}	
  }			
}
	  driver.close();
	  Thread.sleep(1000);	
	  driver.switchTo().window(parentWindow);
	  driver.switchTo().frame(1);
	  Thread.sleep(5000);
   }	 
	  driver.switchTo().defaultContent();
	  StudentPerformanceSummaryNetacad.backLinkForChapter(driver).click();	
	  
	} //chapterclicks (else)
   }//chapterclicks (start for loop)		
  } //divs of chapters
 } //method
}//class
	



			
		

  



