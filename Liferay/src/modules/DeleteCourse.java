package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.XcelReadWrite;


public class DeleteCourse {
	static WebElement element = null;
	public  static int q=0;
	 


	public static WebElement course_link(WebDriver driver) throws Exception{
    			
		
		String elem = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul")).getText();
		System.out.println("test: "+elem);
		String[] elemarray = elem.split("\\n");
		//System.out.println("coursename from get text beforeif"+elemarray);
		String coursename = XcelReadWrite.getCellData(4,2);
		System.out.println("coursename from get text beforeif"+coursename);
		
		
		breakloop:
			for(int j=1; j<= elemarray.length; j++) 
			{
				
				String elementvalue = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+j+"]/table/tbody/tr/td[1]/a")).getText();
				System.out.println("element  "+elementvalue);
				
				if (elementvalue.equals(coursename))
				{
					System.out.println("coursename from get text "+coursename);
					System.out.println("position from get text "+j);
		
					q=j;
					break breakloop;
				}
				
				
			}
			
			//element = driver.findElement(By.xpath("//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-theme/images/common/gearEdit.png')]"));
	           element = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+q+"]/table/tbody/tr/td[1]/a"));
	        return element;

	        }
public static WebElement setting_link(WebDriver driver){
    	

        element = driver.findElement(By.xpath(".//*[@id='section-tabs']/li[15]/a"));

        return element;

        }

public static WebElement delete_button(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='right-side']/div/a[5]"));

    return element;

    }
public static WebElement delete_course_button(WebDriver driver){
	

    element = driver.findElement(By.xpath(".//*[@id='content']/div/form/div[2]/button"));

    return element;

    }
}