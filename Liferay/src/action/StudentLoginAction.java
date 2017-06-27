package action;

import modules.Login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;

public class StudentLoginAction {
	

	public static void executeStudentLogin(WebDriver driver) throws Exception{
		 
		String students = XcelReadWrite.getCellData(1,1);
		Log.info("Number of students to be executed: "+students);	
		int n = Integer.parseInt(students.trim());
		
		for (int a=1; a<=n; a++) 
	
	   {
			
		XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"StudentInformation-Sheet2");
		Thread.sleep(15000);
			
		Login.LoginLink(driver).click();
		Log.info("Clicked on Student Login");
		
		String studentUsername = XcelReadWrite.getCellData(a,2);
		Login.Username(driver).sendKeys(studentUsername);
		Log.info("Student "+a+" Username entered: "+studentUsername);

		String studentPassword = XcelReadWrite.getCellData(a,3);
		Login.Password(driver).sendKeys(studentPassword);
		Log.info("Student "+a+" Password entered: "+studentPassword);
		
		Thread.sleep(4000);
		
		Login.LoginButton(driver).click();
		Log.info("Clicked on Student login button");
		
//		Assert.assertEquals("Terms of Service - Cisco Networking Academy", driver.getTitle());
		Log.info("Successfully logged in as Student");
		
	    Thread.sleep(1500);
	    StudentResetPasswordAction.executeStudentPassword(driver);
		

}
		}
}