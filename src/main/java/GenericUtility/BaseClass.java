package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public PropertyFileUtility prop= new PropertyFileUtility();
	public WebdriverUtility wUtil= new WebdriverUtility();

	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		driver=new EdgeDriver();
		wUtil.maximizeWindow(driver);
		wUtil.implicitlyWait(driver);		
		String URL = prop.getPropertyValue("url");
		driver.get(URL);
	}
	@BeforeMethod  
	public void LoginToApp() throws IOException
	{   
		String USERNAME = prop.getPropertyValue("username");
		String PASSWORD = prop.getPropertyValue("password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	@AfterMethod
	public void LogoutFromApp()
	{
		HomePage hp = new HomePage(driver);
		hp.SignOut(driver);
	}
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}
}
