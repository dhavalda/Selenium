
package action;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import main.StageClassSetup;
import modules.AddStudent;
import modules.CreateCourse;
//import modules.Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import au.com.bytecode.opencsv.CSVReader;

import utility.Log;
import utility.UrlXcelPath;
import utility.XcelReadWrite;


public class AddStudentAction {
	
	
	public static void executeAddStudent(WebDriver driver) throws Exception 
	{
		
//		    driver.switchTo().activeElement();
//		    CreateCourse.teachTab(driver).click();
		
		    AddStudent.editCourse(driver).click();
		    Log.info("clicked on edit course");
		
			AddStudent.editStudent(driver).click();
			Log.info("Clicked on edit link to upload students");
			
			AddStudent.addCsvFile(driver).click();
			driver.switchTo().frame(0);
			AddStudent.browseCsvFile(driver).sendKeys(UrlXcelPath.csvStudentInfo);
			Thread.sleep(5000);
			AddStudent.uploadCsvFile(driver).click();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);

			
			AddStudent.saveStudent(driver).click();
			Log.info("Clicked on Student save button");
			Thread.sleep(30000);
			String students = XcelReadWrite.getCellData(1,1);
			Log.info("Number of students: "+students);
			int n = Integer.parseInt(students.trim()); 
			System.out.println("nnnnnnnnnnnn  "+n);
			
			for (int i=1; i<=n; i++) 
		
			{
							
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.findElement(By.xpath("//div[4]/div[2]/div/table/tbody/tr["+i+"]/td[7]/input")).click();
	        Log.info("Clicked on Reset Password button");
   	        Thread.sleep(4000);	    	
 	
 	        String screenname=driver.findElement(By.xpath("//div[4]/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText();
    	    Thread.sleep(4000);
    	    Log.info("Read Student screenname: "+screenname);
    	
    	
           String password=driver.findElement(By.xpath("//div[4]/div[2]/div/table/tbody/tr["+i+"]/td[7]")).getText();	
           Log.info("Read Student temporary password: "+password);
	
	
	      XcelReadWrite.setCellData(password, i, 3);
          Log.info("Wrote " +i+ "Student password into excel");
          
          XcelReadWrite.setCellData(screenname, i, 2);
          Log.info("Wrote " +i+ " Student screenname into excel");
	      Thread.sleep(5000);
 	
	     }
		
		AddStudent.logout(driver);
		Thread.sleep(10000);
		Log.info("Successfully logged out as Instructor");
	
	}
}
		
		
//		Using open csv			
//			CSVReader reader = new CSVReader(new FileReader("I:\\Automation-SeleniumUnicon\\student.csv"));
//			// this will load content into list
//			  List<String[]> studInfo = reader.readAll();
//			  System.out.println("Total rows which we have is "+studInfo.size());
//			       
//			 // create Iterator reference
//			  Iterator<String[]>i1= studInfo.iterator();
//			    
//			 // Iterate all values 
//			 while(i1.hasNext()){
//			     
//			 String[] str = i1.next();
//			   
//			 System.out.print(" Values are ");
//			 
//			 for(int i=0;i<str.length;i++)
//			{
//			 
//			   System.out.print(" "+str[i]);
//			 
//			}
//			   System.out.println("   ");
//			     
//			    
//			}
	      