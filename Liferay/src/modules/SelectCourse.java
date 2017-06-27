package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.XcelReadWrite;


public class SelectCourse {
	
	static WebElement element = null;
	static int p=0;
	
	public static WebElement select_link(WebDriver driver) throws Exception{
		System.out.println("Into edit course now");
		 Thread.sleep(10000);
		 //String element1 = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[1]/ul/li[2]/a")).getText();
		 String element1 = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul")).getText();
		 
		// String element1 = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[1]/ul")).getText();
		//element1 refers to the courselist xpath
		String[] elementarray = element1.split("\\n");
		//Split coursename into an array
		Log.info("element1element1 "+element1);
		String coursename = XcelReadWrite.getCellData(4,2);
		//select course name from excel
		breakloop:
			
			for(int i=1;i<=elementarray.length;i++)
			{
				//String elementvalue = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[1]/ul/li["+i+"]/a")).getText();
				//locating the coursename using the list .//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li[4]/table/tbody/tr/td[1]/a
				String elementvalue = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+i+"]/table/tbody/tr/td[1]/a")).getText();
				if (elementvalue.equals(coursename))
				{
					Log.info("Course name from excel"+coursename);
					Log.info("Position of coursename"+i);
					p=i;
					break breakloop;
					
				}
			}
		element = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+p+"]/table/tbody/tr/td[1]/a"));
		//element = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[1]/ul/li["+p+"]/a"));
		return element;
		   

	}

	}
	

