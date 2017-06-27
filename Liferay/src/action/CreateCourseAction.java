package action;


import java.text.SimpleDateFormat;

import modules.AddStudent;
import modules.CreateCourse;
import modules.Login;

import org.apache.james.mime4j.field.datetime.parser.ParseException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.WebDriver;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import utility.XcelReadWrite;




public class CreateCourseAction {
	

	public static void executeCreateCourse(WebDriver driver) throws Exception{
		 
	
		CreateCourse.createCourseLink(driver).click();
		
		driver.switchTo().frame(0);
		
		String selectedAcademy = XcelReadWrite.getCellData(4,1);
		 
		String selectedCourseName = XcelReadWrite.getCellData(4,2);
		
		String selectedCourseId = XcelReadWrite.getCellData(4,3);
		
		String selectedCourse = XcelReadWrite.getCellData(4,4);
		
		String selectedCourseLanguage=XcelReadWrite.getCellData(4,5);
						
		String startDate=XcelReadWrite.getCellData(4,6);
					
		String endDate=XcelReadWrite.getCellData(4,7);
		
		String instructorName=XcelReadWrite.getCellData(4,8);

	
		CreateCourse.selectAcademy(driver).selectByVisibleText(selectedAcademy);
         
		CreateCourse.courseName(driver).sendKeys(selectedCourseName);
         
		CreateCourse.courseId(driver).sendKeys(selectedCourseId);
         
		CreateCourse.selectCourse(driver).selectByVisibleText(selectedCourse);
        
		CreateCourse.selectLanguageVersion(driver).selectByVisibleText(selectedCourseLanguage);
		
		Thread.sleep(5000);
        
		CreateCourse.startDate(driver).sendKeys(startDate);
        
		CreateCourse.endDate(driver).sendKeys(endDate);
        
		CreateCourse.defaultInstructor(driver).selectByVisibleText(instructorName);
        
		CreateCourse.saveCreateCourse(driver).click();
		
		if(CreateCourse.close(driver)>0)
		{
		CreateCourse.closed(driver).click();
		}
		
       
         Thread.sleep(30000);
         driver.switchTo().defaultContent();
		
}
	
}
