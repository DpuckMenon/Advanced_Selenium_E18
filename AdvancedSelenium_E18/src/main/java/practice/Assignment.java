package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://49.249.28.218:8098/");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		driver.findElement(By.xpath("//input[@name = 'organizationName']")).sendKeys("Google");
		
		driver.findElement(By.xpath("//input[@name = 'title']")).sendKeys("Mr.");
		
		driver.findElement(By.xpath("//input[@name = 'contactName']")).sendKeys("Deep");
		
		driver.findElement(By.xpath("//input[@name = 'mobile']")).sendKeys("9886123456");
		
		driver.findElement(By.xpath("//div[@class='form-group']//descendant::button")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[@id = 'campaign-table']//descendant::button[5]")).click();
		
		
	

	}

}
