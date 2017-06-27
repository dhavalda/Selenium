package main;
 
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.UrlXcelPath;
import utility.XcelReadWrite;
import action.AddStudentAction;
import action.AssessmentLinkSetupAction;
import action.CreateCourseAction;
import action.CreatedStudentLoginAction;
import action.InstructorLoginAction;
import action.SelectCourseAction;
import action.StudentLoginAction;

 
public class StageClassSetup {
    	

public static WebDriver driver = null;
private StringBuffer verificationErrors = new StringBuffer();
	
@BeforeClass
 public void setUp() throws Exception {
	  DOMConfigurator.configure("log4j.xml");
	  System.setProperty("webdriver.firefox.marionette", "I:\\Automation-SeleniumUnicon\\Software\\geckodriver-v0.10.0-win64\\geckodriver.exe");
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
  }

//@Test  (priority = 0) 
public void testUntitled() throws Exception {
	
	driver.get(UrlXcelPath.liferayUrl);      
     //This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
//    XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"LoginAndSettingInfo-Sheet1");
//	System.out.println("LoginAndSettingInfo-Sheet1"+UrlXcelPath.xcelFileName);	
// login as an instructor	
//    InstructorLoginAction.executeInstructorLogin(driver);
//    create course
//    CreateCourseAction.executeCreateCourse(driver);
    // read student information from excel
    XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"StudentInformation-Sheet2");
   
//	   add n student and get temp password         
//    AddStudentAction.executeAddStudent(driver);
    //update password and edit profile
    StudentLoginAction.executeStudentLogin(driver);
     // login as student and assert new password       
            
//    CreatedStudentLoginAction.executeStudentLogin(driver);
			
         
            
       }

@Test (priority = 0)

public void assessmentlink() throws Exception {
	
	driver.get(UrlXcelPath.liferayUrl);
	  
	XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"LoginAndSettingInfo-Sheet1");
	 
	InstructorLoginAction.executeInstructorLogin(driver);
	 
  	SelectCourseAction.CourseSelection(driver);
	
//	AssessmentLinkSetupAction.addingAssessmentLinks(driver);
	
	AssessmentLinkSetupAction.activatingExams(driver);
	
//	driver.close();

	   
}

		
    }
