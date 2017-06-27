package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StudentResetPassword {
	
	static WebElement element = null;


	public static WebElement checkTerms(WebDriver driver){
		
		
	    element = driver.findElement(By.xpath(".//*[@id='termsOfUse']"));

	    return element;

	    }


	public static Select selectCountry(WebDriver driver){
		
		
	    
	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='countryId']")));
	    
	    return dropdown;

	    }

	public static Select selectState(WebDriver driver){
		
	    
	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='stateId']")));
	    return dropdown;
	   

	    }

	public static WebElement enterDateOfBirth(WebDriver driver){
		
		
	    element = driver.findElement(By.xpath(".//*[@id='birthDate']"));


	    return element;

	    }



	public static Select selectTimeZone(WebDriver driver){
		
		
	    Select dropdown =new Select(driver.findElement(By.xpath(".//*[@id='timeZoneId']")));


	    return dropdown;

	    }

	public static Select selectItExperience(WebDriver driver){
		
		
	   
	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_experience-required-questions']")));
	    
	    System.out.println(dropdown);
	    
	    return dropdown;
	    
	    

	    }
	public static Select selectGoal(WebDriver driver){
		
		
	   
//	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='goal']")));
//	    return dropdown;
		
		 Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_goal-required-questions']")));
	   return dropdown;

	    

	    }
	public static Select selectGender(WebDriver driver){
		
		
	   
	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_gender']")));
	    return dropdown;

	    
	    }
	public static Select selectRace(WebDriver driver){
		
		
	      
	    Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_race-select']")));
	    return dropdown;

	    }
	public static Select selectMilitaryService(WebDriver driver){
		
		
	        Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_veteranStatus']")));
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

	public static WebElement clickSubmit(WebDriver driver)

	{
		
		
	    element = driver.findElement(By.xpath(".//*[@id='submitButton']"));

	    return element;

	    }

	public static WebElement newPassword(WebDriver driver)

	{
		
		
	    element = driver.findElement(By.xpath(".//*[@id='password_1']"));

	    return element;

	    }

	public static WebElement confirmPassword(WebDriver driver)

	{
		
		
	    element = driver.findElement(By.xpath(".//*[@id='password_2']"));

	    return element;

	    }
	public static WebElement savePassword(WebDriver driver)

	{
		
		
	    element = driver.findElement(By.xpath(".//*[@id='fm']/div[2]/button"));

	    return element;

	    }
	public static WebElement continueButton(WebDriver driver)

	{
		
		
	    element = driver.findElement(By.xpath(".//*[@id='nextButton']"));

	    return element;

	    }


	public static void signout(WebDriver driver)

	{
		
		
		Actions actions = new Actions(driver);
		  WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='navigation']/li[5]"));
		  actions.moveToElement(mainMenu);

		  WebElement subMenu = driver.findElement(By.xpath(".//*[@id='navigation']/li[5]/ul/li[5]/a"));
		  actions.moveToElement(subMenu);
		  actions.click().build().perform(); ;

	    }

	public static WebElement termsCondition(WebDriver driver){
		
		
	    element = driver.findElement(By.xpath("//div[3]/label/span"));

	    return element;

	    }

	public static WebElement acceptButton(WebDriver driver){
		
		
	    element = driver.findElement(By.xpath(".//*[@id='termsButton']"));

	    return element;

	    }

	public static WebElement nextButton(WebDriver driver){
		
		
	    element = driver.findElement(By.xpath(".//*[@id='_netacaduserprofile_WAR_netacaduserprofileportlet_fm']/button"));

	    return element;

	    }

	public static int popUp(WebDriver driver){


		int element = driver.findElements(By.xpath(".//*[@id='close-icon']")).size();

		return element;

		}
		public static WebElement popUpClose(WebDriver driver){


		element = driver.findElement(By.xpath(".//*[@id='close-icon']"));

		return element;

		}
		
		public static WebElement clickonpage(WebDriver driver)

		{


		   element = driver.findElement(By.xpath(".//*[@id='section_2']"));

		   return element;

		   }

	}
