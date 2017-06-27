package modules;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;

public class StudentPerformanceSummaryNetacad {
	
	private static final String Webdriver = null;
	
	static WebElement element= null;
	
	//Step 3 begins
	
//	public static WebElement clickAssignment(WebDriver driver){
//			
//			element = driver.findElement(By.xpath("//nav/ul/li[3]/a"));
//			System.out.println("Click Assignment"+element);
//			return element;
//			
//		}
//
//	public static WebElement selectAssignmentWindow(WebDriver driver,int count){
//		   
////		element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/a"));
//		element = driver.findElement(By.xpath(".//*[@id='ag-list']/ul/li["+count+"]"));
//		System.out.println("Assignment selected"+element);
//		return element;
//	}
//
//
//	public static WebElement selectAssignment(WebDriver driver, int elementCount){
//		   
////		element = driver.findElement(By.xpath("//li["+elementCount+"]/div/div/a"));
//		element = driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div[2]/div/div[1]/div/div[2]/ul/li[3]/div/div[2]/ul/li["+elementCount+"]/div/div/a"));
//		System.out.println("Assignment selected"+element);
//		return element;
//	}

	public static WebElement clickStudentPerformanceSummary(WebDriver driver){
		
		element = driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/ul/li[5]/a"));
		System.out.println("Click Student Performance Summary"+element);
		return element;
		
	}

//	public static WebElement selectLanguageForm(WebDriver driver){
//		
//		element = driver.findElement(By.xpath("html/body/div[2]/div/div[1]/table/tbody/tr[1]/td/select"));
//		System.out.println("Select default language form"+element);
//		return element;
//		
//	}
//
//	//public static Select selectSubscore(WebDriver driver){
//	//	
////		Select subScore = new Select(driver.findElement(By.xpath("//tr[2]/td/select")));
//	//	
////		System.out.println("Select default language form"+subScore);
////		return subScore;
//	//	
//	//}
//
//	public static Select subScore(WebDriver driver) throws InterruptedException{
//		
//		Select subScore = new Select(driver.findElement(By.xpath("//select[@id='select-subscore']")));
//		List<WebElement> scoreSize = subScore.getOptions();
//		int ListSize = scoreSize.size();
//		// Setting up the loop to print all the options
//		for(int i =0; i < ListSize ; i++){
//			// Storing the value of the option	
//			String sValue = subScore.getOptions().get(i).getText();
//			// Printing the stored value
//			System.out.println(sValue);
//			// Selecting all the elements one by one
//			subScore.selectByIndex(i);
//			Thread.sleep(2000);
//			
//			Select question = new Select(driver.findElement(By.xpath("//div[@id='scores']/div/div[2]/div[3]/div/div/table/thead/tr/th/div/a")));
//			List<WebElement> quest = question.getOptions();
//			int questSize = quest.size();
//			for(int j=1; j <= questSize; j++){
////			driver.findElement(By.xpath("//div[@id='scores']/div/div[2]/div[3]/div/div/table/thead/tr/th["+j+"]/div/a")).click();
////			driver.close();
////		Select question = new Select(driver.findElement(By.xpath("//div[@id='scores']/div/div[2]/div[3]/div/div/table/thead/tr/th["+(i+1)+"]/div/a")));
////		List<WebElement> quest = question.getOptions();
////		int questSize = quest.size();
////			for(int j=1; j <= questSize; j++)
////			{	
//				String sQuest = question.getOptions().get(j).getText();
//				System.out.println(sQuest);
//				question.selectByIndex(j);
//				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//				driver.close();
////			}
//				}
//		}
//	    System.out.println("Select subscore"+subScore);
//		return subScore;
		
		
		
		
		public static WebElement chapterClicks(WebDriver driver, int chapterIndex, int list){


			element = driver.findElement(By.xpath("//li["+chapterIndex+"]/div/div[2]/ul/li["+list+"]/div/div/a"));

			return element;

			}	
		
		public static WebElement formName(WebDriver driver){


			element = driver.findElement(By.xpath(".//*[@id='select-form']"));

			return element;

			}	
		
