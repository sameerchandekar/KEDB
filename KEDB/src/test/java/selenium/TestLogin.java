//package selenium;
//
//import static org.junit.Assert.*;
//
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.*;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//public class TestLogin 
//{
//	File file=null;
//	WebDriver driver=null;
//	String currentURL=null;
//@Before
//public void setupDriver()
//{
//		 file= new File("C:/Users/syntel/Downloads/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			driver=new InternetExplorerDriver();
//			
//}
//	
//@Test
//public void testLogin()
//{
//
//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//	driver.navigate().to("http://localhost:8081/KEDB/JSP/Login.jsp");
//	driver.manage().window().maximize();
//	driver.findElement(By.xpath(".//*[@id='idf']")).clear();
//	driver.findElement(By.xpath(".//*[@id='idf']")).sendKeys("admin");
//	driver.findElement(By.xpath(".//*[@id='pwd']")).clear();
//	driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("test123");
//	driver.findElement(By.xpath(".//*[@id='body_div']/div[2]/form/input[3]")).submit();
//     currentURL=driver.getCurrentUrl();
// assertEquals(driver.getTitle(),"Quick-Fix:Known Error Database System");
//    
//}
//
//@After
//public void tearDown()
//{
//	driver.close();
//	
//	
//}
//
//}
