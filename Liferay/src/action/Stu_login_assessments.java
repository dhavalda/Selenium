package action;

import modules.Login;

import org.openqa.selenium.WebDriver;

import utility.Log;
import utility.XcelReadWrite;


public class Stu_login_assessments {
	
	public static void Readexcel(WebDriver driver) throws Exception {
		 
		
		String instructorUserName = XcelReadWrite.getCellData(1,1);

		String instructorPassword = XcelReadWrite.getCellData(1,2);
		
		Login.LoginLink(driver).click();
		Login.Username(driver).sendKeys(instructorUserName);
		Login.Password(driver).sendKeys(instructorPassword);
		Login.LoginButton(driver).click();
		
		
		Log.info("UserName"+instructorUserName);

		Log.info("Password"+instructorPassword);
		
		
		
    }


}
