package modules;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utility.Log;
import utility.XcelReadWrite;

public class AssessmentLinkSetup {
	
	private static final String Webdriver = null;
	
	static WebElement element= null;
	//static int a=0;
	
	public static WebElement publish(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='course_status_form']/button[2]"));
		System.out.println("Publish course"+element);
		return element;
		
	}

public static WebElement group(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='addGroup']"));
		System.out.println("Click on Group"+element);
		return element;
		
	}

public static WebElement groupName(WebDriver driver){
	
	element = driver.findElement(By.xpath("//form[@id='ui-id-2']/div/div/div/div/div/input"));
	System.out.println("Entered Assignments into Group name"+element);
	return element;
}

public static WebElement saveGroupName(WebDriver driver){
	
	element = driver.findElement(By.xpath("//form[@id='ui-id-2']/div/div[2]/button[2]"));
	System.out.println("Saved Assignments into Group name"+element);
	return element;
}

public static WebElement selectDropdown(WebDriver driver){
	
	element = driver.findElement(By.xpath("//li/div/div/div/div/a"));
	System.out.println("Click on Settings icon"+element);
	return element;
}

public static WebElement delete(WebDriver driver){
	
	//element = driver.findElement(By.xpath(".//*[@id='ui-id-3']"));
	element =driver.findElement(By.linkText("Delete"));
	System.out.println("Select Delete"+element);
	return element;
}

public static WebElement deleteGroup1(WebDriver driver) throws Exception{
		
	//	Thread.sleep(10000);
//	Alert alert = driver.switchTo().alert();
//	alert.accept();
	element = driver.findElement(By.xpath("//div[5]/form/div/div[2]/button[2]"));
	//div[5]/form/div/div[2]/button[2]
//	element = driver.findElement(By.xpath("//button[contains(.,'Delete Group')]"));
	Thread.sleep(10000);
	//driver.navigate().refresh();
	return element;
	
	//Thread.sleep(10000);
	}
	

public static WebElement deleteGroup2(WebDriver driver) throws Exception{
	
	
	
//	Thread.sleep(10000);
//	Alert alert = driver.switchTo().alert();
//	alert.accept();
	element = driver.findElement(By.xpath("//div[6]/form/div/div[2]/button[2]"));
	Thread.sleep(10000);
	//driver.navigate().refresh();
	return element;
	
	//Thread.sleep(10000);
	}


public static WebElement addAssignments(WebDriver driver)

{
	
	//element = driver.findElement(By.linkText("Add Assignment to Assignments"));
	
	element = driver.findElement(By.linkText("Assignment"));
	//element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[1]/div[2]/a[2]"));
	System.out.println("Click on add assignments"+element);
	return element;
	
}

public static WebElement addAssignmentsName(WebDriver driver) throws Exception{
	

//	 element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[1]/div/input"));
	 element = driver.findElement(By.xpath("//input[@id='assignment_name']"));
	 System.out.println("Enter assignments points"+element);
     
     //Thread.sleep(10000);
		

	 return element;
	}


public static WebElement addAssignmentsPoints(WebDriver driver)
{

// element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[3]/div[2]/input"));
 element = driver.findElement(By.xpath("//input[@id='assignment_points_possible']"));
 System.out.println("Enter assignments points"+element);
 return element;
}

public static Select submissionType(WebDriver driver)
{
//	Select dropdown= new Select(driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/fieldset[1]/div[2]/div/select")));

	Select dropdown= new Select(driver.findElement(By.xpath("//select[@id='assignment_submission_type']")));
    
    return dropdown;
}

public static WebElement findButton(WebDriver driver)

{

//	 element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/fieldset[1]/div[2]/div/div[2]/div[2]/div/div/button"));
	 
	element = driver.findElement(By.xpath("//button[@id='assignment_external_tool_tag_attributes_url_find']"));

	 System.out.println("find button clicked"+element);
	 return element;
	}


public static WebElement  chapterUrl(WebDriver driver) 
{
	element=driver.findElement(By.xpath(".//*[@id='external_tool_create_url']"));
	//input[@id='external_tool_create_url']
	return element;

		 
}

public static WebElement toolSelection(WebDriver driver){

	   element = driver.findElement(By.linkText("configure activity"));
	   return element;
	   
	}


public static WebElement cancelCloseMark(WebDriver driver){

	   element = driver.findElement(By.xpath("//div[8]/div/a/span"));
	 //div[7]/div/a/span
	   return element;
	}

//public static WebElement externalTool(WebDriver driver) throws Exception{

	 //element = driver.findElement(By.xpath("html/body/div[6]/div[2]/div[2]/table/tbody/tr[1]/td/ul/li[5]/a"));
	
	//element=driver.findElement(By.linkText("RTP Dev Tool")).getText();
	
//	String externalToolName=XcelReadWrite.getCellData(12,1);
//	
//	switch(externalToolName)
//	{
//	case "RTP Dev Tool":
//		element=driver.findElement(By.linkText("RTP Dev Tool"));
//		break;
//		
//		
//	case "configure activity":
//		element=driver.findElement(By.linkText("configure activity"));
//		break;
//		
//	case "VDS Dev Tool":
//		element=driver.findElement(By.linkText("VDS Dev Tool"));
//		break;
//	
//	
//	}
//	
//	System.out.println("Externaltool selected"+element);
//	 
//	 return element;
//	 
//	}

