package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrganizationHeader;
	
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String OrganizationgHeader()
	{
		return OrganizationHeader.getText();
	}
}
