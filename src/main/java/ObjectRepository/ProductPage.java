package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	//declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement ProducPlusImage;
	
	//initialization
     public ProductPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }

   //utilization
	public WebElement getProductLink() 
	{
		return ProducPlusImage;
	}
     
   //Business Library
	public void ClickOnProductImage()
	{
		ProducPlusImage.click();
	}     
     
}
