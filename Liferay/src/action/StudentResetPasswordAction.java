package action;

import modules.AddStudent;

import modules.StudentResetPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;


public class StudentResetPasswordAction {
	
	public static void executeStudentPassword(WebDriver driver) throws Exception {
		
		 XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"LoginAndSettingInfo-Sheet1");
			
		
//			StudentResetPassword.checkTerms(driver).click();
//			Log.info("Term and condition check box is checked");
		

			String countryName= XcelReadWrite.getCellData(7,1);
			Thread.sleep(10000);
			StudentResetPassword.selectCountry(driver).selectByVisibleText(countryName);
			Log.info("Country name is selected: "+countryName);
	    
			Thread.sleep(5000);
			String  stateName= XcelReadWrite.getCellData(7,2);
	        StudentResetPassword.selectState(driver).selectByVisibleText(stateName);
	        Log.info("State name is selected: "+stateName);
	    
	    
	        String  dob= XcelReadWrite.getCellData(7,3);
	        
	        StudentResetPassword.enterDateOfBirth(driver).sendKeys(dob);
	        Log.info("Entered Date of Birth: "+dob);
	        
	        
	        String newpassword=XcelReadWrite.getCellData(9,1);
	        StudentResetPassword.newPassword(driver).sendKeys(newpassword);
	        Log.info("Entered New password: "+newpassword);
	    
	        String confirmpassword=XcelReadWrite.getCellData(9,2);
	        StudentResetPassword.confirmPassword(driver).sendKeys(confirmpassword);
	        Log.info("Entered Confirm password: "+confirmpassword);
	        
	        StudentResetPassword.clickonpage(driver).click();
	        
	        StudentResetPassword.continueButton(driver).click();  
	        
	        StudentResetPassword.termsCondition(driver).click();
	        
	        StudentResetPassword.acceptButton(driver).click();
		 
//		    String  itExperience= XcelReadWrite.getCellData(7,4);
//	        StudentResetPassword.selectItExperience(driver).selectByVisibleText(itExperience);
//	        Log.info("IT Experince is selected: "+itExperience);
//	        
//	        String  goalExperience= XcelReadWrite.getCellData(7,5);
//	        StudentResetPassword.selectGoal(driver).selectByVisibleText(goalExperience);
//	        Log.info("Goal Experince is selected: "+goalExperience);
//	        
//	            
//	        String  gender= XcelReadWrite.getCellData(7,6);
//	        StudentResetPassword.selectGender(driver).selectByVisibleText(gender);
//	        Log.info("Gender is selected: "+gender);
//	        
//	        
//	        String  race= XcelReadWrite.getCellData(7,7);
//	        StudentResetPassword.selectRace(driver).selectByVisibleText(race);
//	        Log.info("Race is selected: "+gender);
//	        
//	        String  militaryService= XcelReadWrite.getCellData(7,8);
//	        StudentResetPassword.selectMilitaryService(driver).selectByVisibleText(militaryService);
//	        Log.info("Military Service is selected: "+militaryService);
//	        
//	       
//	        StudentResetPassword.nextButton(driver).click();
//	        Thread.sleep(3000);
	        
//	        StudentResetPassword.savePassword(driver).click();
	        if(StudentResetPassword.popUp(driver)>0)
	        {

	        System.out.println("Closed popup");
	        StudentResetPassword.popUpClose(driver).click();
	        }
	        else
	        {
	        System.out.println(" popup not closed");
	        }
	        
	        
	        StudentResetPassword.signout(driver);
	        
	        Log.info("Successfully logged out as Student");
	        
	        
	        
	        
	    
//	        String  timezone= XcelReadWrite.getCellData(7,9);
//	        StudentResetPassword.selectTimeZone(driver).selectByVisibleText(timezone);
//	        Log.info("TimeZone is selected: "+timezone);
//	        Thread.sleep(10000);
	    

	    
	    
	        
	    
//	    
//	    

//	    

//	    
//	        StudentResetPassword.optMailSurvey(driver).click();
//	        Log.info("Mail service option is selected ");
//	    	       
//	        StudentResetPassword.optMyContact(driver).click();
//	        Log.info("Contact option is selected ");
//	        
//	        StudentResetPassword.clickSubmit(driver).click();
//	        Log.info("Clicked on student profile Submit button");
	        
	    
	       
	    
	       // StudentResetPassword.savePassword(driver).click();
	     //   Log.info("Clicked on save password");
	        
	        
	        
}
	
}