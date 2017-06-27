package action;

import modules.CreateCourse;
import modules.SelectCourse;

import org.openqa.selenium.WebDriver;


public class SelectCourseAction {
	
	public static void CourseSelection(WebDriver driver) throws Exception 
	{
		driver.switchTo().activeElement();
//	    CreateCourse.teachTab(driver).click();
		SelectCourse.select_link(driver).click();
		Thread.sleep(2000);
		
	
	}
}
