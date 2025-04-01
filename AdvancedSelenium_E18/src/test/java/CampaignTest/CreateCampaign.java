package CampaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateCampaign extends BaseClass {
	
	//@Parameters("browser")
	//@Test(groups = {"Functionality"})
	//@Test(priority = 1)
	//@Test(invocationCount = 4, threadPoolSize = 4)
	//@Test(enabled = false)
	//public void CreateCampaignTest(String browser) throws IOException, InterruptedException {
	
		@Test()
		
		public void CreateCampaignTest() throws IOException, InterruptedException {
		
		//PropertiesFileUtility proputil = new PropertiesFileUtility();
		
		//String BROWSER = browser;//To use @parameter annotation
		//String BROWSER = proputil.readingDataFromPropFile("browser");
		//String URL = proputil.readingDataFromPropFile("url");
		//String UN = proputil.readingDataFromPropFile("uname");
		//String PWD = proputil.readingDataFromPropFile("pwd");

		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(2000);
		
		ExcelFileUtility exutil = new ExcelFileUtility();
		String Campaign = exutil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exutil.readingDataFromExcel("DDT", 1, 3);
		
		//String closeDate = jUtil.generateReqDate(30);
		
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		//WebDriver driver=null;
		
		//ChromeOptions Coption = new ChromeOptions();
		//FirefoxOptions Foption = new FirefoxOptions();
		//EdgeOptions Eoption = new EdgeOptions();
		//Coption.addArguments("--headless");
		//Foption.addArguments("--headless");
		//Eoption.addArguments("--headless");

		//if(BROWSER.equalsIgnoreCase("chrome"))
		//{
		//	driver=new ChromeDriver(Coption);
		//}
		//else if(BROWSER.equalsIgnoreCase("firefox"))
		//{
		//	driver=new FirefoxDriver(Foption);
		//}
		//else if(BROWSER.equalsIgnoreCase("edge"))
		//{
		//	driver=new EdgeDriver(Eoption);
		//}
		//else
		//{
		//	driver=new ChromeDriver(Coption);
		//}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		//driver.get(URL);
		
		//LoginPage lp = new LoginPage(driver);
		//lp.login(UN, PWD);
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		
		Thread.sleep(5000);
		
				
		//enter the username and password
		//driver.findElement(By.id("username")).sendKeys(UN);
		//driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		//click on sign in button
		//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		//driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		//driver.findElement(By.name("targetSize")).clear();
		//driver.findElement(By.name("targetSize")).sendKeys(targetSize);
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//Thread.sleep(2000);
		
		String ConfMsg = cp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		//Assert.assertTrue(status, "Campaign not added");
		Assert.assertEquals(status, true, "Campaign not added");
		Reporter.log("Campaign "+ Campaign + " added successfully",true);
		
		//String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		
		//if(ConfMsg.contains(Campaign))
		//{
		//	Reporter.log("campaign "+Campaign+" added successfully",true);
		//}
		//else
		//{
		//	Reporter.log("campaign not added",true);
		//}
				
		//driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		
		Thread.sleep(5000);
		//dp.logout();
		
		//WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
       // Actions action=new Actions(driver);
       // action.moveToElement(logoutBtn).click().perform();
        //close the browser
       // driver.quit();
        
   	}
	
		//@Parameters("browser")
		//@Test(groups = {"Integration"})
		//@Test(priority = 1)
		//@Test(dependsOnMethods = "CreateCampaignTest")
		
		//public void createCampaignWithDateTest(String browser) throws InterruptedException, IOException {
			
		
		@Test()
	
		public void createCampaignWithDateTest() throws InterruptedException, IOException {

			//PropertiesFileUtility proputil = new PropertiesFileUtility();
			
			//String BROWSER = browser;//To use @parameter annotation
			//String BROWSER = proputil.readingDataFromPropFile("browser");
			//String URL = proputil.readingDataFromPropFile("url");
			//String UN = proputil.readingDataFromPropFile("uname");
			//String PWD = proputil.readingDataFromPropFile("pwd");

			JavaUtility jUtil = new JavaUtility();
			int randomNum = jUtil.getRandomNum(2000);
			
			ExcelFileUtility exutil = new ExcelFileUtility();
			String Campaign = exutil.readingDataFromExcel("DDT", 1, 2)+randomNum;
			String targetSize = exutil.readingDataFromExcel("DDT", 1, 3);
			
			String closeDate = jUtil.generateReqDate(30);
				
			String expectedURL="http://49.249.28.218:8098/dashboard";
			//Launching the browser
			//WebDriver driver=null;
			
			//ChromeOptions Coption = new ChromeOptions();
			//FirefoxOptions Foption = new FirefoxOptions();
			//EdgeOptions Eoption = new EdgeOptions();
			//Coption.addArguments("--headless");
			//Foption.addArguments("--headless");
			//Eoption.addArguments("--headless");

			//if(BROWSER.equalsIgnoreCase("chrome"))
			//{
			//	driver=new ChromeDriver(Coption);
			//}
			//else if(BROWSER.equalsIgnoreCase("firefox"))
			//{
			//	driver=new FirefoxDriver(Foption);
			//}
			//else if(BROWSER.equalsIgnoreCase("edge"))
			//{
			//	driver=new EdgeDriver(Eoption);
			//}
			//else
			//{
			//	driver=new ChromeDriver(Coption);
			//}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//navigating to ninza CRM
			//driver.get(URL);
			
			//LoginPage lp = new LoginPage(driver);
			//lp.login(UN, PWD);
			
			DashboardPage dp = new DashboardPage(driver);
			
			Thread.sleep(2000);
			
			dp.getCampaignsLink().click();
			
			CampaignsPage cp = new CampaignsPage(driver);
			cp.getCreateCampaignBtn().click();
			
			CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
			ccp.createCampaignWithCloseDate(Campaign, targetSize, closeDate);
			
			Thread.sleep(5000);
			
			//enter the username and password
			//driver.findElement(By.id("username")).sendKeys(UN);
			//driver.findElement(By.id("inputPassword")).sendKeys(PWD);
			//click on sign in button
			//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			//Thread.sleep(2000);
			//driver.findElement(By.linkText("Campaigns")).click();
			//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
			//driver.findElement(By.name("campaignName")).sendKeys(Campaign);
			//driver.findElement(By.name("targetSize")).clear();
			//driver.findElement(By.name("targetSize")).sendKeys(targetSize);
			//driver.findElement(By.name("expectedCloseDate")).sendKeys(closeDate);
			//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
			//Thread.sleep(2000);
			
			String ConfMsg = cp.getConfMsg().getText();
			boolean status = ConfMsg.contains(Campaign);
			//Assert.assertTrue(status, "Campaign not added");
			Assert.assertEquals(status, true, "Campaign not added");
			Reporter.log("Campaign "+ Campaign + " added successfully",true);
			
			//String ConfMsg = cp.getConfMsg().getText();
			//String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
			
			//if(ConfMsg.contains(Campaign))
			//{
			//	Reporter.log("campaign " + Campaign + " added successfully",true);
			//}
			//else
			//{
			//	Reporter.log("campaign not added",true);
			//}
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//div[@class='user-icon']")).click();
			
			//dp.logout();
			
	        //WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
	        //Actions action=new Actions(driver);
	       // action.moveToElement(logoutBtn).click().perform();
	        //close the browser
	       // driver.quit();
		}

	}
	
