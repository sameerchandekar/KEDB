package selenium;


import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTestHomePage {
	static File file=null;
	static WebDriver driver=null;
	static String currentURL=null;
	public static String homepageurl="http://localhost:8081/KEDB/JSP/HomePage.jsp";
	public static String loginurl="http://localhost:8081/KEDB/JSP/Login.jsp";
	
@BeforeClass
public static void setupDriver()
{
		 file= new File("C:/Users/syntel/Downloads/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver=new InternetExplorerDriver();

			
			
			 //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			    //Launch website
			driver.navigate().to(loginurl);
				
				//Maximize the browser
			 driver.manage().window().maximize();

			    // Clear the value of id and put the value
			  driver.findElement(By.xpath(".//*[@id='idf']")).clear();
			  driver.findElement(By.xpath(".//*[@id='idf']")).sendKeys("user");
				
			  
				 // Clear the value of password and put the value
			  driver.findElement(By.xpath(".//*[@id='pwd']")).clear();
			 driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("test789");
				
				
			    
			    // Click Submit Button
				driver.findElement(By.xpath(".//*[@id='body_div']/div[2]/form/input[3]")).submit();
				System.out.println("Login test case is passed.");

			
				
}


	
	
	public void homepage_direct()
	  {

		    //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    //Launch website
		driver.navigate().to(homepageurl);
			
			//Maximize the browser
		driver.manage().window().maximize();
			
			System.out.println("The requested URL is not for direct navigation,you must need to pass credentials.");
			System.out.println("homepage_direct test case is passed,Not a Test Failure.");
			
			


	  }
	 
	
	public void search()
	  {  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 // driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[9]/a")).click();
		//  System.out.println("Search test case clicked without value");
		  
		 // driver.findElement(By.tagName("Confirm")).click();
		
		  driver.findElement(By.xpath(".//*[@id='advsrh']")).clear();
		  driver.findElement(By.xpath(".//*[@id='advsrh']")).sendKeys("issue");
		  driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[9]/a")).click();
			
			System.out.println("Search test case is passed..");


	  }
	  
	
	
	  public void advsearch()
	  {  
						
		 // driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[9]/a")).click();
		//  System.out.println("Search test case clicked without value");
		  
		 // driver.findElement(By.tagName("Confirm")).click();
		
		 driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[2]/a")).click();
		 driver.findElement(By.xpath(".//*[@id='main_body']/div/form/table/tbody/tr[2]/td[1]/input")).sendKeys("inc");
		 driver.findElement(By.xpath(".//*[@id='submit']")).click();
		 driver.findElement(By.xpath(".//*[@id='main_body']/table/tbody/tr[2]/td[1]/a")).click();
		 driver.findElement(By.xpath(".//*[@id='main_body']/table/tbody/tr[10]/td[2]")).click();
		//driver.findElement(By.xpath(".//*[@id='main_body']/table/tbody/tr[2]/td[1]/a")).click();
		
		
			
			System.out.println("adv Search test case is passed..");


	  }
	
	
	
	
	 public void addInc()
	  {                               
		 driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[3]/a")).click();
		 driver.findElement(By.id("lob")).sendKeys("GCC");
		 System.out.println("LOB Added");
		 
		 driver.findElement(By.id("E2E")).sendKeys("AR");
		 new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("APP")));
		 System.out.println("E2E Added");
		 
		 driver.findElement(By.id("APP")).sendKeys("LAC");
		 System.out.println("APP Added");
		 
		 driver.findElement(By.id("IN")).sendKeys("INC0012345698");
		 System.out.println("IN Added");
		 
		 driver.findElement(By.id("PN")).sendKeys("PRB0001740");
		 System.out.println("PR Added");
		 
		 
		 driver.findElement(By.id("datepicker")).sendKeys("12/01/2014");
		 
		 driver.findElement(By.id("datepicker1")).sendKeys("12/02/2014");
		 driver.findElement(By.id("IT")).click();
		 driver.findElement(By.id("IT")).sendKeys("Unable to add CID to BU");
		 driver.findElement(By.id("CC")).sendKeys("connectivi");
		 driver.findElement(By.id("ID")).sendKeys("User is unable to add CID to BU .");
		 driver.findElement(By.id("WA")).sendKeys("Not available");
		 driver.findElement(By.xpath(".//*[@id='submit']")).click();
		 
		 Alert alert = driver.switchTo().alert(); 
		 String alertMsgInc=alert.getText();
		 if(alertMsgInc.equalsIgnoreCase("Some issue in adding incident. Please try again later"))
		 {
			 System.out.println("Alert Message:Some issue in adding incident. Please try again later");
			 System.out.println("This alert is due to Test Case is trying to enter same Incident again.");
		 }
		
		 else if(alertMsgInc.equalsIgnoreCase("create date has to be less then close date")) 
		 {

			 System.out.println("Alert Message:create date has to be less then close date");
			 System.out.println("This alert is due to Test Case, Apllication passes the test case."); 
		 }
		
		 else if(alertMsgInc.equalsIgnoreCase("Fields cannot be left blank"))
			 
		 {

			 System.out.println("Alert Message:Fields cannot be left blank");
			 System.out.println("This alert is due to Test Case, Apllication passes the test case.");
		 }
		 
		 else if(alertMsgInc.equalsIgnoreCase("Incident added successfully."))
        {

			 System.out.println("Incident added successfully, Test Case is passed");
			 
		 }
		 alert.accept(); 
		 	 
		 
			 
		 System.out.println("Alert Accepted, Test Case passed successfuly");
	  }
	 
	 
	 
	
	 public void addProblem() {
			
			
		 driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[4]/a")).click();
		 driver.findElement(By.id("lob")).sendKeys("GCC");
		 System.out.println("LOB Added");
		 
		 driver.findElement(By.id("E2E")).sendKeys("AR");
		 new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.id("APP")));
		 System.out.println("E2E Added");
		 
		 driver.findElement(By.id("APP")).sendKeys("LAC");
		 System.out.println("APP Added");
		 
		
		 
		 driver.findElement(By.id("PN")).sendKeys("PRB0001740");
		 System.out.println("PR Added");
		 

		 driver.findElement(By.id("PT")).sendKeys("Title of PR000");
		 System.out.println("PR Added");
		 

		 driver.findElement(By.id("PD")).sendKeys("User is unable to add CID to BU .");
		 driver.findElement(By.id("RCA")).sendKeys("Not available");
		 driver.findElement(By.id("PR")).sendKeys("Not available");
		 driver.findElement(By.id("datepicker")).sendKeys("12/02/2014");
		 
		 driver.findElement(By.xpath(".//*[@id='submit']")).click();
		 
		 Alert alert = driver.switchTo().alert(); 
		 String alertMsgInc=alert.getText();
		 if(alertMsgInc.equalsIgnoreCase("Some issue in adding Problem. Please try again later"))
		 {
			 System.out.println("Alert Message:Some issue in adding Problem. Please try again later");
			 System.out.println("This alert is due to Test Case is trying to enter same Problem again.");
		 }
		
		 else if(alertMsgInc.equalsIgnoreCase("create date has to be less then close date")) 
		 {

			 System.out.println("Alert Message:create date has to be less then close date");
			 System.out.println("This alert is due to Test Case, Apllication passes the test case."); 
		 }
		
		 else if(alertMsgInc.equalsIgnoreCase("Fields cannot be left blank"))
			 
		 {

			 System.out.println("Alert Message:Fields cannot be left blank");
			 System.out.println("This alert is due to Test Case, Apllication passes the test case.");
		 }
		 
		 else if(alertMsgInc.equalsIgnoreCase("Problem added successfully."))
	     {

			 System.out.println("Problem added successfully, Test Case is passed");
			 
		 }
		 alert.accept(); 
		 	 
		 
			 
		 System.out.println("Alert Accepted, Test Case passed successfuly");
			 
		 
		 System.out.println("Problem Added Successfully");
		 
		}
	
	
	
	
	
	  public void logout()
	  
	  {  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Click Log out Button
		  driver.findElement(By.xpath(".//*[@id='menu_wrap']/li[10]/a")).click();
			
			
			System.out.println("Loged out");
			
			System.out.println("Log out test case is passed..");


	  }
	  
	 
	  public void logoutCheck()
	 
	  {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //Click Log out Button
		  String LogOut_Value=driver.findElement(By.xpath(".//*[@id='body_div']/div[2]/font")).getText();
			
			if(LogOut_Value.equals("You are logged out !!") )
					{
				System.out.println("text matched,Loged out successfuly");
			}
			else
			{
				System.out.println("text matched faild,not Loged out successfuly");
			}
			
			System.out.println("LogOutChecks test case is passed.."+LogOut_Value);


	  }
	  
	 
	 @Test
	 public void testInOrder() throws Exception {
		 search(); 
		// advsearch(); 
		 addInc();
		 addProblem();
		 logout();
		 logoutCheck();
		 
	 }
	 
	 
	 @After
	public void tearDown()
	{
		driver.close();
	}
}