public static WebElement  selectSavedCourse(WebDriver driver) 
{
	
	element = driver.findElement(By.xpath("//div[11]/div/button[2]"));
	
			return element;

		 
}


//public static WebElement linkBuilder(WebDriver driver){
//
//	 //element = driver.findElement(By.xpath("html/body/div[2]/div[2]/p/a"));
//	
//	element=driver.findElement(By.linkText("Instructor-Activated Assessment Launcher"));
//	
//	 System.out.println("Externaltool selected"+element);
//	 
//	 return element;
//	 
//	}

//public static Select language(WebDriver driver)
//{
//	//Select dropdown= new Select(driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[4]/td[2]/select")));
//   
//	Select dropdown= new Select(driver.findElement(By.xpath("//select[@name='e_language_list']")));
//	
//	return dropdown;
//   
//}
//
//public static Select course(WebDriver driver)
//{
//	//Select dropdown= new Select(driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[5]/td[2]/select")));
//   
//	Select dropdown= new Select(driver.findElement(By.xpath("//select[@name='e_name_list']")));
//   return dropdown;
//}
//
//public static Select version(WebDriver driver)
//{
//	//Select dropdown= new Select(driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[6]/td[2]/select")));
//   
//	Select dropdown= new Select(driver.findElement(By.xpath("//select[@name='e_version_list']")));
//   
//	return dropdown;
//}
//
//public static Select assessment(WebDriver driver)
//{
//	//Select dropdown= new Select(driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[7]/td[2]/select")));
//   
//	Select dropdown= new Select(driver.findElement(By.xpath("//select[@name='e_title_list']")));
//   
//	return dropdown;
//}
//
//public static WebElement submit(WebDriver driver){
//
//	 element = driver.findElement(By.xpath("//input[@value='Submit']"));
//	
//	//element=driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[8]/td"));
//	 System.out.println("Submit button clicked"+element);
//	 
//	 return element;
//	 
//	}
//
//public static WebElement selectExternalTool(WebDriver driver){
//
//	 element = driver.findElement(By.xpath("//div[11]/div/button[2]"));
//	
//	//element=driver.findElement(By.xpath("html/body/div[2]/div[5]/form/table/tbody/tr[8]/td"));
//	 System.out.println("External tool is selected"+element);
//	 
//	 return element;
//	 
//	}

public static WebElement saveAndPublish(WebDriver driver){

//	 element = driver.findElement(By.xpath(".//*[@id='edit_assignment_form']/div[9]/button[2]"));
	 element = driver.findElement(By.xpath("//form[@id='edit_assignment_form']/div[2]/button[2]"));
	
     System.out.println("chapter is saved and published"+element);
	 
	 return element;
	 
	}
public static WebElement selectAssignment(WebDriver driver, int elementCount){
   
//		element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/a"));
		
		element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/div[3]/a"));
		
	 System.out.println("Assignment selected"+element);
 
		return element;
		
}
public static WebElement createAdvancedActivation(WebDriver driver){

	element = driver.findElement(By.xpath("//div[@id='core']/div/div/div/ul/li[3]/a"));

	
    System.out.println("Click on create advanced activation"+element);

	return element;

}

public static WebElement endDate(WebDriver driver){
	
    element = driver.findElement(By.xpath("//tr[@id='enddatetime']/td/input"));
	
	return element;
}

public static Select endTime(WebDriver driver){
	
    Select dropdown =new Select(driver.findElement(By.xpath("//tr[@id='enddatetime']/td/select")));
   
    return dropdown;
}

public static WebElement languageForm(WebDriver driver) throws Exception{
		
	int a=0;
	for (int i=1;i<=20;i++)
	{
	String formName = XcelReadWrite.getCellData(12,5);
	System.out.println("formValue form"+formName);
	String language = driver.findElement(By.xpath(".//*[@id='forms-table']/tbody/tr["+i+"]/td[3]")).getText();
    System.out.println("languagelanguagelanguage form"+language);

			if (language.equals(formName))
			{
				Log.info("Course name from excel"+formName);
				Log.info("Position of form name"+i);
				a=i;
				break;
				
			}
		}

	
 element =driver.findElement(By.xpath(".//*[@id='forms-table']/tbody/tr["+a+"]/td[1]/input"));

  return element;
}

public static WebElement chooseAssessmentAdmininstration(WebDriver driver){
	
    element = driver.findElement(By.xpath("//input[2]"));
    return element;
}

public static WebElement clickCreateAdvancedActivation(WebDriver driver){
	
    element = driver.findElement(By.xpath("//button[@id='activateButton']"));
    return element;
}


public static WebElement urlTextbox(WebDriver driver) {
	
element=driver.findElement(By.xpath("//div[@id='assignment_external_tool_settings']/div[2]/div/div/input"));
return element;

}

}


	    

