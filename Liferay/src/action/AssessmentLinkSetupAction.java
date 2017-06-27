package action;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import modules.AssessmentLinkSetup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;


public class AssessmentLinkSetupAction {
	
	public static int h = 1;

	public static  void addingAssessmentLinks(WebDriver driver) throws Exception
	{
		
		AssessmentLinkSetup.publish(driver).click();
		
		Thread.sleep(2000);
		
		String url_assign = driver.getCurrentUrl();
		String newurl = url_assign+"/assignments";
		System.out.println(driver.getCurrentUrl());
		driver.get(newurl);
		
			
//		AssessmentLinkSetup.group(driver).click();		
//		
//		AssessmentLinkSetup.groupName(driver).sendKeys("Assignments");
//	
//		AssessmentLinkSetup.saveGroupName(driver).click();
//		Thread.sleep(10000);
//						
//		AssessmentLinkSetup.selectDropdown(driver).click();
//
//		AssessmentLinkSetup.delete(driver).click();
//			Thread.sleep(10000);
////			Alert alert = driver.switchTo().alert();
////			alert.accept();
//		AssessmentLinkSetup.deleteGroup1(driver).click();
//		Thread.sleep(10000);
//			//driver.navigate().refresh();
//		AssessmentLinkSetup.selectDropdown(driver).click();
//		AssessmentLinkSetup.delete(driver).click();
//		AssessmentLinkSetup.deleteGroup2(driver).click();
//		Thread.sleep(10000);
		
		String numberOfCoursesInExams = XcelReadWrite.getCellData(12,1);
		   Log.info("Number of courses	:     "+numberOfCoursesInExams);
	       int m = Integer.parseInt(numberOfCoursesInExams.trim()); 
	       Thread.sleep(5000);
			
	for (int i=1; i<=m ; i++)
	{
			
          AssessmentLinkSetup.addAssignments(driver).click();
          
          XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelAssessmentsChapters,"Sheet1");
           
          String assignmentname=XcelReadWrite.getCellData((2+(i-1)),0);

		  AssessmentLinkSetup.addAssignmentsName(driver).sendKeys(assignmentname);
			
		  AssessmentLinkSetup.addAssignmentsPoints(driver).clear();

		  AssessmentLinkSetup.addAssignmentsPoints(driver).sendKeys("100");

		  AssessmentLinkSetup.submissionType(driver).selectByVisibleText("External Tool");

		  XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelAssessmentsChapters,"Sheet1");
		  String courseNameUrl=XcelReadWrite.getCellData((2+(i-1)),1);
		  Log.info("Chapter URL  :"+courseNameUrl);
		  
		  AssessmentLinkSetup.urlTextbox(driver).sendKeys(courseNameUrl);
		  
//		  AssessmentLinkSetup.findButton(driver).click();
		  
		  Thread.sleep(5000);
		  
//		  AssessmentLinkSetup.toolSelection(driver).click();
//		  Thread.sleep(5000);
		  
//		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		  driver.switchTo().frame(1);
		  
//		  AssessmentLinkSetup.cancelCloseMark(driver).click();
		 
//		  XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelAssessmentsChapters,"Sheet1");
//		  String courseNameUrl=XcelReadWrite.getCellData((2+(i-1)),1);
//		  Log.info("Chapter URL  :"+courseNameUrl);
//		  AssessmentLinkSetup.chapterUrl(driver).click();
//		  AssessmentLinkSetup.chapterUrl(driver).sendKeys(courseNameUrl);
//		  Log.info("Entered Chapter url");
//		  Thread.sleep(5000);
//		  
//		  AssessmentLinkSetup.selectSavedCourse(driver).click();
		  
		  Thread.sleep(5000);
     	  
		  AssessmentLinkSetup.saveAndPublish(driver).click();
     	  
