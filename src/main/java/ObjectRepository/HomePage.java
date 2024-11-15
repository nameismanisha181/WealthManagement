package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class HomePage {
	public WebDriver driver;
	WebdriverUtility wUtil= new WebdriverUtility();

	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLink;	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutBtn;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}	
	
	//Business Library
	/**
	 * This method will click on organization
	 */
	public void clickOnOrganization()
	{
		organizationLink.click();
	}
	/**
	 * This method will click on product 
	 */
	public void clickOnProduct()
	{
		productLink.click();
	}
	
	public void navigateToCampaign()
	{
		Actions action = new Actions(driver);
		action.moveToElement(moreLink).perform();
		action.moveToElement(CampaignLink).perform();		
	}
	
	public void SignOut(WebDriver driver)
	{
		wUtil.mouseOverAction(driver, AdministratorIcon);
		wUtil.mouseOverAction(driver, SignOutBtn);
		SignOutBtn.click();
	}
	
	
}
