package ProductTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductsPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateProduct extends BaseClass {
		
		//@Parameters("browser")
		@Test(groups = {"Regression"})
	
		//public void CreateProductTest(String browser) throws IOException, InterruptedException{
		
		public void CreateProductTest() throws IOException, InterruptedException{

		//PropertiesFileUtility proputil = new PropertiesFileUtility();
		
		//String BROWSER = browser;//To use @parameter annotation
		//String BROWSER = proputil.readingDataFromPropFile("browser");
		//String URL = proputil.readingDataFromPropFile("url");
		//String UN = proputil.readingDataFromPropFile("uname");
		//String PWD = proputil.readingDataFromPropFile("pwd");
		
		JavaUtility jutil = new JavaUtility();
		int randomNum = jutil.getRandomNum(10000);
		
		ExcelFileUtility exutil = new ExcelFileUtility();
		String ProductName = exutil.readingDataFromExcel("Product",1,1)+randomNum;
		String Category = exutil.readingDataFromExcel("Product",1,2);
		String Quantity = exutil.readingDataFromExcel("Product",1,3)+randomNum;
		String Price = exutil.readingDataFromExcel("Product",1,4);
		String Vendor = exutil.readingDataFromExcel("Product",1,5)+randomNum;
				
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
		dp.getProductsLink().click();
				
		ProductsPage pp = new ProductsPage(driver);
		pp.getAddProductBtn().click();
						
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.createProductWithCampaign(ProductName, Category, Quantity, Price, Vendor);
		Thread.sleep(5000);
		
		String ConfirmationMsg = pp.getConfMsg().getText();
		boolean status = ConfirmationMsg.contains(ProductName);
		//Assert.assertTrue(status, "Campaign not added");
		Assert.assertEquals(status, true, "Product not added");
		Reporter.log("Product "+ ProductName + " added successfully",true);
		
		//String ConfMsg = pp.getConfMsg().getText();
		
		//if(ConfMsg.contains(ProductName))
		//{
		//	Reporter.log("campaign "+ProductName+" added successfully",true);
		//}
		//else
		//{
		//	Reporter.log("campaign not added",true);
		//}
		
//		Thread.sleep(5000);
		
		//dp.logout();
		//driver.quit();
		
		
		//driver.findElement(By.xpath("//div[@class='user-icon']")).click();
				
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//span[text() = 'Add Product']")).click();
		//driver.findElement(By.name("productName")).sendKeys(ProductName);
		//driver.findElement(By.name("productCategory")).sendKeys(Category);
		//driver.findElement(By.name("quantity")).clear();
		//driver.findElement(By.name("quantity")).sendKeys(Quantity);
		//driver.findElement(By.name("price")).clear();
		//driver.findElement(By.name("price")).sendKeys(Price);
		//driver.findElement(By.name("vendorId")).sendKeys(Vendor);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Thread.sleep(5000);
		
		
	
		
		
		//driver.findElement(By.xpath("//div[@class = 'user-icon']")).click();
		//driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		
		
		
	}

}
