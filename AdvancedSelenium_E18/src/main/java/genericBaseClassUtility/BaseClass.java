package genericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesFileUtility proputil = new PropertiesFileUtility();
	
	
	@BeforeSuite
	public void beforeSuite() throws SQLException
	{
		System.out.println("Established Database connection");
		dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "root");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Pre-Configuration set up");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launch the Browser");
				
		//String BROWSER = proputil.readingDataFromPropFile("browser");
		String BROWSER = System.getProperty("browser");//For running maven test (mvn test -Dbrowser=chrome)
		ChromeOptions Coption = new ChromeOptions();
		FirefoxOptions Foption = new FirefoxOptions();
		EdgeOptions Eoption = new EdgeOptions();
		Coption.addArguments("--headless");
		Foption.addArguments("--headless");
		Eoption.addArguments("--headless");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver = driver;
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Login");
		String URL = proputil.readingDataFromPropFile("url");
		//String UN = proputil.readingDataFromPropFile("uname");
		//String PWD = proputil.readingDataFromPropFile("pwd");
		String UN = System.getProperty("uname");// For running maven test (mvn test -Duname=rmgyantra -Dpwd=rmg9999)
		String PWD = System.getProperty("pwd");//  For running maven test
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PWD);
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout");
		DashboardPage dp = new DashboardPage(driver);
		dp.logout();
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("Close the Browser");
		driver.quit();
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post Configuration set up");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Close the DB Connection");
		dbUtil.closeDBConnection();
	}
	
	
	

}
