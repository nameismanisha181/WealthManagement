package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {

	//declaration
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//initialization
	public CreatingNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business library
	public void createProduct(String ProductName)
	{
		productName.sendKeys(ProductName);
		saveButton.click();
	}
	
}
