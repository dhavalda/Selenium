package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import module.AssessmentAt0;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelRead;


public class AssessmentAt0Action {
	
	public static int h = 1;
	
	public static int i = 1;
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
		
	   XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
	   String numberOfCoursesInExams = XcelRead.getCellData(10,0);
	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
       Thread.sleep(5000);
       
	  
       for(h=1;h<=y;h++)
	   {
			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
			
//			String url_assign = driver.getCurrentUrl();
//			   String newurl = url_assign+"/assignments";
//			   System.out.println(driver.getCurrentUrl());
//			   driver.get(newurl);
			   
			Thread.sleep(5000);

			AssessmentAt0.selectAssignment(driver, h).click();
			Thread.sleep(10000);
			
			driver.switchTo().frame(1);
		    
		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
			
		loopbreak:		
		for (int f=1;f<=languageSize;f++)
		{
			String lang= AssessmentAt0.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
			Log.info("language: "+lang);
				
			XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
			String languageName = XcelRead.getCellData(10,1);

			if(lang.equals(languageName))
			{
				AssessmentAt0.takeAssessment(driver, f).click();
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
				
				System.out.println("---------------------Begin Assessment------------------  ");
				
			    AssessmentAt0.clickContinue(driver).click();
			    
			    Thread.sleep(3000);
			    
			    if(AssessmentAt0.loadingPT(driver) > 0)
				{
				   Robot object=new Robot();
				   object.keyPress(KeyEvent.VK_DOWN);
				   object.keyRelease(KeyEvent.VK_DOWN);
				   Thread.sleep(3000);
				   System.out.println("Select Save File:");
				   Log.info("Select Save File:");
				   
				   object.keyPress(KeyEvent.VK_ENTER);
				   object.keyRelease(KeyEvent.VK_ENTER);
				    
				   AssessmentAt0.skipPT(driver).click();
				   System.out.println("Skip Packet Tracer");
				   
				   Alert alert = driver.switchTo().alert();
				   driver.switchTo().alert();
				   alert.accept();
				   
				}
							
				else
				{
				   System.out.println("No packet tracer found");
				   Log.info("No packet tracer found");
				   AssessmentAt0.clickBeginAssessment(driver).click();
				}  
			    
	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
		System.out.println("Number of Questions"+noOfQuestions);
		Log.info("Number of Questions"+noOfQuestions);
			   
		for(i=1;i<=noOfQuestions;i++){
			
		 AssessmentAt0.clickNext(driver,i).click();
		 Thread.sleep(3000);
		 }  
			
		AssessmentAt0.clickSubmit(driver).click();
		AssessmentAt0.gradeEvaluation(driver).click();
		driver.close();
	    driver.switchTo().window(parentWindow);
		}
					
	}
}
	}
	
}



