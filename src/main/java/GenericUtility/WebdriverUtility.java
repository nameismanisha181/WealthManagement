package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{	
	/**
	 * This method will maximize browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElementToBeVissible(WebDriver  driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	public void handleDropDown(WebElement element,String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	public void handleDropDown(String vissibleText,WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(vissibleText);
	}
	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method will perform double action
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method will perform right click action
	 * @param element
	 * @param driver
	 */
	public void rightClick(WebElement element,WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by id or name
	 * @param driver
	 * @param idOrName
	 */
	public void handleFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	/**
	 * This method will handle frame by element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch to immediate parent
	 * @param driver
	 */
	public void switchToPatrentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch to main page
	 * @param driver
	 */
	public void switchToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will scroll into element using action class
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("winodw.scrollBy(0,500)");
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("winodw.scrollBy(0,-500)");
	}
	/**
	 * This method will scroll into particular element
	 * @param driver
	 * @param element
	 */
	public void scrollIntoElementJavaScript(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	/**
	 * This method will take screenshot and return absolute path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./errorShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();  //for extend reports
	}
}












