package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement organizationPlusImage;
	
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrganizationPlusImage() 
	{
		return organizationPlusImage;
	}
	
	//Business Library
	public void clickOnOrganizationImage()
	{
		organizationPlusImage.click();
	}
	
}
