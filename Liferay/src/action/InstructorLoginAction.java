

package action;
 

import modules.Login;


import org.openqa.selenium.WebDriver;

import utility.XcelReadWrite;

 
    
 
    public class InstructorLoginAction {
 
		public static void executeInstructorLogin(WebDriver driver) throws Exception{
 
	
			String instructorUsername = XcelReadWrite.getCellData(1,1);
 
			String insturctorPassword = XcelReadWrite.getCellData(1,2);
			
			Login.LoginLink(driver).click();
			
			Login.Username(driver).sendKeys(instructorUsername);
			
			Login.Password(driver).sendKeys(insturctorPassword);
			
			Thread.sleep(4000);
 
			Login.LoginButton(driver).click();
			
			Thread.sleep(10000);
			
			
        }
 
}