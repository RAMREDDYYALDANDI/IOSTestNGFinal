package Utils;

import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;

public class Guesters {
	public IOSDriver driver;
	
	public Guesters(IOSDriver driver)
	{
		this.driver=driver;
	}
	
	public void scrolltoElement(String productName) {
	    HashMap<String, Object> scroll = new HashMap<>();
	    scroll.put("direction", "down");
	    scroll.put("label", productName); // THIS is what searches for the text
	    scroll.put("toVisible", true);
	    driver.executeScript("mobile:scroll", scroll);
	}

	

}
