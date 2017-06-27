package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.XcelReadWrite;


public class CreatedStudentLogin {
	
	static WebElement element = null;
	 
    public static WebElement StudentLoginLink(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id='headerLoginLink']"));
        return element;
        
        }

    public static WebElement StudentName(WebDriver driver){
    	
        element = driver.findElement(By.xpath("//div[@id='loginmodal']/div/div/div[2]/form/fieldset/div/div/input"));
		  return element;

        }

    public static WebElement StudentPassword(WebDriver driver){
    	
        element = driver.findElement(By.xpath("//*[@id='_58_INSTANCE_fm_password']"));
        return element;

        }
    
    public static WebElement LoginButton(WebDriver driver){
    	 
        element = driver.findElement(By.xpath("//*[@id='modal-buttons-container']/button[2]"));
	   return element;

        }
    
    public static void logOut(WebDriver driver)

    {
//    	element = driver.findElement(By.xpath("//li[5]/ul/li[3]/a"));
// 	   return element;
    	
    	   Actions actions = new Actions(driver);
    	   WebElement mainMenu = driver.findElement(By.xpath("//header[@id='banner']/nav/div/div/ul/li[5]"));
    	   actions.moveToElement(mainMenu);

    	   WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
    	   actions.moveToElement(subMenu);
    	   actions.click().perform();
    	   

        }
    
    public static int popUp(WebDriver driver){


		int element = driver.findElements(By.xpath(".//*[@id='close-icon']")).size();

		return element;

		}
		public static WebElement popUpClose(WebDriver driver){


		element = driver.findElement(By.xpath(".//*[@id='close-icon']"));

		return element;

		}
   
    }
	

		