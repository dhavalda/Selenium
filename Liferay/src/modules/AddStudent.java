package modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utility.UrlXcelPath;
import utility.XcelReadWrite;


public class AddStudent {
	static WebElement element = null;
	public  static int p=0;
	 

	public static WebElement editCourse(WebDriver driver) throws Exception{
    	
		System.out.println("Into edit course now");
		Thread.sleep(30000);
		
		String elem = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul")).getText();
		
	    XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"StudentInformation-Sheet2");

		
		System.out.println("test: "+elem);
		String[] elemarray = elem.split("\\n");
		String coursename = XcelReadWrite.getCellData(1,0);
		System.out.println("coursename from get text before if : "+coursename);
		
		breakloop:
		for(int i=1; i<= elemarray.length; i++) 
		{
			
			String elementvalue = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+i+"]/table/tbody/tr/td[1]/a")).getText();
			System.out.println("coursename:  "+elementvalue);

//			 driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+i+"]/table/tbody/tr/td[1]/a")).getText();
			if (elementvalue.equals(coursename))
			{
				System.out.println("coursename from get text "+coursename);
				System.out.println("position from get text "+i);
	
				p=i;
				break breakloop;
			}
			
			
		}
		
		//element = driver.findElement(By.xpath("//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-theme/images/common/gearEdit.png')]"));
//           element = driver.findElement(By.xpath("(//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-theme/images/common/gearEdit.png')])["+p+"]"));
           
//		element = driver.findElement(By.xpath("//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-2016-theme/images/common/gearEdit.png')]["+p+"]"));
        element = driver.findElement(By.xpath("//li["+p+"]/table/tbody/tr/td[3]/a/img"));
        
//        element = driver.findElement(By.xpath("(//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-2016-theme/images/common/gearEdit.png')])["+p+"]"));
        return element;
		
//		return element;
        

        }
public static WebElement editStudent(WebDriver driver){
    	

        element = driver.findElement(By.xpath("//*[@id='student-settings-trigger']"));

        return element;

        }

public static WebElement addNewStudent(WebDriver driver){
	

    element = driver.findElement(By.xpath("//*[@id='addNewStudents']"));

    return element;

    }

public static WebElement firstName(WebDriver driver){
	

    element = driver.findElement(By.xpath("//*[@id='firstName0']"));

    return element;

    }

public static WebElement lastName(WebDriver driver){
	

    element = driver.findElement(By.xpath("//*[@id='lastName0']"));

    return element;

    }

public static WebElement studentMailId(WebDriver driver){
	

    element = driver.findElement(By.xpath("//*[@id='emailAddress0']"));

    return element;

    }
public static WebElement addNextStudent(WebDriver driver){
	

    element = driver.findElement(By.xpath("//*[@id='addButton0']"));

    return element;

    }
public static WebElement saveStudent(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='_omni_WAR_omniportlet_saveAllEnrollments']"));

    return element;

    }

public static void  logout(WebDriver driver){
	

   Actions actions = new Actions(driver);
   WebElement mainMenu = driver.findElement(By.xpath("//header[@id='banner']/nav/div/div/ul/li[5]"));
   actions.moveToElement(mainMenu);

   WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
   actions.moveToElement(subMenu);
   actions.click().build().perform(); 

}

public static WebElement addCsvFile(WebDriver driver){
	
	element = driver.findElement(By.xpath(".//*[@id='uploadCSV']"));
	return element;
	
}

public static WebElement browseCsvFile(WebDriver driver){
	
	element = driver.findElement(By.xpath("//div/input"));
	
	return element;
	
}

public static WebElement uploadCsvFile(WebDriver driver){
	
	element = driver.findElement(By.xpath("//button"));

	return element;
	
}


}

