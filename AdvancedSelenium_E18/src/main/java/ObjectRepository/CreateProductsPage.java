package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {
	
	WebDriver driver;
	public CreateProductsPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy (name = "productName")
	private WebElement productName;
	
	@FindBy (name = "productCategory")
	private WebElement selCatDD;
	
	@FindBy (name = "quantity")
	private WebElement quantity;
	
	@FindBy (name = "price")
	private WebElement price;
	
	@FindBy (name = "vendorId")
	private WebElement vendorIdDD;
	
	@FindBy (xpath = "//button[text() = 'Add']")
	private WebElement addBtn;

	@FindBy (xpath = "//div[@role='alert']")
	private WebElement ConfMsg;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProdCatDD() {
		return selCatDD;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorIdDD() {
		return vendorIdDD;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	public void createProductWithCampaign(String prodname, String cat, String qty, String Price, String vndrID)
	{
		productName.sendKeys(prodname);
		
		quantity.clear();
		quantity.sendKeys(qty);
		price.sendKeys(Price);
		
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(selCatDD,2);
		wUtil.select(vendorIdDD, 1);
		addBtn.click();
		
		
			
		
	}
	
	
	
	
	
}
