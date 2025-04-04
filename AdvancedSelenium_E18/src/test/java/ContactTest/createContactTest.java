package ContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class createContactTest extends BaseClass {
	
		//@Parameters("browser")
		@Test(groups = {"System"})
		//public void createContactWithCampaignTest(String browser) throws IOException, InterruptedException {
			
		public void createContactWithCampaignTest() throws IOException, InterruptedException {

		//PropertiesFileUtility proputil = new PropertiesFileUtility();
		
		//String BROWSER = browser;//To use @parameter annotation
		//String BROWSER = proputil.readingDataFromPropFile("browser");
		//String URL = proputil.readingDataFromPropFile("url");
		//String UN = proputil.readingDataFromPropFile("uname");
		//String PWD = proputil.readingDataFromPropFile("pwd");
			
		JavaUtility jutil = new JavaUtility();
		int randomNum = jutil.getRandomNum(2000);
		
		ExcelFileUtility exutil = new ExcelFileUtility();
		String Campaign = exutil.readingDataFromExcel("DDT", 1, 2)+randomNum;
		String targetSize = exutil.readingDataFromExcel("DDT", 1, 3);
		String organization = exutil.readingDataFromExcel("Contact",1,2)+randomNum;
		String title = exutil.readingDataFromExcel("Contact",1,3);
		String contactName = exutil.readingDataFromExcel("Contact",1,4)+randomNum;
		String mobile = exutil.readingDataFromExcel("Contact",1,5);
		
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
		//driver.get(URL);
		
		//LoginPage lp = new LoginPage(driver);
		//lp.login(UN, PWD);
		
		//driver.findElement(By.id("username")).sendKeys(UN);
		//driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		Thread.sleep(3000);
		
		WebElement contactLink = dp.getContactsLink();
		WebDriverUtility Wutil = new WebDriverUtility();
		Wutil.waitForElementToBeClickable(driver, contactLink, 20);
		contactLink.click();
		
		Thread.sleep(5000);
		
		ContactsPage ccp1 = new ContactsPage(driver);
		WebElement createContactBtn = ccp1.getCreateContactBtn();
		Wutil.waitForElementToBeClickable(driver, createContactBtn, 20);
		createContactBtn.click();
		
		CreateContactPage cct = new CreateContactPage(driver);
		cct.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign", "create-contact", Campaign);
				
	    Thread.sleep(3000);
	    
	    String ConfirmationMsg = ccp1.getConfMsg().getText();
		boolean status = ConfirmationMsg.contains(contactName);
		//Assert.assertTrue(status, "Campaign not added");
		Assert.assertEquals(status, true, "Contact not added");
		Reporter.log("Contact "+ contactName + " added successfully",true);
		
		//String ConfirmationMsg = ccp1.getConfMsg().getText();
		
		//if(ConfirmationMsg.contains(contactName))
		//{
		//	Reporter.log("Contact " + contactName + " added successfully",true);
		//}
		//else
		//{
        //	Reporter.log("Contact not added",true);
        //}
		
		Thread.sleep(5000);
		//dp.logout();
		//driver.quit();
		
		
		//driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		//driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		//driver.findElement(By.name("targetSize")).sendKeys(targetSize);
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		//Thread.sleep(3000);
		
		//WebElement contactLink = driver.findElement(By.linkText("Contacts"));
		
		//WebDriverUtility Wutil = new WebDriverUtility();
		//Wutil.waitForElementToBeClickable(driver, contactLink, 20);
		//contactLink.click();
		
		//Thread.sleep(5000);
		
		//WebElement createContactBtn = driver.findElement(By.xpath("//span[text()='Create Contact']"));
		
		//Wutil.waitForElementToBeClickable(driver, createContactBtn, 20);		
		//createContactBtn.click();
		
		//driver.findElement(By.name("organizationName")).sendKeys(organization);
		//driver.findElement(By.name("title")).sendKeys(title);
		//driver.findElement(By.name("contactName")).sendKeys(contactName);
		//driver.findElement(By.name("mobile")).sendKeys(mobile);
		//driver.findElement(By.xpath("//button[@type='button' and contains(@style,'white-space')]")).click();
		
		
		//Wutil.switchToWindow(driver, "selectCampaign");
		
		//WebElement selectTypeDD = driver.findElement(By.id("search-criteria"));
		
		//Wutil.select(selectTypeDD, "campaignName");
		
        //Select select1 = new Select(selectTypeDD);
        //select1.selectByValue("campaignName");
       // driver.findElement(By.id("search-input")).sendKeys(Campaign);
       // driver.findElement(By.xpath("//button[@class='select-btn']")).click();
         
         
       // Wutil.switchToWindow(driver, "create-contact");
         
                  
        //driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
       // Thread.sleep(3000);
      //  String ConfirmationMsg = driver.findElement(By.xpath("//div[text()='Contact "+contactName+" Successfully Added']")).getText();
      //  if(ConfirmationMsg.contains(contactName))
      //  {
      //  	System.out.println("Contact added Successfully");
      //  }
      //  else
      //  {
      //  	System.out.println("Contact not added");
      //  }
        
       // Thread.sleep(5000);
       // driver.findElement(By.xpath("//*[name()='svg' and @role=\"img\"]")).click();
        
        
		//dp.logout();
        //WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
       // Actions action=new Actions(driver);
       // action.moveToElement(logout).click().perform();
     //   driver.quit();
	}

}
 