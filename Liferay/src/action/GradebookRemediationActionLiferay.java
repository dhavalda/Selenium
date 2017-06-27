package action;

import java.util.List;
import java.util.Set;

import modules.GradebookRemediationLiferay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;

public class GradebookRemediationActionLiferay {

private static WebDriver driver = null;
	
	public static void executeGradebookLiferay(WebDriver driver) throws Exception{
		
		//AssessmentLink.editCourse(driver).click();
//		driver.get("https://7604194.cisco.instructure.com/courses/9376");
		
		XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
		String courseName = XcelReadWrite.getCellData(1,3);
		
		GradebookRemediationLiferay.coursesSelection(driver).click();
		
		String url_assign = driver.getCurrentUrl();
		String newurl = url_assign+"/gradebook";
		System.out.println(driver.getCurrentUrl());
		driver.get(newurl);
		Thread.sleep(10000);
				
		int exam=0;
        //i represents student first data(i,j->0,0) in table
		//i represents number of students
		
		int noOfStudents=GradebookRemediationLiferay.noOfStudents(driver);
		System.out.println("Total number of Students:"+noOfStudents);
		Log.error("<font color='green'>Total number of Students:</font>"+noOfStudents);
		
		for(int i=1;i<=noOfStudents;i++)
		// j rep. student data (i,j->0,1) in table
		{ //J-> number of exams
//		  List<WebElement> sizeOfChapters=(List<WebElement>) GradeBook.sizeOfchapters(driver);
//		  System.out.println("Size of chapter  "+sizeOfChapters.size());
			
	int noOfChapters2=GradebookRemediationLiferay.noOfchapters(driver);
	System.out.println("Total number of chapters:  "+noOfChapters2);	
	Reporter.log("<font color='green'>Total number of chapters:</font>"+noOfChapters2);
	
		for(int j=1;j<=noOfChapters2;j++)
		{
//			String grade1=GradebookRemediationLiferay.scores(driver, i,j).getText();
//            System.out.println("Student"+i+" scores: "+grade1);
			Thread.sleep(1000);
			
			String grade1=GradebookRemediationLiferay.scores(driver,i,j).getText();
			System.out.println("Grade 1: "+grade1);
			Thread.sleep(5000);
			String exam1=GradebookRemediationLiferay.examName(driver,j).getText();
			String studentname= GradebookRemediationLiferay.studentName(driver, i).getText();
					
		 if(grade1.matches("-?\\d+(\\.\\d+)?\\%?"))
		{
			 System.out.println("Student"+i+ "grade " +grade1);
			 Log.info("Student"+i+ "grade " +grade1);
			 System.out.println(studentname+" grade "+"\""+grade1+"\""+" for exam "+exam1);
			 Log.info(studentname+" grade "+"\""+grade1+"\""+" for exam "+exam1);
		}
		 
		 else
         
			 System.err.println("Student"+i+ "has not taken exam" +exam1);
		     Log.error("Student"+i+ "has not taken exam" +exam1);
		}
		}
		
		Thread.sleep(2000);
		int noofchapters1=GradebookRemediationLiferay.noOfchapters(driver);
		//b represents chapter to click on like pretest,chapter1..
		for (int b=1;b<=noofchapters1;b++)
		{
			Thread.sleep(4000);
			GradebookRemediationLiferay.chapterClick(driver,b).click();
			Thread.sleep(2000);
		    
			List<WebElement> iframes=driver.findElements(By.tagName("iframes"));
			driver.switchTo().frame(1);
			
			GradebookRemediationLiferay.assessmentViewer1(driver).click();
			
		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
		
		loopbreak:	
		for (int f=1;f<=languageSize;f++)
		{
			String lang=GradebookRemediationLiferay.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
			Log.info("language: "+lang);
			
			XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
			String languageName = XcelReadWrite.getCellData(1,4);

		if(lang.equals(languageName))
		{
			GradebookRemediationLiferay.formName(driver, f).click();
			break loopbreak;
		}	
		}
					
		    driver.switchTo().activeElement();
		    Thread.sleep(1000);

			String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			
		for (String windowHandle : handles) 
		{
		  if (!windowHandle.equals(parentWindow)) 
		  {
			driver.switchTo().window(windowHandle); 
			String name=GradebookRemediationLiferay.chapterName(driver).getText();
			exam++;
			System.out.println("---------------------Item feedbcak and LI for exam------------------  "+name);
			
			int question1=1;		
			if(GradebookRemediationLiferay.itemFeedQuestion1(driver)==false && GradebookRemediationLiferay.liNumberQuestion1(driver)==false)
			{
				System.out.println("Item Feed back and LI is present for question "+question1);
				Log.info("Item Feed back and LI is present for question "+question1);
			}
			else
			{
				System.err.println("Item Feed back or LI is not present for question "+question1);	
				Log.error("Item Feed back or LI is not present for question "+question1);
			}
		
//			if(GradebookRemediationLiferay.liNumberQuestion1(driver)==false)
//			{
//			    System.out.println("LI is present  "+question1);
//			}
//			else
//			{
//				System.out.println("LI is not present "+question1);	
//			}
					
            
			int questionN=2;
			do
			{
			 
			if(GradebookRemediationLiferay.itemFeedQuestionN(driver,questionN)==false && GradebookRemediationLiferay.liN(driver,questionN)==false)
			{
				System.out.println("Item FeedBack and LI is present for question"+questionN);
				Log.info("Item FeedBack and LI is present for question"+questionN);
			}
			else
			{
				System.err.println("Item Feed back or LI is not present for question "+questionN);	
				Log.error("Item Feed back or LI is not present for question "+questionN);
			}
					
//			if(GradebookRemediationLiferay.liN(driver,questionN)==false)
//			{
//				System.out.println("LI is present  "+questionN);
//			}
//			else
//			{
//				System.out.println("LI is not present "+questionN);	
//			}
			    
			questionN++;
					
			GradebookRemediationLiferay.nextButton(driver).click();	
			Thread.sleep(5000);
					
		} while(GradebookRemediationLiferay.nextButton(driver).isEnabled());
	}
}
				
		driver.close();
		driver.switchTo().window(parentWindow);
// driver.get("https://12320241.netacad.com/courses/384521/gradebook");
		driver.get(newurl);
		Thread.sleep(3000);
		
    }	
  }
}


