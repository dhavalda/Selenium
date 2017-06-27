package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import modules.GradebookRemediationLiferay;
import modules.StudentPerformanceSummaryLiferay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;

public class StudentPerformanceSummaryActionLiferay {
	
	private static WebDriver driver = null;
	static int d=0;
	
	static FirefoxProfile prof = new FirefoxProfile();
	WebDriver driver1 = new FirefoxDriver(prof);
	
	
	public static void executePerformanceSummaryLiferay(WebDriver driver) throws Exception{
		
		XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
		String courseName = XcelReadWrite.getCellData(1,3);
		GradebookRemediationLiferay.coursesSelection(driver).click();
		
		String url_assign = driver.getCurrentUrl();
		String newurl = url_assign+"/assignments";
		Log.info(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
		driver.get(newurl);
		Log.info(" Course");
		
		int divsOfChapters= StudentPerformanceSummaryLiferay.numberOfDivs(driver);
		System.out.println("Div's in pages "+divsOfChapters);
		Log.info("Groups in Assignments page "+divsOfChapters);
//Counts number of groups in Assignments page.
		
		for(int c=1;c<=divsOfChapters;c++)
		{
			
		int list=StudentPerformanceSummaryLiferay.noOfChapters(driver,c);
		System.out.println("No. of Chapters in current group: "+list);
		Log.info("No. of Chapters in current group: "+list);	
		
		for(int j=2;j<=list;j++)
	    {
			String chapterName=StudentPerformanceSummaryLiferay.chapterClicks(driver,j).getText();
			System.out.println("Chapter Name----"+chapterName);
			Log.info("Chapter Name----"+chapterName);
				
		if(chapterName.contains("Packet Tracer")||chapterName.contains("Instructor Use Only")||chapterName.contains("PT"))
		{
			System.err.println("Exam is PT or Instructor Use Only");
			Log.info("Exam is PT or Instructor Use Only");
		}
		else
		{
			StudentPerformanceSummaryLiferay.chapterClicks(driver,j).click();
			Thread.sleep(3000);
			Log.info("Clicked on chapter");
			Thread.sleep(1000);
			
			int frames = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Number of frames "+frames);
			Log.info("Number of frames "+frames);
			
		    if(frames>1)
		    {
			   WebDriver frameName= driver.switchTo().frame(1);

		    if(StudentPerformanceSummaryLiferay.studentPerformanceLength(driver)>0)
			{
			   StudentPerformanceSummaryLiferay.studentPerformanceLink(driver).click();
			}
			
			
		    else 
			if(frames==0)
			{
				System.err.println("Student Performance Link is not found");
				Log.info("Student Performance Link is not found");
				StudentPerformanceSummaryLiferay.backLinkForChapter(driver).click();	
			}
		    }
			
			Log.info("Clicked on Student Performance Link");

			String form=StudentPerformanceSummaryLiferay.formName(driver).getText();
			System.out.println("-----------------Language Form-----------------"+form);
			Log.info("-----------------Language Form-----------------"+form);
		
			List<WebElement> options = StudentPerformanceSummaryLiferay.subScores(driver).getOptions();
			System.out.println("Total number of subscores in dropdown: "+options.size());
			Log.info("Total number of subscores in dropdown: "+options.size());
			
			int dropdownsize=StudentPerformanceSummaryLiferay.dropdownsize(driver);
			System.out.println("-----DROPDOWN------:  "+options.size());
			Log.info("---DROPDOWN---:"+options.size());

		for(int drop=0;drop<options.size();drop++)
		{
			StudentPerformanceSummaryLiferay.dropdownSelect(driver).selectByIndex(drop++);
			Thread.sleep(1000); 
			System.out.println("DROPDOWN selected is:  "+drop);	
            Log.info("DROPDOWN selected is: "+drop);
			 
            int studentSize=StudentPerformanceSummaryLiferay.studentSize(driver);
			System.out.println("No. of STUDENTS: "+studentSize);
			Log.info("No. of STUDENTS: "+studentSize);
			
		for(int students=1; students<=studentSize;students++)
		{ 
			Thread.sleep(5000);
			int examSize=StudentPerformanceSummaryLiferay.examSize(driver);
			System.out.println("No. of QUESTIONS: "+examSize);
			Log.info("No. of QUESTIONS: "+examSize);
			 
		for(int exams=1;exams<=examSize;exams++)
		{
			String scoresRead=StudentPerformanceSummaryLiferay.readingScores(driver,students, exams).getText();
            
			if(scoresRead.matches("-?\\d+(\\.\\d+)?\\%?"))
			{
			 System.out.println("Student "+students+" score is: "+scoresRead);
			 Log.info("Student "+students+" score is: "+scoresRead);
			}
			
			else
			{
			 System.out.println("Student "+students+" not taken exam");
			 Log.info("Student "+students+" not taken exam");
			}

		} //exams
	} //students 
 
} //dropdown
			 
		int max = Integer.MIN_VALUE;
		int id = 0;
		
	for(int h=0;h<options.size();)
	{				 
		int[] array = new int[options.size()];
		System.out.println("Size " +Arrays.toString(array));
		Log.info("Size " +Arrays.toString(array));
					
	for(int i=0;i<(array.length);i++)
	{	
		StudentPerformanceSummaryLiferay.dropdownSelect(driver).selectByIndex(h++);
		Thread.sleep(10000);
						
		array[i] = StudentPerformanceSummaryLiferay.examSize(driver);
		System.out.println("No.of QUESTIONS for dropdown "+h+" : " +array[i]);
		Log.info("No.of QUESTIONS for dropdown "+h+" : " +array[i]);
						
		if(array[i] > max)
		{
		 max = array[i];
		 id = i;
		}				 
	 }//array
						
	 } //dropdown
		System.out.println("Maximum no.of questions: "+max);
		Log.info("Maximum no.of questions: "+max);
			 
		System.out.println("Dropdown option which contains maximum no. of questions:"+(id+1));
		Log.info("Dropdown option which contains maximum no. of questions:"+(id+1));
			 
		StudentPerformanceSummaryLiferay.dropdownSelect(driver).selectByIndex(id);
			 
		int noOfQuest=	StudentPerformanceSummaryLiferay.sizeOfExams(driver);
		System.out.println("Number of questions :"+noOfQuest);
		Log.info("Number of questions :"+noOfQuest);
		
	for(int mc=1;mc<=noOfQuest;mc++)
	{
		System.out.println("--------------------------------"+mc);
		Log.info("--------------------------------"+mc);
		
		StudentPerformanceSummaryLiferay.clickOnExam(driver,mc).click();
		Thread.sleep(10000);
			
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
				
	for(String windowHandle:handles)
	{
	  
		if (!windowHandle.equals(parentWindow)) 
	    {
		 driver.switchTo().window(windowHandle);
		 Thread.sleep(1000);
				
		if(StudentPerformanceSummaryLiferay.itemFeedback(driver)==false && StudentPerformanceSummaryLiferay.liDisplay(driver)==false)
		{
			System.out.println("Item feed back and LI is present ");
			Log.info("Item feed back and LI is present");
		}
			
		else
		{
		  System.err.println("Item feed back and LI is not present");	
		  Log.error("Item feed back and LI is not present");
		}
		  Thread.sleep(5000);
				
	    if(StudentPerformanceSummaryLiferay.checkMCMA(driver)==true)
	    {
	    	System.out.println("Question is MCMA");
	    	Log.info("Question is MCMA");
		}
				
		else if(StudentPerformanceSummaryLiferay.checkMCSA(driver)==true)
		{
			System.out.println("Question is MCSA");
			Log.info("Question is MCSA");
		}
				
		else if(StudentPerformanceSummaryLiferay.checkFIB(driver)==true)
		{
			System.out.println("Question is FIB");
			Log.info("Question is FIB");
		}

		else 
		{
		  System.out.println("Question is Drag and Drop");
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
			
//	int stud1= StudentPerformanceSummaryLiferay.noOfStudents(driver);
	for(int students =1 ;students<=1;students++)
	{
	   String percentage = StudentPerformanceSummaryLiferay.percentageLink(driver, students,noOfQuest).getText();
	   System.out.println("Percentage---"+percentage);
	   Log.info("Percentage---"+percentage);
			
	   StudentPerformanceSummaryLiferay.percentageLink(driver, students,noOfQuest).click();
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
							
		  int links = StudentPerformanceSummaryLiferay.sizeOfLink(driver);
		  System.out.println("Number of links: "+links);
		  Log.info("Number of links   "+links);
							
		if(links==1)
	    {			
		   String linkName =StudentPerformanceSummaryLiferay.linkClicks(driver).getText();
		   System.out.println("Link found is "+linkName);
		   Log.info("Link found is "+linkName);
					
		   StudentPerformanceSummaryLiferay.linkClicks(driver).click();
					
		if(StudentPerformanceSummaryLiferay.loadingPT(driver) > 0)
		{
		   Robot object=new Robot();
		   object.keyPress(KeyEvent.VK_DOWN);
		   object.keyRelease(KeyEvent.VK_DOWN);
		   Thread.sleep(3000);
		   System.out.println("Select Save File:");
		   Log.info("Select Save File:");
		   
		   object.keyPress(KeyEvent.VK_ENTER);
		   object.keyRelease(KeyEvent.VK_ENTER);
		   StudentPerformanceSummaryLiferay.skipPT(driver).click();
		}
					
		else
		{
		   System.out.println("No packet tracer found");
		   Log.info("No packet tracer found");
		}  
		
		
	if(StudentPerformanceSummaryLiferay.linkTextDropdownIsPresent(driver)>0)
	{
	     List<WebElement> linkTextOptions = StudentPerformanceSummaryLiferay.subScores(driver).getOptions();
		 System.out.println("Total number of options in dropdown in link text page  "+linkTextOptions.size());
		 System.out.println("DROPDOWN   "+linkTextOptions.size());

		 //	code for dropdown when you click on item feedback
     for(int drop1=0;drop1<options.size();drop1++)
	{
	  StudentPerformanceSummaryLiferay.dropdownSelect(driver).selectByIndex(drop1++);
	  Thread.sleep(1000); 
	  System.out.println("DROP DOWN is in  "+drop1);	
	  Log.info("Current DROP DOWN option no. is: "+drop1); 
	  
	  int linkTextQuestions=StudentPerformanceSummaryLiferay.questionsPresentSizeLinkText(driver);
	  int hiddenQuestions=StudentPerformanceSummaryLiferay.hiddenQuestions(driver);
	  int totalQuestions=(linkTextQuestions - hiddenQuestions);
	  System.out.println("Number of questions   "+totalQuestions);
			
			
	  List<WebElement> myElements = driver.findElements(By.xpath(".//*[starts-with(@id,'AIit')]/table/tbody/tr[1]/td[1]"));
	  List<WebElement> myElements2 = driver.findElements(By.xpath(".//*[starts-with(@id,'UAAIit')]/table/tbody/tr/td[1]"));
			
			for(WebElement e : myElements) {
				if(e.getText().matches("-?\\d+(\\.\\d+)?\\%?")){
					 System.out.println("Question number "+e.getText()+" is present in dropdown "+drop1);
					
				}
			}
			
				for(WebElement e1 : myElements2)
				{
					if(e1.getText().matches("-?\\d+(\\.\\d+)?\\%?"))
					{
						 System.out.println("DND Question number "+e1.getText()+" is present in dropdown "+drop1);
						
					}
				}

        
     int noItemQuest = StudentPerformanceSummaryLiferay.numberOfQuestions(driver);
     System.out.println("No. of questions in Item Feedback: " +noItemQuest);
     Log.info("No. of questions in Item Feedback: " +noItemQuest);
					
	for(int LI=1;LI<=noItemQuest;)
	{				 
		if(StudentPerformanceSummaryLiferay.liItemFeedback(driver, LI)==false)
		{
		   Log.info("LI is present for question: "+LI);
		   System.out.println("LI is present for question: "+LI);
		}
		else
		{
		   Log.error("LI is not present for question: "+LI);
		   System.err.println("LI is not present for question: "+LI);
		}
		
		LI++;
	 }	
	
     }	
  }	
}	// if(link==1)
else if(links==2)
	{
			
	 for(int l=2;l<=links;l++)	
	{
	    StudentPerformanceSummaryLiferay.personalizedFeedback(driver).click();
	    System.out.println("Clicked on personalizedFeedback");
		Log.info("Clicked on personalizedFeedback");
					
		String name=StudentPerformanceSummaryLiferay.studentName(driver).getText();
		System.out.println("Personalized feedback for  "+name);
		Log.info("Personalized feedback for  "+name);
		Thread.sleep(1000);
						
		System.out.println("before click on backlink");
		Log.info("before clicking backlink");
		StudentPerformanceSummaryLiferay.backLink(driver).click();
		System.out.println(" Clicked on back link");
		Log.info("Clicked on back link");
		Thread.sleep(1000);
							
		StudentPerformanceSummaryLiferay.itemFeedbackLink(driver).click();
		System.out.println("Clicked on Item Feedback link");
		Log.info("Clicked on ItemFeed ");
		Thread.sleep(2000);
		
	
					
		if(StudentPerformanceSummaryLiferay.loadingPT(driver) > 0)
		{
		   Robot object=new Robot();
		   object.keyPress(KeyEvent.VK_DOWN);
		   object.keyRelease(KeyEvent.VK_DOWN);
		   Thread.sleep(3000);
		   System.out.println("Select Save File:" +object);
		   Log.info("Select Save File:" +object);
		   
		   object.keyPress(KeyEvent.VK_ENTER);
		   object.keyRelease(KeyEvent.VK_ENTER);
		   StudentPerformanceSummaryLiferay.skipPT(driver).click();
		}
		else
		{
		   System.err.println("No packet tracer found");
		   Log.info("No packet tracer found");
		}  
		
		if(StudentPerformanceSummaryLiferay.linkTextDropdownIsPresent(driver)>0)
		{
			List<WebElement> linkTextOptions = StudentPerformanceSummaryLiferay.subScores(driver).getOptions();
			System.out.println("Total number of options in dropdown in link text page "+linkTextOptions.size());
			System.out.println("DROPDOWN   "+linkTextOptions.size());
		   
     for(int drop2=0;drop2<linkTextOptions.size();drop2++)
	{
	   StudentPerformanceSummaryLiferay.dropdownSelect(driver).selectByIndex(drop2++);
	   Thread.sleep(1000); 
	   System.out.println("DROP DOWN is in  "+drop2);	
	   Log.info("Current DROP DOWN option no. is: "+drop2);
	   
	   int linkTextQuestions=StudentPerformanceSummaryLiferay.questionsPresentSizeLinkText(driver);
	   int hiddenQuestions=StudentPerformanceSummaryLiferay.hiddenQuestions(driver);
	   int totalQuestions=(linkTextQuestions - hiddenQuestions);
	   System.out.println("Number of questions  "+totalQuestions);
			
			
		List<WebElement> myElements = driver.findElements(By.xpath(".//*[starts-with(@id,'AIit')]/table/tbody/tr[1]/td[1]"));
		List<WebElement> myElements2 = driver.findElements(By.xpath(".//*[starts-with(@id,'UAAIit')]/table/tbody/tr/td[1]"));
			
			for(WebElement e : myElements) {
				if(e.getText().matches("-?\\d+(\\.\\d+)?\\%?")){
					 System.out.println("Question number present "+e.getText()+"in dropdown"+drop2);
					
				}
			}
				for(WebElement e1 : myElements2)
				{
					if(e1.getText().matches("-?\\d+(\\.\\d+)?\\%?"))
					{
						 System.out.println("DND Question number present "+e1.getText()+"in dropdown"+drop2);
						
					}
				}

	
	int questItemFeedback =	StudentPerformanceSummaryLiferay.numberOfQuestions(driver);
	System.out.println("Number of questions: "+questItemFeedback);
	Log.info("Number of questions: "+questItemFeedback);
					
	for(int LI=1;LI<=questItemFeedback;LI++)
	{			 
		if(StudentPerformanceSummaryLiferay.liItemFeedback(driver, LI)==false)
		{
		  Log.info("LI is present for question: "+LI);
		  System.out.println("LI is present for question: "+LI);
		}
							
		else
		{
		  Log.error("LI is not present for question:" +LI);
		  System.err.println("LI is not present for question:" +LI);
		}
		
	 }
	 
  }
}
	 else 
	{
	  System.err.println("Links not found for student  "+students);
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
	  StudentPerformanceSummaryLiferay.backLinkForChapter(driver).click();	
	  
	} //chapterclicks (else)
   }//chapterclicks (start for loop)		
  } //divs of chapters
 } //method
		
}
}}


