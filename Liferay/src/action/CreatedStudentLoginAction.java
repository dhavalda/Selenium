package action;

import modules.CreatedStudentLogin;
import modules.Login;
import modules.StudentResetPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;


public class CreatedStudentLoginAction {

	
	public static void executeStudentLogin(WebDriver driver) throws Exception{
		
		XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"StudentInformation-Sheet2");
		String students = XcelReadWrite.getCellData(1,1);
		int n = Integer.parseInt(students.trim());
		
		for (int i=1; i<=n; i++) 
			
		{
			
		String studentUsername = XcelReadWrite.getCellData(i,2);

		String studentPassword = XcelReadWrite.getCellData(i,4);
		
		Login.LoginLink(driver).click();
		 Log.info("Clicked on Login");
		
		Login.Username(driver).sendKeys(studentUsername);
		Log.info("Username entered"+studentUsername);
		
		Thread.sleep(10000);
		
		Login.Password(driver).sendKeys(studentPassword);
		Log.info("password entered"+studentPassword);
		
		Login.LoginButton(driver).click();
		Log.info("Clicked on Submit button");
		
		Thread.sleep(10000);

//		Assert.assertEquals("Learn - Cisco Networking Academy", driver.getTitle());
		
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
		
//		StudentResetPassword.signout(driver);
//		Log.info("Successfully logged in as Student");
		}
		
		
		Log.info("Successfully  completion of Creation of Course , Adding of required number of Students and Resetting of required number of Students Password ");
}
}


