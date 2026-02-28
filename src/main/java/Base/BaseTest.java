package Base;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class BaseTest {
	protected Properties prop;
	public static IOSDriver driver;
	
	
	@BeforeClass
	public void AppiumSetup() throws IOException, URISyntaxException
	{
		prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream("IOSConfig.properties"));
		System.out.println("Loader Keys: " + prop.keySet());
		System.out.println("Appium App Opned:["+prop.getProperty("appiumURL")+"]");
		
		if(driver == null)
		{
			XCUITestOptions option = new XCUITestOptions();
			option.setPlatformName(prop.getProperty("platformName"));
			option.setDeviceName(prop.getProperty("deviceName"));
			option.setPlatformVersion(prop.getProperty("platformVersion"));
			option.setAutomationName(prop.getProperty("automationName"));
			option.setBundleId(prop.getProperty("bundleId"));
			option.setNoReset(Boolean.parseBoolean(prop.getProperty("noReset")));
			
			driver = new IOSDriver(new URI(prop.getProperty("appiumURL")).toURL(),option);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.terminateApp(prop.getProperty("bundleId"));
			driver.activateApp(prop.getProperty("bundleId"));
		}
	}

}
