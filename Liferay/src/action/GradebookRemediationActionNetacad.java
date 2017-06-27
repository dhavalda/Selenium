package action;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import modules.GradebookRemediationLiferay;
import modules.GradebookRemediationNetacad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;

public class GradebookRemediationActionNetacad {
	
	private static WebDriver driver = null;
	
	public static void executeGradebook(WebDriver driver) throws Exception{
		
		//AssessmentLink.editCourse(driver).click();
//		driver.get("https://12320241.netacad.com/courses/384521/");
		
//		driver.get("https://12320241.netacad.com/courses/430568/");
		//ITE 6.0 Russian course
		
		Thread.sleep(5000);
		
		XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
		String courseName = XcelReadWrite.getCellData(1,3);
		
		GradebookRemediationNetacad.coursesSelection(driver).click();
		
		Thread.sleep(5000);
		
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
			
//		int noOfChapters2=GradebookRemediationLiferay.noOfchapters(driver);
//		System.out.println("Total number of chapters:  "+noOfChapters2);	
//		Reporter.log("Total number of chapters:"+noOfChapters2);
					
		List <WebElement> gridrow = driver.findElements(By.xpath(".//*[@id='gradebook_grid']/div[3]/div[4]/div/div[*]"));
		int cells = gridrow.size();
		System.out.println("Total number of cells:  "+cells);
		
		for(int j=1;j<=cells;j++)
		{
			String grade1=GradebookRemediationNetacad.scores(driver, i,j).getText();
            System.out.println("Student"+i+" scores: "+grade1);
			Thread.sleep(1000);
					
		 if(grade1.matches("-?\\d+(\\.\\d+)?\\%?"))
		{
			System.out.println("Number is present "+grade1);
		}
		 else
         
			System.out.println("There is an Error for student"+i);
		}
		}
		
		Thread.sleep(2000);
		//b represents chapter to click on like pretest,chapter1..
		int noofchapters1=GradebookRemediationLiferay.noOfchapters(driver);
		
		for (int b=1;b<=noofchapters1;b++)
		{
			GradebookRemediationNetacad.chapterClick(driver,b).click();
		    Thread.sleep(1000);
		    
			List<WebElement> iframes=driver.findElements(By.tagName("iframes"));
			driver.switchTo().frame(1);
			
			GradebookRemediationNetacad.assessmentViewer1(driver).click();
			
	int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();

		loopbreak:	
		for (int f=1 ;f<=languageSize;f++)
		{
			String lang=GradebookRemediationNetacad.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
				
		 if(lang.equals("Russian"))
		{
			GradebookRemediationNetacad.formName(driver, f).click();
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
			exam++;
			System.out.println("---------------------Item feedbcak and LI for exam------------------  "+exam);
			
			int question1=1;		
			if(GradebookRemediationNetacad.itemFeedQuestion1(driver)==false)
			{
				System.out.println("Item Feed back is present for question "+question1);
			}
			else
			{
				System.out.println("Item Feed back is not present for question "+question1);	
			}
		
			if(GradebookRemediationNetacad.liNumberQuestion1(driver)==false)
			{
			    System.out.println("LI is present  "+question1);
			}
			else
			{
				System.out.println("LI is not present "+question1);	
			}
					
            
			int questionN=2;
			do
			{
			 
			if(GradebookRemediationNetacad.itemFeedQuestionN(driver,questionN)==false)
			{
				System.out.println("Item Feed back is present for question "+questionN);
			}
			else
			{
			    System.out.println("Item Feed back is not present for question "+questionN);	
			}
					
			if(GradebookRemediationNetacad.liN(driver,questionN)==false)
			{
				System.out.println("LI is present  "+questionN);
			}
			else
			{
				System.out.println("LI is not present "+questionN);	
			}
			    
			questionN++;
					
			GradebookRemediationNetacad.nextButton(driver).click();	
			Thread.sleep(5000);
					
		} while(GradebookRemediationNetacad.nextButton(driver).isEnabled());
	}
}
				
		driver.close();
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
// driver.get("https://12320241.netacad.com/courses/384521/gradebook");
		driver.get(newurl);
		Thread.sleep(3000);
    }	
  }
}
