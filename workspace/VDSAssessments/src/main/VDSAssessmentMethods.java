package main;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import action.AssessmentAt0Action;
import action.AssessmentAt0NetacadAction;
import action.AssessmentAt100Action;
import action.AssessmentAt100Action2_old;
import action.AssessmentAtAllMcmaAction;
import action.AssessmentAtMcma3Action;
import action.AssessmentAtMcmaPlusAction;
import action.LoginActionLiferay;
import action.LoginActionNetacad;
import action.mcmaplus;
import action.trail;

import utility.UrlXcelPath;
import utility.XcelRead;


public class VDSAssessmentMethods {
	
	public static WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();
	
@Before
	public void beforeClass() {
		
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.firefox.marionette", "I:\\Automation-SeleniumUnicon\\geckodriver.exe");
		System.setProperty("java.net.preferIPv4Stack" , "true");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }

@Test

public void assessmentsLiferay() throws Exception {
	
	driver.get(UrlXcelPath.liferayUrl);
	
	Thread.sleep(5000);
	
	XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
	System.out.println("Login-Sheet1"+UrlXcelPath.xcelFileName);
	
	LoginActionLiferay.executeStudentLogin(driver);
	
	LoginActionLiferay.executeStudentProfile(driver);
	
//	AssessmentAtMcma3Action.executeSelectingExams(driver);
	
	AssessmentAt100Action.executeSelectingExams(driver);
	
//	AssessmentAt100Action2_old.executeSelectingExams(driver);
	
//	trail.executeSelectingExams(driver);
	
//	AssessmentAtMcmaPlusAction.executeSelectingExams(driver);
	
//	AssessmentAtAllMcmaAction.executeSelectingExams(driver);
	
//	mcmaplus.executeSelectingExams(driver);
	
  }

}