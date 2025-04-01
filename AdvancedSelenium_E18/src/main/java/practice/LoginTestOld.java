package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginTestOld {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Nishanth\\eclipse-workspace\\AdvancedSelenium_E18\\src\\test\\resources\\Common.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("un");
		String PWD = prop.getProperty("pwd");
		System.out.println("BROWSER");
		System.out.println("URL");
		System.out.println("UN");
		System.out.println("PWD");
		
		String expectedURL = ("http://49.249.28.218:8098/dashboard");

		 WebDriver driver = new ChromeDriver();

		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 
		 driver.get("http://49.249.28.218:8098/");
		 
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rmgyantra");
		 
		 driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		 
		 driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		 
		 Thread.sleep(1000);
		 
		 String actualURL = driver.getCurrentUrl();
		 
		 if(actualURL.equals(expectedURL))
		 {
			 System.out.println("Validation is pass");
		 }
		 else
			 {
			 System.out.println("Validation has failed");
			 }
		 
		driver.findElement(By.xpath("//div[@class = 'user-icon']")).click();
		
		WebElement targetEle =  driver.findElement(By.xpath("//div[@class = 'dropdown-item logout']"));
				
		Actions act = new Actions(driver);
		 
		act.moveToElement(targetEle).click().perform();
		System.out.println("Hovering complete");
		
		 driver.quit();
		 
		
	}

}
