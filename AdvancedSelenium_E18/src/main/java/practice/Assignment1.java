package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://49.249.28.218:8098/");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.xpath("//span[text() = 'Create Campaign']")).click();
		
		driver.findElement(By.name("campaignName")).sendKeys("Deepak");
		
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys("100");

		driver.findElement(By.xpath("//button[text () = 'Create Campaign']")).click();
		
		Thread.sleep(2000);
		
		String ConfMsg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		
		if(ConfMsg.contains("Deepak")) {
			
			System.out.println("Campaign added successfully");
		}
		
		else
		{
			System.out.println("Campaign not added successfully");
		}
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@class = 'user-icon']")).click();
		
		WebElement logoutBtn = driver.findElement(By.xpath("//div[@class = 'dropdown-item logout']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(logoutBtn).click().perform();
		
		driver.quit();
		
		
		
		
		
		
		

		
		
		
		
		
	}

}
