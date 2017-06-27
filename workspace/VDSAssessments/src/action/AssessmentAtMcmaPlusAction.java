package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import module.AssessmentAt0;
import module.AssessmentAtAllMcma;
import module.AssessmentAtMcmaplus;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelRead;

public class AssessmentAtMcmaPlusAction {
	
public static int h = 1;
	
	public static int i = 1;
	
	public static  void executeSelectingExams(WebDriver driver) throws Exception
	{	
		
		XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
		String numberofcoursesinexams = XcelRead.getCellData(10,0);
		
		Log.info("Number of courses	:     "+numberofcoursesinexams);
	    int y = Integer.parseInt(numberofcoursesinexams.trim()); 
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
	    
		for(int h=4;h<=y;h++)
		{
			
			AssessmentAtMcmaplus.selectAssignment(driver,h).click();
		    Thread.sleep(1000);
		    driver.switchTo().frame(1);
		    Thread.sleep(1000);
		    
		    int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
			
			loopbreak:		
			for (int f=1;f<=languageSize;f++)
			{
				String lang= AssessmentAtMcmaplus.listLanguageSelection(driver,f).getText();
				System.out.println("language: "+lang);
				Log.info("language: "+lang);
					
				XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
				String languageName = XcelRead.getCellData(10,1);

				if(lang.equals(languageName))
				{
					AssessmentAtMcmaplus.takeAssessment(driver, f).click();
					
//					AssessmentAtMcmaplus.retakeAssessment(driver, f).click();
					
					break loopbreak;
				}	
			}
							
				    driver.switchTo().activeElement();
				    Thread.sleep(1000);
				    
				    
		    String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for ( String windowHandle : handles)
			{
				if (!windowHandle.equals(parentWindow)) 
				{
					driver.switchTo().window(windowHandle);
					Thread.sleep(1000);
					
                    System.out.println("---------------------Begin Assessment------------------  ");
					
                    AssessmentAtMcmaplus.clickContinue(driver).click();
					Thread.sleep(1000);
					    
				  if(AssessmentAtMcmaplus.loadingPT(driver) > 0)
				{
					Robot object=new Robot();
					object.keyPress(KeyEvent.VK_DOWN);
					object.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(3000);
					System.out.println("Select Save File:");
					Log.info("Select Save File:");
						   
					object.keyPress(KeyEvent.VK_ENTER);
					object.keyRelease(KeyEvent.VK_ENTER);
						    
					AssessmentAtMcmaplus.skipPT(driver).click();
					System.out.println("Skip Packet Tracer");
						   
					Alert alert = driver.switchTo().alert();
					driver.switchTo().alert();
					alert.accept();
						   
				}
									
			else
			{
				   System.out.println("No packet tracer found");
				   Log.info("No packet tracer found");
						   
				   AssessmentAtMcmaplus.clickBeginAssessment(driver).click();
			}  

					
		int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
		System.out.println("Number of Questions"+noOfQuestions);
		
		XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
		String chooseThree = XcelRead.getCellData(10,3); 
		System.out.println(chooseThree);
		
		XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
		String chooseTwo = XcelRead.getCellData(10,2); 
		System.out.println(chooseTwo);

	    int j=1;
        List <WebElement> listOfItems=null;
        for( int m=1;m<=noOfQuestions;m++)
       {	
        	
        	if(AssessmentAtMcmaplus.testlet(driver)== true)
        	{
        		System.out.println("Question is testlet");
        	}
        	   
        	else if(AssessmentAtMcmaplus.checkMCMA(driver)== true)
			{
				String questiontext= AssessmentAtMcmaplus.question(driver,m).getText();
				System.out.println("QuestionText "+questiontext);
				
				if(questiontext.contains(chooseTwo))
				{
					listOfItems = driver.findElements(By.xpath("//input[@type='CHECKBOX']")); 
					System.out.print("No. of checkboxes: "+listOfItems);
					System.out.print("Total no. of checkbox size : " +listOfItems.size());
					
					WebDriverWait wait = new WebDriverWait(driver, 20); //Wait time of 20 seconds
					
				for (int i=j; i<=j+2; i++) 
				{
					
					listOfItems.get(i).click();
					driver.manage().timeouts().implicitlyWait(04, TimeUnit.SECONDS); 
					System.out.print("Checkbox ID: " +i); 
							
				}
						
				j=j+5;      
					
				} 
					
				else if(questiontext.contains(chooseThree))
				{	
								
				  listOfItems = driver.findElements(By.xpath("//input[@type='CHECKBOX']")); 
						
				  WebDriverWait wait = new WebDriverWait(driver, 20); //Wait time of 20 seconds
						
				  for (int i=j; i<=j+3; i++) 
				 {
					listOfItems.get(i).click();
					driver.manage().timeouts().implicitlyWait(04, TimeUnit.SECONDS); 
					System.out.print("Checkbox ID: " +i); 				
						
				 }
						
				j=j+6;      
								
				}
								     
				System.out.println("Print checkbox count: "+j);
				Thread.sleep(1000);  
			}
		
	
	         AssessmentAtMcmaplus.nextbutton(driver).click();
	         Thread.sleep(1000);
	         System.out.print( "Total no. of checkbox size after next button: "+listOfItems); 
       }
    
             AssessmentAtMcmaplus.submit(driver).click();
             AssessmentAtMcmaplus.gradeEvaluation(driver).click();
	         driver.close();
	
             driver.switchTo().window(parentWindow);
             driver.switchTo().activeElement();
             AssessmentAtMcmaplus.assessmentsLink(driver).click();
	
						
					}	
	}
		}
		
	}}
	


