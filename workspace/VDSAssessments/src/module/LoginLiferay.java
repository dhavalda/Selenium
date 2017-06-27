package module;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class LoginLiferay {
		 
		public static WebElement element = null;

    public static WebElement LoginLink(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id='headerLoginLink']"));

        System.out.println("Username text box found");

        return element;
        

        }

    public static WebElement Username(WebDriver driver){


        //element = driver.findElement(By.xpath("//div[@id='loginmodal']/div/div/div[2]/form/fieldset/div/div/input"));
    	element = driver.findElement(By.xpath("//input[@id='_58_INSTANCE_fm_login']"));
		System.out.println("Password text box found");

        return element;

        }

    public static WebElement Password(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id='_58_INSTANCE_fm_password']"));

        System.out.println("Submit button found");

        return element;

        }
    
    public static WebElement LoginButton(WebDriver driver){
    	 
        element = driver.findElement(By.xpath("//*[@id='modal-buttons-container']/button[2]"));

        System.out.println("Submit button found");

        return element;

        }
    
    public static Select selectGoal(WebDriver driver){
			
	Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_goal-required-questions']")));
	return dropdown;
    	
    }
    
    public static Select selectmyExperience(WebDriver driver){
			
 	Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_experience-required-questions']")));
	System.out.println(dropdown);                            
	    
	return dropdown;
  }
    
    public static Select selectGender(WebDriver driver){
		
	Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_gender']")));
	return dropdown;

 }
    
    public static Select selectRace(WebDriver driver){
		      
	Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='raceStatus']")));
	return dropdown;

 }
	public static Select selectMilitaryService(WebDriver driver){
		
    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='veteranStatus']")));
	return dropdown;
	    
}
	public static WebElement optMailSurvey(WebDriver driver){
		
	element = driver.findElement(By.xpath(".//*[@id='subscribeNo']"));
    return element;

}
	public static WebElement optMyContact(WebDriver driver){
		
	element = driver.findElement(By.xpath(".//*[@id='agreedToShareNo']"));
	return element;

}
	
    public static WebElement nextButton(WebDriver driver){
		
	element = driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_fm']/div[4]/div/button"));
    return element;

}
    
    public static WebElement selectCourse(WebDriver driver){
		
    	element = driver.findElement(By.xpath(".//*[@id='netacad-atlantic-view']/div[3]/div[1]/div/a/div[2]/div[2]/div[1]"));
//    	.//*[@id='netacad-atlantic-view']/div[3]/div[1]/a/div[2]/div[2]/div[1]
//    	//div[@id='netacad-atlantic-view']/div[3]/div/a/div[2]/div[2]/div
        return element;

    }
    
    
    public static WebElement clickAssignment(WebDriver driver){
    
    element = driver.findElement(By.xpath("//a[@aria-label='Course Assignments']"));
    return element;
    
    }
 }


