package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class LoginTest extends BaseClass {

	   //@Parameters("browser")
	   //@Test(groups = {"Smoke"})
	   //public void LoginTest1(String browser) throws IOException, InterruptedException {
		
		@Test(retryAnalyzer = genericListenerUtility.RetryListenerImp.class)
	    public void LoginTest1() throws IOException, InterruptedException {
		//PropertiesFileUtility proputil = new PropertiesFileUtility();
		
		//String BROWSER = browser;//To use @parameter annotation
		//String BROWSER = proputil.readingDataFromPropFile("browser");
		//String URL = proputil.readingDataFromPropFile("url");
		//String UN = proputil.readingDataFromPropFile("uname");
		//String PWD = proputil.readingDataFromPropFile("pwd");
		
		String expectedURL = ("http://49.249.28.218:8098/dashboard");

		 //WebDriver driver = new ChromeDriver();

		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 //driver.get(URL);
		 
		 //LoginPage lp = new LoginPage(driver);
		 //lp.login(UN, PWD);
		 
		 //lp.getUsernameField().sendKeys(UN);
		 //lp.getPasswordField().sendKeys(PWD);
		 //lp.getSignInBtn().click();
		 
		 Thread.sleep(2000);
		 
		 String actualURL = driver.getCurrentUrl();
		 Assert.assertEquals(actualURL, expectedURL, "Validation is failed"); // This is HardAssert
		 Reporter.log("Validation is passed", true); 
		 
		 //SoftAssert sf = new SoftAssert(); //SoftAssert
		 //sf.assertEquals(actualURL, expectedURL,"Validation is failed");
		 //Reporter.log("Validation is passed", true);
		 
		// if(actualURL.equals(expectedURL))
		// {
		//	 Reporter.log("Validation is pass",true);
		// }
		// else
		//	 {
		//	 Reporter.log("Validation has failed",true);
		//	 }
		 
		
		 DashboardPage dp = new DashboardPage(driver);
		 //Thread.sleep(2000);
		 //dp.logout();
		 //dp.getProfileIcon().click();
		 //dp.getLogoutBtn().click();
				 
		 
		//driver.findElement(By.xpath("//div[@class = 'user-icon']")).click();
		
		//WebElement targetEle =  driver.findElement(By.xpath("//div[@class = 'dropdown-item logout']"));
				
		//Actions act = new Actions(driver);
		 
		//act.moveToElement(targetEle).click().perform();
		//System.out.println("Hovering complete");
		
		//driver.quit();
		
			
				
	}

}
