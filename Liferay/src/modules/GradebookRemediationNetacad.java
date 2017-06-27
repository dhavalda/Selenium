package modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.UrlXcelPath;
import utility.XcelReadWrite;

//import action.List;

public class GradebookRemediationNetacad {
	
private static final String Webdriver = null;
	
static WebElement element= null;

public static int q;

public static WebElement coursesSelection(WebDriver driver) throws Exception{
   	
	XcelReadWrite.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelGradeBook,"Sheet1");
	String elem = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul")).getText();
	System.out.println("test: "+elem);
	String[] elemarray = elem.split("\\n");
	System.out.println("coursename from get text beforeif---    "+elemarray);
	String coursename = XcelReadWrite.getCellData(1,3);
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
	System.out.println("value of q "+q);
	break breakloop;
	}


	}
	System.out.println("value of q outside loop"+q);
	//element = driver.findElement(By.xpath("//img[contains(@src,'https://dw0c9hjnocf9j.cloudfront.net/liveaxle-theme/images/common/gearEdit.png')]"));
	element = driver.findElement(By.xpath(".//*[@id='p_p_id_omni_WAR_omniportlet_']/div/div/div/div/div[2]/ul/li["+q+"]/table/tbody/tr/td[1]/a"));
	return element;

	       }
	

public static WebElement scores(WebDriver driver, int i,int j){


	element = driver.findElement(By.xpath(".//*[@id='gradebook_grid']/div[3]/div[4]/div/div["+i+"]/div["+j+"]/div"));

	return element;

	}

public static WebElement sizeOfChapters(WebDriver driver){


	element = driver.findElement(By.xpath(".//div[2]/div/div[3]/div"));

	return element;

	}

public static WebElement chapterClick(WebDriver driver,int integer){


	element = driver.findElement(By.xpath("//div[3]/div/div/div["+integer+"]/span/a"));
	

	return element;

	}
//public static WebElement chapterClick1(WebDriver driver){
//
//
//	//element = driver.findElement(By.xpath("//div[@id='gradebook_grid']/div[3]/div/div/div[2]"));
//	
//
//	return element;
//
//	}

public static WebElement assessmentViewer(WebDriver driver){


	element = driver.findElement(By.linkText("Assessment Viewer"));
	

	return element;

	}

public static WebElement assessmentViewer1(WebDriver driver){


	element = driver.findElement(By.xpath(".//*[@id='core']/div/div/div[2]/ul/li[1]/a"));
	
return element;
	

	}
public static WebElement languageSelection(WebDriver driver){


	element = driver.findElement(By.xpath("//td[contains(.,'Portuguese - Brazil')]"));
	
return element;
	

	}

public static WebElement listLanguageSelection(WebDriver driver,int d){


	element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+d+"]/td[2]"));
	
return element;
	

	}
public static WebElement formName(WebDriver driver,int e){


	element = driver.findElement(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr["+e+"]/td[1]/a"));
	
return element;

}
public static boolean itemFeedQuestion1(WebDriver driver){

	//element=driver.findElement(By.xpath("//div[2]/div/div/div/div[2]"));
boolean	element = driver.findElements(By.xpath(".//div[@class='itemfeedback']")).size()<1;
	//element=driver.findElement(By.cssSelector("div.itemfeedback"));
	
	
return element;

}
public static boolean liNumberQuestion1(WebDriver driver){

	//element=driver.findElement(By.xpath("//div[2]/div/div/div[3]"));
	//element = driver.findElement(By.xpath(".//li[@class='remediation-link']"));
	boolean element1 =driver.findElements(By.cssSelector("li.remediation-link")).size() < 1;
return element1;

}
public static boolean itemFeedQuestionN(WebDriver driver,int questionitem){


	boolean element = driver.findElements(By.xpath("//div["+questionitem+"]/div/div/div[2]")).size() < 1 ;
	
return element;
}
public static boolean liN(WebDriver driver,int questionli){


	boolean element = driver.findElements(By.xpath("//div["+questionli+"]/div/div/div[3]/div")).size() < 1;
	
return element;
}

public static WebElement nextButton(WebDriver driver){


	element = driver.findElement(By.xpath(".//*[@id='next']"));
	
return element;

}


}

