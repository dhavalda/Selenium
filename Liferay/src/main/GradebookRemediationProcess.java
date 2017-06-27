package main;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.UrlXcelPath;
import utility.XcelReadWrite;
import action.AssessmentLinkSetupAction;
import action.GradebookRemediationActionLiferay;
import action.GradebookRemediationActionNetacad;
import action.InstructorLoginAction;
import action.SelectCourseAction;
import action.StudentPerformanceSummaryActionLiferay;
import action.StudentPerformanceSummaryActionNetacad;

public class GradebookRemediationProcess {
	
	
	public static WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();
	
@BeforeClass
public void beforeClass() {
	
	DOMConfigurator.configure("log4j.xml");
	System.setProperty("webdriver.firefox.marionette", "I:\\Automation-SeleniumUnicon\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
	
//  @Test(priority = 0)
  public void gradeBookNetacad() throws Exception {
	  
	driver.get(UrlXcelPath.netacadUrl);
	  
	XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
	 
	InstructorLoginAction.executeInstructorLogin(driver);
	 
////    SelectCourseAction.CourseSelection(driver);
	 
	GradebookRemediationActionNetacad.executeGradebook(driver);
	
    StudentPerformanceSummaryActionNetacad.executePerformanceSummary(driver);
	   
  }
  
  
  @Test(priority = 0)
  public void gradeBookLiferay() throws Exception {
	  
	
	driver.get(UrlXcelPath.liferayUrl);
	  
	XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
	 
	InstructorLoginAction.executeInstructorLogin(driver);
	 	 
//	GradebookRemediationActionLiferay.executeGradebookLiferay(driver);
	
    StudentPerformanceSummaryActionLiferay.executePerformanceSummaryLiferay(driver);
	   
  }
  
  

}
