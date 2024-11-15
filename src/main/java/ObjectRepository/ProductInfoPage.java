package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductInfo;
	
	//initialization 
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getProductInfo() {
		return ProductInfo;
	}
	
	//business library 
	public String getProductName()
	{
		return ProductInfo.getText();
	}
	
}
