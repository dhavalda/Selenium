package action;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import module.AssessmentAt0;
import module.AssessmentAt100;
import module.AssessmentAtMcmaplus;
import utility.AssessmentObj;
import utility.Log;
import utility.ReadJson;
import utility.UrlXcelPath;
import utility.XcelRead;

public class AssessmentAtMcma3Action {
		
	       
	     public static int h = 1;
		
		 public static int i = 1;
		 
		 public static String myQuestion;
		 
		 public static String myQuest;
		
		 static ArrayList<AssessmentObj> list = new ArrayList<AssessmentObj>();
			
public static  void executeSelectingExams(WebDriver driver) throws Exception
{	
			
	XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
    String numberOfCoursesInExams = XcelRead.getCellData(10,0);
    System.out.println("Number of courses	:     "+numberOfCoursesInExams);
	int y = Integer.parseInt(numberOfCoursesInExams.trim()); 
	Thread.sleep(5000);
	       
		  
  for(h=4;h<=y;h++)
{
	driver.findElement(By.xpath("//a[contains(text(),'Assignments')]")).click();
				
//				String url_assign = driver.getCurrentUrl();
//				   String newurl = url_assign+"/assignments";
//				   System.out.println(driver.getCurrentUrl());
//				   driver.get(newurl);
//				   Thread.sleep(5000);
	Thread.sleep(5000);
	AssessmentAt100.selectAssignment(driver,h).click();
	Thread.sleep(10000);
				
	driver.switchTo().frame(1);
			    
	int languageSize =driver.findElements(By.xpath(".//*[@id='core']/div/div[1]/table/tbody/tr[*]/td[1]")).size();
				
	loopbreak:		
	for (int f=1;f<=languageSize;f++)
	{
		String lang= AssessmentAt0.listLanguageSelection(driver,f).getText();
		System.out.println("language: "+lang);
		Log.info("language: "+lang);
					
		XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
		String languageName = XcelRead.getCellData(10,1);

		if(lang.equals(languageName))
		{
			AssessmentAt100.takeAssessment(driver, f).click();
			break loopbreak;
		}	
	}
							
	   driver.switchTo().activeElement();
	   Thread.sleep(1000);
				    		    
	   String parentWindow = driver.getWindowHandle();
	   Set<String> handles = driver.getWindowHandles();
					
	   for (String windowHandle : handles) 
	  {
		if (!windowHandle.equals(parentWindow)) 
	    {
		  driver.switchTo().window(windowHandle); 
		  System.out.println("---------------------Begin Assessment------------------  ");
					
		  AssessmentAt100.clickContinue(driver).click();
		  Thread.sleep(1000);
				    
		 if(AssessmentAt100.loadingPT(driver) > 0)
		{
		  Robot object=new Robot();
		  object.keyPress(KeyEvent.VK_DOWN);
		  object.keyRelease(KeyEvent.VK_DOWN);
		  Thread.sleep(3000);
		  System.out.println("Select Save File:");
		  Log.info("Select Save File:");
					   
		  object.keyPress(KeyEvent.VK_ENTER);
		  object.keyRelease(KeyEvent.VK_ENTER);
					    
		  AssessmentAt100.skipPT(driver).click();
		  System.out.println("Skip Packet Tracer");
					   
		  Alert alert = driver.switchTo().alert();
		  driver.switchTo().alert();
		  alert.accept();
					   
		}
								
	else
	{
		 System.out.println("No packet tracer found");
		 Log.info("No packet tracer found");
		 AssessmentAt100.clickBeginAssessment(driver).click();
	}  
				    
	int noOfQuestions = driver.findElements(By.xpath("//table[@id='questionbartable']/tbody/tr/td[/]")).size();
	System.out.println("Number of Questions"+noOfQuestions);
	
	XcelRead.setExcelFile(UrlXcelPath.xcelPath + UrlXcelPath.xcelFileName,"Login-Sheet1");
	String chooseThree = XcelRead.getCellData(10,3); 
	System.out.println(chooseThree);
		
	
	for(i=1;i<=noOfQuestions;)
   {
		
	 String myQuest= driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().replace("\n","").replace("\r","");	
	 
//	 String myQuest= driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div")).getText().replace("\n","").replace("\r","").trim().replaceAll("\\s","");
	 System.out.println("Question no "+i+": "+myQuest);
	
	 

	 	  
	if((AssessmentAtMcmaplus.checkMCMA(driver)==true) && (myQuest.contains(chooseThree)))
	{
	 
	 System.out.println("Inside if");
	 
	 ReadJson file = new ReadJson();
	 file.parseAssessments();
		    
	 AssessmentObj assessment = new AssessmentObj();
	 list.add(assessment);
		    
	 AssessmentObj assessment0 = list.get(0); 
	 ArrayList<String> ques = assessment0.getQuestion();
		    
	 int questSize = ques.size();
	 
	 int imageString = driver.findElements(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/img")).size();
	 System.out.println("There is image: "+imageString);
	 
//	 if(myQuest.contains("Choose three"))
//	{ 
	 
	for(int j=1;j<=questSize; j++)
   { 
		      
	  if(imageString>=1)	
	 {
		 System.out.println("Inside image if");   
	     String imgString = driver.findElement(By.xpath("html/body/div[1]/div[2]/div["+i+"]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div/div")).getText();
	     System.out.println("Image question: "+imgString);

	     String myQuestion= myQuest.replace(imgString,"").trim();
//	     System.out.println("Question: "+myQuestion);
	     
//	  if (myQuestion.contains("Choose three"))
//	  { 
		  
	   if(ques.get(j).replace("\\","").contains(myQuestion))
	  {	    	 
		 System.out.println("Question found: " +ques.get(j)); 
		 ArrayList<String> corr = assessment0.getCorrectAnswers();
		 System.out.println("Correct Answer is: "+corr.get(j));
		 
		 ArrayList<String> incorr = assessment0.getIncorrectAnswers();
		 System.out.println("InCorrect Answer is: "+incorr.get(j));
		 
		 String corrAns  = corr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
		 String incorrAns = incorr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
				
		 int correctAns = corrAns.split(",").length;
		 System.out.println("No. of Correct Answers: "+correctAns);
				
		for(int p=0;p<2;p++)
		{
			
//          if(p<2)
//         {
		  String string = corrAns.split(",")[p].toString().trim();
		  System.out.println("----String--- "+string);
		  
		  List<WebElement> optionSet = driver.findElements(By.xpath("//label[contains(.,'"+string+"')]"));
          int sizeOfAnswers=optionSet.size();
          int g=0;
          System.out.println("size "+sizeOfAnswers);

          for (g=0; g<=sizeOfAnswers;g++)
          {
			System.out.println("for g "+g);
            
			if (optionSet.get(g).isDisplayed())
           {

			System.out.println("g Value "+g);
				optionSet.get(g).click();
				break;
		   }

		}

//		  driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
//		  System.out.println("Correct String click: "+string);
        }
          
//         else
//         {
        	 
          String string = incorrAns.split(",")[0].toString().trim();
   		  System.out.println("----String--- "+string);	
   		  
		  List<WebElement> optionSet = driver.findElements(By.xpath("//label[contains(.,'"+string+"')]"));
          int sizeOfAnswers=optionSet.size();
          int g=0;
          System.out.println("size "+sizeOfAnswers);

          for (g=0; g<=sizeOfAnswers;g++)
          {
			System.out.println("for g "+g);
            
			if (optionSet.get(g).isDisplayed())
           {

			System.out.println("g Value "+g);
				optionSet.get(g).click();
				break;
		   }

		}
        
//   		  driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
//   		  System.out.println("Incorrect String click: "+string);
   		  
//         }
//		
//		}	// correct ans for loop
			 
   		break;
	  } // if quest
	   
	  } // if myquestion

						     
 else 
 {
		
//	   System.out.println("Inside else");
	   if(ques.get(j).replace("\\","").contains(myQuest))
	   {
			
		 System.out.println("Question found: " +ques.get(j));
		 ArrayList<String> corr = assessment0.getCorrectAnswers();
		 System.out.println("Correct Answer is: "+corr.get(j));
				
		 ArrayList<String> incorr = assessment0.getIncorrectAnswers();
		 System.out.println("InCorrect Answer is: "+incorr.get(j));
		 
		 String corrAns  = corr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
		 String incorrAns = incorr.get(j).replace("[" ,"").replace("\"", "").replace("]","");
				
		 int correctAns = corrAns.split(",").length;
		 System.out.println("No. of Correct Answers: "+correctAns);
				
		for(int p=0;p<2;p++)
		{
			
//          if(p<2)
//         {
		  String string = corrAns.split(",")[p].toString().trim();
		  System.out.println("----String--- "+string);	
		  
		  List<WebElement> optionSet = driver.findElements(By.xpath("//label[contains(.,'"+string+"')]"));
          int sizeOfAnswers=optionSet.size();
          int g=0;
          System.out.println("size "+sizeOfAnswers);

          for (g=0; g<=sizeOfAnswers;g++)
          {
			System.out.println("for g "+g);
            
			if (optionSet.get(g).isDisplayed())
           {

			System.out.println("g Value "+g);
				optionSet.get(g).click();
				break;
		   }

		}
//		  driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).clear();
//		  System.out.println("Correct String displayed: "+string);
//		  driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
//		  System.out.println("Correct String clicked: "+string);
		  
         }
          
//         else
//         {
        	 
          String string = incorrAns.split(",")[0].toString().trim();
   		  System.out.println("----String--- "+string);
   		  
		  List<WebElement> optionSet = driver.findElements(By.xpath("//label[contains(.,'"+string+"')]"));
          int sizeOfAnswers=optionSet.size();
          int g=0;
          System.out.println("size "+sizeOfAnswers);

          for (g=0; g<=sizeOfAnswers;g++)
          {
			System.out.println("for g "+g);
            
			if (optionSet.get(g).isDisplayed())
           {

			System.out.println("g Value "+g);
				optionSet.get(g).click();
				break;
		   }

		}
   				
//   		  driver.findElement(By.xpath("//label[contains(.,'"+string+"')]")).click();
//   		  System.out.println("Incorrect String click: "+string);
   		  
//         }
	
//		}	//for correct ans loop
				
			break;
	   } // if my quest

	} // else if my quest
   } //check mcma	
		
}  //for loop quest size
		 i++;
		AssessmentAt100.clickNext(driver,i).click();
		Thread.sleep(2000); 
}  //no. of questions
				
//	AssessmentAt100.clickSubmit(driver).click();
	AssessmentAt100.gradeEvaluation(driver).click();
	driver.close();
	driver.switchTo().window(parentWindow);
  } // window handle if
						
}// parent window handle
}// chapter click
} // main method
}// class


