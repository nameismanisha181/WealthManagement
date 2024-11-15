package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
	@FindBy(name = "user_name")
	private WebElement UserNameTxt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTxt;
	
	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getUserNameTxt() {
		return UserNameTxt;
	}

	public WebElement getPasswordTxt() {
		return PasswordTxt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Library
	
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		UserNameTxt.sendKeys(USERNAME);
		PasswordTxt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
