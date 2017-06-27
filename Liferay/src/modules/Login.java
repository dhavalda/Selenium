package modules;
 
		import org.openqa.selenium.*;

import utility.Log;

 
	public class Login {
 
			public static WebElement element = null;
 
        public static WebElement LoginLink(WebDriver driver){
 
            element = driver.findElement(By.xpath("//*[@id='headerLoginLink']"));
 
            Log.info("Username text box found");
 
            return element;
            
 
            }
 
        public static WebElement Username(WebDriver driver){

 
            //element = driver.findElement(By.xpath("//div[@id='loginmodal']/div/div/div[2]/form/fieldset/div/div/input"));
        	element = driver.findElement(By.xpath("//input[@id='_58_INSTANCE_fm_login']"));
			Log.info("Password text box found");
 
            return element;
 
            }
 
        public static WebElement Password(WebDriver driver){

            element = driver.findElement(By.xpath("//*[@id='_58_INSTANCE_fm_password']"));
 
		Log.info("Submit button found");
 
            return element;
 
            }
        
        public static WebElement LoginButton(WebDriver driver){
        	 
            element = driver.findElement(By.xpath("//*[@id='modal-buttons-container']/button[2]"));
 
		Log.info("Submit button found");
 
            return element;
 
            }
        

        
       
        
        }