		public static Select subScores(WebDriver driver){
			
		   // Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='select-subscore']")));

	Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='select-subscore']")));
	
	return dropdown;

		    }	
		
		public static int noOfStudents(WebDriver driver){


		int	element = driver.findElements(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[2]/div[2]/table/tbody/tr[*]/td/span")).size();

			return element;

			}	
		
		public static WebElement noOfScores(WebDriver driver,int i){


			element = driver.findElement(By.xpath(".//*[@id='scores-table']/tbody/tr[1]/td["+i+"]"));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			return element;

				}	
	
		public static WebElement scoreRead(WebDriver driver,int person,int read){


//			element = driver.findElement(By.xpath(".//*[@id='scores-table']/tbody/tr["+person+"]/td["+read+"]"));
			element = driver.findElement(By.xpath("//table[@id='scores-table']/tbody/tr["+person+"]/td["+read+"]"));
			//table[@id='scores-table']/tbody/tr/td[6]
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.onPage(); 
			coordinate.inViewPort();
			
			return element;

			}	
	
		public static Select selectSubscore(WebDriver driver){
			
			Select subScore = new Select(driver.findElement(By.xpath("//tr[2]/td/select")));
			
			System.out.println("Select weighted score" +subScore);
			return subScore;
			
		}
				
		
		public static WebElement selectQuestion(WebDriver driver, int i)
		{
			
		element = driver.findElement(By.xpath("//div[@id='scores']/div/div[2]/div[3]/div/div/table/thead/tr/th["+i+"]/div/a"));
		Coordinates coordinate = ((Locatable)element).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		return element;
			
		}	
		public static boolean itemFeedback(WebDriver driver){
			
		boolean element = driver.findElements(By.xpath(".//*[@id='core']/div/div[4]")).size() < 1;

			return element;

			}
	public static boolean liDisplay(WebDriver driver){
			
	boolean	element = driver.findElements(By.xpath(".//*[@id='core']/div/div[5]")).size() < 1;

			return element;

			}	
	public static boolean checkMCMA(WebDriver driver){
		
		boolean element = driver.findElements(By.xpath("//input[@type='CHECKBOX']")).size()>1;
		
		

				return element;

				}	
	
public static boolean checkMCSA(WebDriver driver){
		
		boolean	element = driver.findElements(By.xpath("//input[@type='RADIO']")).size()>1;

				return element;

				}	

public static boolean checkFIB(WebDriver driver){
	
	boolean	element = driver.findElements(By.xpath("//input[@size='50']")).size()==1;

			return element;

			}	



	

public static WebElement percentageLink(WebDriver driver, int percentage){


element = driver.findElement(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[1]/div[2]/table/tbody/tr["+percentage+"]/td[2]/a"));

            return element;

            }

public static WebElement personalizedFeedback(WebDriver driver){


//       element = driver.findElement(By.xpath(".//*[@id='content']/div[4]/ul/li[1]/a"));
	
	     element =  driver.findElement(By.xpath("//li[1]/a"));

         return element;

}
public static WebElement studentName(WebDriver driver){

       element = driver.findElement(By.xpath(".//*[@id='studentName']"));
       
         return element;
}

public static WebElement backLink(WebDriver driver){

       element = driver.findElement(By.xpath(".//*[@id='breadcrumbs']/ul/li[1]/a"));
       
       return element;
}

public static WebElement personalizedExamName(WebDriver driver){

      element = driver.findElement(By.xpath(".//*[@id='core']/h1"));
        
      return element;
}

public static WebElement itemFeedbackLink(WebDriver driver){

//      element = driver.findElement(By.xpath(".//*[@id='content']/div[4]/ul/li[2]/a"));
      element =driver.findElement(By.xpath("//div[@id='content']/div[4]/ul/li[2]/a"));

      return element;

    }

public static int itemQuest(WebDriver driver){

   int element = driver.findElements(By.xpath("//div[*]/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div[1]")).size();
		   
   return element;

  }

public static boolean liItemFeedback(WebDriver driver, int li){


   boolean	element = driver.findElements(By.xpath("//div["+li+"]/div[2]/table/tbody/tr/td[2]/table/tbody/tr/td")).size()<1 ;

   return element;

}

public static int numberOfDivs(WebDriver driver){

	int	element = driver.findElements(By.xpath("//div/div/div[2]/ul/li[*]")).size();

	return element;

		}

public static int xxx(WebDriver driver,int list1){

    int	element = driver.findElements(By.xpath("//li["+list1+"]/div/div[2]/ul/li[*]/div/div/a")).size();

	return element;

		}
public static int studentPerformanceLength(WebDriver driver){


	int	element = driver.findElements(By.xpath(".//*[@id='core']/div/div/div[2]/ul/li[5]/a")).size();
		
		return element;

		}
	public static WebElement studentPerformanceLink(WebDriver driver){


		element = driver.findElement(By.xpath(".//*[@id='core']/div/div/div[2]/ul/li[5]/a"));
		
		return element;

		}
	
	public static WebElement backLinkForChapter(WebDriver driver){

		element = driver.findElement(By.xpath(".//*[@id='breadcrumbs']/ul/li[3]/a/span"));;
		return element;

		}

	public static int sizeOfExams(WebDriver driver){
		
		int element = driver.findElements(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th[*]/div/a")).size();
			
			//element = driver.findElement(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th["+chapter+"]/div/a"));
//			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
//			coordinate.onPage(); 
//			coordinate.inViewPort();
			return element;

			}
	
public static WebElement sizeOfQuest(WebDriver driver){
		
		 
	element = driver.findElement(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th[*]/div/a"));

	//element = driver.findElement(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th["+chapter+"]/div/a"));
//			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
//			coordinate.onPage(); 
//			coordinate.inViewPort();
			return element;
}
public static WebElement clickOnExam(WebDriver driver,int chapter){
	
		//int element = driver.findElements(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th[*]/div/a")).size();
		element = driver.findElement(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th["+chapter+"]/div/a"));
		Coordinates coordinate = ((Locatable)element).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		return element;

			}	

public static int sizeOfLink(WebDriver driver){

	int element = driver.findElements(By.tagName("a")).size();
	return element;

	}

public static WebElement linkClicks(WebDriver driver){


	 element = driver.findElement(By.tagName("a"));;
	return element;

	}

public static int numberOfQuestions(WebDriver driver){


	int element = driver.findElements(By.xpath("//div[*]/div/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td/div[1]")).size();
		                           //div[2]/div/table/tbody/tr/td[2]/form/table/tbody/tr/td/div
	return element;  

	}

public static String ptExams(WebDriver driver){

	String element = driver.findElement(By.xpath("//a[contains(.,'Packet Tracer')]")).getText();;
	
	return element;

	}

public static String instructorExam(WebDriver driver){

	String element = driver.findElement(By.xpath("//a[contains(.,'Instructor Use Only')]")).getText();;

	return element;

	}

public static int dropdownsize(WebDriver driver){


int	element = driver.findElements(By.xpath(".//*[@id='select-subscore']")).size();
return element;

}

public static Select dropdownselect(WebDriver driver){


Select	dropdown = new Select (driver.findElement(By.xpath(".//*[@id='select-subscore']")));
return dropdown;

}

public static int studentsize(WebDriver driver){


int	element = driver.findElements(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[2]/div[2]/table/tbody/tr[*]/td")).size();
return element;

}

public static int examsize(WebDriver driver){


int	element = driver.findElements(By.xpath(".//*[@id='scores-table_wrapper']/div[2]/div[3]/div[1]/div/table/thead/tr/th[*]")).size();
return element;

}
public static WebElement readingscores(WebDriver driver,int student,int exams){

element = driver.findElement(By.xpath(".//*[@id='scores-table']/tbody/tr["+student+"]/td["+exams+"]/a"));
return element;

}


public static WebElement skipPT(WebDriver driver){
	
	element = driver.findElement(By.xpath("//input[@id='skip']"));
	
    return element;
	
	}

public static int loadingPT(WebDriver driver){
	
	int element = driver.findElements(By.xpath(".//*[@id='loadingprogressbar']")).size();
	
    return element;
	
	}

}
		


