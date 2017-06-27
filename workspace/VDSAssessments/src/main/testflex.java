package main;
import java.io.Console;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import action.FlashInteractor;
 
 
public class testflex<var> {
 
 
 private final static String GREEN = "GREEN";
 private final static String BLUE = "BLUE";
 private final static String RED = "RED";
 private final static String URL = "http://review.netacad.net/review2.0/courses/RouteSwitch6/en/trunk/#9.2.3.5";
 
 @Test
 public void TestColor() throws InterruptedException{
	 System.setProperty("webdriver.firefox.marionette", "I:\\Automation-SeleniumUnicon\\geckodriver.exe");
		System.setProperty("java.net.preferIPv4Stack" , "true");
 FirefoxDriver driver = new FirefoxDriver();
 driver.manage().window().maximize();
 Thread.sleep(20000L);
 
 FlashInteractor flashApp = new FlashInteractor(driver, "flashObject");
 
 driver.get(URL);
 
 //Assert.assertEquals("Clicking Colors", driver.getTitle());
 Thread.sleep(20000L);

 
 
// Assert.assertEquals(GREEN, flashApp.callFlashObject("getColor"));
// flashApp.callFlashObject("click");
 Thread.sleep(10000L);
// Assert.assertEquals(BLUE, flashApp.callFlashObject("getColor"));
// flashApp.callFlashObject("click");
// Thread.sleep(10000L);
// Assert.assertEquals(RED, flashApp.callFlashObject("getColor"));
// flashApp.callFlashObject("click");
// Thread.sleep(10000L);
// Assert.assertEquals(GREEN, flashApp.callFlashObject("getColor"));
 
 driver.quit();
 }




 
 
}