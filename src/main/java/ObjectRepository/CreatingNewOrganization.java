package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class CreatingNewOrganization {

	 WebdriverUtility wUtil= new WebdriverUtility();
	//declaration
	@FindBy(name = "accountname")
	private WebElement OrganizationTxt;
	
	@FindBy(id = "phone")
	private WebElement PhoneTxt;
	
	@FindBy(id = "email1")
	private WebElement EmailTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
		
	//initialization	
	public CreatingNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationTxt() {
		return OrganizationTxt;
	}

	public WebElement getPhoneTxt() {
		return PhoneTxt;
	}

	public WebElement getEmailTxt() {
		return EmailTxt;
	}
	
	//Business Logic
	public void CreateOrganization(String OrgName,String Email,String PhoneNumber)
	{
		OrganizationTxt.sendKeys(OrgName);
		PhoneTxt.sendKeys(PhoneNumber);
		EmailTxt.sendKeys(Email);
		SaveBtn.click();
	}	
	
	public void CreateOrganization(String OrgName,WebElement industryType)
	{
		OrganizationTxt.sendKeys(OrgName);
		wUtil.handleDropDown(industryType,2);
		SaveBtn.click();
	}
}