package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateCourse {
	
	static WebElement element = null;
	
	public static WebElement dropdown=null;
	
	public static WebElement createCourseLink(WebDriver driver){
		  
        element = driver.findElement(By.xpath("//*[@id='_omni_WAR_omniportlet_create-a-course']"));

        return element;
        }
	
	
	public static Select selectAcademy(WebDriver driver)
	{
		 
        Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_rootAccountId']")));
        
        return dropdown;
        
	}
        
	public static WebElement courseName(WebDriver driver){
		 
        element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_shortName']"));

        return element;
         }
	
	public static WebElement courseId(WebDriver driver){
		 
        element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_courseId']"));
        
        return element;
   
}

	
	public static Select selectCourse(WebDriver driver){

        Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_offeringId']")));
        return dropdown;
	}
	
	public static Select selectLanguageVersion(WebDriver driver){
		 
       
	Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_cvlValue']")));
        return dropdown;
          
	}
		
	public static WebElement startDate(WebDriver driver){
		 
        element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_startDate']"));
        return element;
	}
	
	public static WebElement endDate(WebDriver driver){
		 
        element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_concludeDate']"));

        return element;
	}
	
	public static Select  defaultInstructor(WebDriver driver){
		 
		Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_instructor']")));
        
        return dropdown;
	}
	
	public static WebElement saveCreateCourse(WebDriver driver){
		 
        element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_save']"));

        return element;
	}
	
	public static WebElement closed(WebDriver driver){

	       element = driver.findElement(By.xpath("//a[contains(.,'Teach')]"));

	       return element;
	}
	
	public static int close(WebDriver driver){

		  int     element = driver.findElements(By.xpath("//button[contains(.,'×')]")).size();

		       return element;
		}
	
	public static WebElement teachTab(WebDriver driver){

	       element = driver.findElement(By.xpath("//a[contains(.,'Teach')]"));

	       return element;
	}
}
