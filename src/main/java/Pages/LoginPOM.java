package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class LoginPOM {
	private IOSDriver driver;
	public LoginPOM(IOSDriver driver)
	{
		this.driver=driver;
	}
	By username = AppiumBy.iOSNsPredicateString("name == 'test-Username'");
	By password = AppiumBy.accessibilityId("test-Password");
	By login = AppiumBy.accessibilityId("test-LOGIN");
	By error = AppiumBy.iOSNsPredicateString("name == 'test-Error message'");
	By productpage = AppiumBy.accessibilityId("test-Cart");
	
	public void user(String user,String pass)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		
		
	}
	public void loginclick()
	{
		/*if(driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}*/
		driver.findElement(login).click();
	}
	public boolean error()
	{
		boolean errormessage = driver.findElements(error).size()>0;
		
		return errormessage;
		
		
	}
	public ProductPOM testcartpage()
	{
		boolean isCartVisible = driver.findElement(productpage).isDisplayed();
		Assert.assertTrue(isCartVisible);
		return new ProductPOM(driver);
	}

}