     	  Thread.sleep(5000);
		  
//		  AssessmentLinkSetup.externalTool(driver).click();
//			
//		  Thread.sleep(10000);
//			
//		  int frames = driver.findElements(By.tagName("iframe")).size();
//		  System.out.println(frames);
//		  driver.switchTo().frame(2);
//		  AssessmentLinkSetup.linkBuilder(driver).click();
//		  driver.switchTo().defaultContent();
//		  Thread.sleep(4000);
//			
//		  int frames1 = driver.findElements(By.tagName("iframe")).size();
//		  System.out.println(frames1);
//		  driver.switchTo().frame(2);
//			
//		  String assignmentLanguage=XcelReadWrite.getCellData(12,2);
//		  System.out.println(assignmentLanguage);
//		  AssessmentLinkSetup.language(driver).selectByVisibleText(assignmentLanguage);
//
//		  String assignmentCourse=XcelReadWrite.getCellData(12,3);
//		  AssessmentLinkSetup.course(driver).selectByVisibleText("Introduction to Networks");
//			
//		  String assignmentVersion=XcelReadWrite.getCellData(12,4);
//		  Log.info("Number of students to be executed: "+assignmentVersion);
//		  Double u = Double.parseDouble(assignmentVersion);
//
//		  String v = String.valueOf(u);
//		  System.out.println("doubledoubledoubledfasdfasdouble"+v);
//		  AssessmentLinkSetup.version(driver).selectByVisibleText(v);
//
//		  AssessmentLinkSetup.assessment(driver).selectByIndex(i);
//							
//		    //String assignmentNumber=XcelReadWrite.getCellData(1,9);
//									
//		  AssessmentLinkSetup.submit(driver).click();
//		  driver.switchTo().defaultContent();
//			
//		  int frames2 = driver.findElements(By.tagName("iframe")).size();
//		  System.out.println(frames2);
//		  Thread.sleep(4000);
//		  AssessmentLinkSetup.selectExternalTool(driver).click();
//		  AssessmentLinkSetup.saveAndPublish(driver).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
		  Thread.sleep(10000);
								
//		  XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelAssessmentschapters,"Sheet1");
//			System.out.println("Sheet1"+UrlXcelPath.xcelAssessmentschapters);
//			
//				String coursenameurl=XcelReadWrite.getCellData((2+(i-1)),1);
//			
//				AssessmentLinkSetup.chapterurl(driver).click();
//				AssessmentLinkSetup.chapterurl(driver).sendKeys(coursenameurl);
//				AssessmentLinkSetup.selectsavedcourse(driver).click();
//				AssessmentLinkSetup.savedpublish(driver).click();
}
	}	
	

	public static  void activatingExams(WebDriver driver) throws Exception
	{	
		
	   XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"LoginAndSettingInfo-Sheet1");
	   String numberOfCoursesInExams = XcelReadWrite.getCellData(12,1);
	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
       Thread.sleep(5000);
       
//       String url_assign = driver.getCurrentUrl();
//	   String newurl = url_assign+"/assignments";
//	   System.out.println(driver.getCurrentUrl());
//	   driver.get(newurl);
//	   Thread.sleep(5000);
       
       driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
	  
       for(h=2;h<=16;h++)
		{
			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
			Thread.sleep(5000);
			AssessmentLinkSetup.selectAssignment(driver, h).click();
			Thread.sleep(10000);
		    driver.switchTo().frame(1);
			AssessmentLinkSetup.createAdvancedActivation(driver).click();
			driver.switchTo().defaultContent();
			Thread.sleep(10000);
			driver.switchTo().frame(1);
			//String endDate=XcelReadWrite.getCellData(12,5); 
			//System.out.println("end date"+endDate);
			AssessmentLinkSetup.endDate(driver).clear();
			//AssessmentLinkSetup.endDate(driver).sendKeys(endDate);
			Thread.sleep(10000);
			XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"LoginAndSettingInfo-Sheet1");
			String date=XcelReadWrite.getCellData(12,3);
			System.out.println("End date: "+date);
			int e = Integer.parseInt(date.trim()); 
			System.out.println("End date: e"+e);
			driver.findElement(By.linkText(""+e+"")).click();
		
//			driver.findElement(By.linkText("20")).click();
			
		
			
			String endTime = XcelReadWrite.getCellData(12,4);
			AssessmentLinkSetup.endTime(driver).selectByValue(endTime);
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			
			boolean  unchecked =driver.findElement(By.xpath(".//*[@id='forms-table']/tbody/tr[*]/td[1]/input")).isSelected();
			   if(unchecked==true)
			   {
			    driver.findElement(By.xpath(".//*[@id='forms-table']/tbody/tr[*]/td[1]/input")).click();
			    System.out.println("Checkbox is unchecked");
			   }
			   else
			   {
			   System.out.println("Checkbox is already unchecked"); 
			   }
			
			  
			
		    AssessmentLinkSetup.languageForm(driver).click();
		    Thread.sleep(2000);
		    driver.switchTo().defaultContent();
		    driver.switchTo().frame(1);
			AssessmentLinkSetup.chooseAssessmentAdmininstration(driver).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);
			AssessmentLinkSetup.clickCreateAdvancedActivation(driver).click();
			driver.switchTo().defaultContent();
			}
			
			
			
	}
}

			
	
				
		

	
		 

