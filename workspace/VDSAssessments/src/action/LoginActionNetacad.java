package action;

	import java.awt.Robot;
import java.awt.event.KeyEvent;

import module.LoginLiferay;
import module.LoginNetacad;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelRead;

	 
	    
	 
	public class LoginActionNetacad {
	 
			public static void executeStudentLogin(WebDriver driver) throws Exception{
	 
		
				String studentUsername = XcelRead.getCellData(2,3);
	 
				String studentPassword = XcelRead.getCellData(2,4);
				
				LoginNetacad.LoginLink(driver).click();
				
				LoginNetacad.Username(driver).sendKeys(studentUsername);
				
				LoginNetacad.Password(driver).sendKeys(studentPassword);
				
				LoginNetacad.LoginButton(driver).click();
				
			    Thread.sleep(3000);
				
				
	        }
			
	   public static void executeStudentProfile(WebDriver driver) throws Exception{	
		   
		   String profile = driver.findElement(By.xpath(".//*[@id='banner-title']")).getText();
		   
		   XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
		   
		   Thread.sleep(5000);
		   
		   if(profile.contentEquals("My Profile")){
			   
			   String  goalExperience= XcelRead.getCellData(6,0);
		       LoginLiferay.selectGoal(driver).selectByVisibleText(goalExperience);
		       Log.info("Goal Experince is selected: "+goalExperience);
		       Thread.sleep(2000);
			   
			   String  myExperience= XcelRead.getCellData(6,1);
		       LoginLiferay.selectmyExperience(driver).selectByVisibleText(myExperience);
		       Log.info("IT Experince is selected: "+myExperience);
		       Thread.sleep(2000);
	        
		       String  gender= XcelRead.getCellData(6,2);
		       LoginLiferay.selectGender(driver).selectByVisibleText(gender);
		       Log.info("Gender is selected: "+gender);
		       Thread.sleep(2000);
		       
		       LoginLiferay.nextButton(driver).click();
		 	  
		   }
		   
			   
			   ((JavascriptExecutor) driver).executeScript("scroll(0,250)");
			   LoginNetacad.selectCourse(driver).click();
		       System.out.println("Course name");
		       Thread.sleep(3000);
//		       Login.clickAssignment(driver).click();
		  
		   }   
			     
		  
	   }
			
	 



