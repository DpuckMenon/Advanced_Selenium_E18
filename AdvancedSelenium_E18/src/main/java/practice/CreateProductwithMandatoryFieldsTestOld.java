package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateProductwithMandatoryFieldsTestOld {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Nishanth\\eclipse-workspace\\AdvancedSelenium_E18\\src\\test\\resources\\Common.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("uname");
		String PWD = prop.getProperty("pwd");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Nishanth\\eclipse-workspace\\AdvancedSelenium_E18\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String ProductName = wb.getSheet("Product").getRow(1).getCell(1).getStringCellValue();
		String Category = wb.getSheet("Product").getRow(1).getCell(2).getStringCellValue();
		String Quantity = wb.getSheet("Product").getRow(1).getCell(3).getStringCellValue();
		String Price = wb.getSheet("Product").getRow(1).getCell(4).getStringCellValue();
		String Vendor = wb.getSheet("Product").getRow(1).getCell(5).getStringCellValue();
		
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();	
		}
		else if (BROWSER.contentEquals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text() = 'Add Product']")).click();
		driver.findElement(By.name("productName")).sendKeys(ProductName);
		driver.findElement(By.name("productCategory")).sendKeys(Category);
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys(Quantity);
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys(Price);
		driver.findElement(By.name("vendorId")).sendKeys(Vendor);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class = 'user-icon']")).click();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
