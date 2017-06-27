package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import module.AssessmentAtAllMcma;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelRead;

public class AssessmentAtAllMcmaAction {
	
	
	public static int h = 1;
	
	public static int i = 1;
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
		
	   XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
	   String numberOfCoursesInExams = XcelRead.getCellData(10,0);
	   Log.info("Number of courses	:     "+numberOfCoursesInExams);
       int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
       Thread.sleep(9000);
       
	  
       for(h=14;h<=y;h++)
	   {
    	   
			driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
			
//			String url_assign = driver.getCurrentUrl();
//			   String newurl = url_assign+"/assignments";
//			   System.out.println(driver.getCurrentUrl());
//			   driver.get(newurl);
			   
			Thread.sleep(5000);
			AssessmentAtAllMcma.selectAssignment(driver, h).click();
			Thread.sleep(10000);
			
			driver.switchTo().frame(1);
		    
		int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
			
		loopbreak:		
		for (int f=1;f<=languageSize;f++)
		{
			String lang= AssessmentAtAllMcma.listLanguageSelection(driver,f).getText();
			System.out.println("language: "+lang);
			Log.info("language: "+lang);
				
			XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
			String languageName = XcelRead.getCellData(10,1);

			if(lang.equals(languageName))
			{
				AssessmentAtAllMcma.takeAssessment(driver, f).click();
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
				
				AssessmentAtAllMcma.clickContinue(driver).click();
			    
			    Thread.sleep(5000);
			    
			    if(AssessmentAtAllMcma.loadingPT(driver) > 0)
				{
				   Robot object=new Robot();
				   object.keyPress(KeyEvent.VK_DOWN);
				   object.keyRelease(KeyEvent.VK_DOWN);
				   Thread.sleep(3000);
				   System.out.println("Select Save File:");
				   Log.info("Select Save File:");
				   
				   object.keyPress(KeyEvent.VK_ENTER);
				   object.keyRelease(KeyEvent.VK_ENTER);
				    
				   AssessmentAtAllMcma.skipPT(driver).click();
				   System.out.println("Skip Packet Tracer");
				   
				   Alert alert = driver.switchTo().alert();
				   driver.switchTo().alert();
				   alert.accept();
				   
				}
							
				else
				{
				   System.out.println("No packet tracer found");
				   Log.info("No packet tracer found");
				   AssessmentAtAllMcma.clickBeginAssessment(driver).click();
				}  
			    
	    int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
		System.out.println("Number of Questions"+noOfQuestions);	   
			   
		for(i=1;i<=noOfQuestions;i++)
		{
			
//		int noOfCheckbox = driver.findElements(By.xpath("//tr[*]/td/input")).size();
//		System.out.println("No of check boxes" +noOfCheckbox);
//		  for (int j=1;j<=noOfCheckbox;j++)
//		  {
			if(AssessmentAtAllMcma.checkMCMA(driver)==true)
			{
			  List<WebElement> element = driver.findElements(By.xpath("//input[@type='CHECKBOX']"));
	          
			  for( WebElement check : element)
			  {
			  if(!check.isSelected())
			  {
			    check.click();
			    Thread.sleep(1000);
			  }
		      }
		   
//			  AssessmentAtAllMcma.clickNext(driver,i).click();
			  AssessmentAtAllMcma.nextButton(driver).click();
			  Thread.sleep(3000);

			}
		
			
			
		else{
//				AssessmentAtAllMcma.clickNext(driver,i).click();
				
				AssessmentAtAllMcma.nextButton(driver).click();
				Thread.sleep(3000);
			}
//		 AssessmentAtAllMcma.clickNext(driver,i).click();
////		 driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
//		 Thread.sleep(3000);
		 
		}  
//		Thread.sleep(3000);
		AssessmentAtAllMcma.clickSubmit(driver).click();
		AssessmentAtAllMcma.gradeEvaluation(driver).click();
		driver.close();
	    driver.switchTo().window(parentWindow);
		}
					
	}
}
	}
	
}
	



