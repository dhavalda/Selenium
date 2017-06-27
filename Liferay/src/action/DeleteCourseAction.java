package action;

import modules.AddStudent;
import modules.DeleteCourse;

import org.openqa.selenium.WebDriver;




public class DeleteCourseAction {
	public static void Execute6(WebDriver driver) throws Exception 
	{

	DeleteCourse.course_link(driver).click();
	DeleteCourse.setting_link(driver).click();
	DeleteCourse.delete_button(driver).click();
	DeleteCourse.delete_course_button(driver).click();
}

	//public static void Execute6(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
