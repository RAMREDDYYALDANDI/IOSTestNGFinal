package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.Guesters;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class ProductPOM {

	public IOSDriver driver;
	public Guesters guest;
	public WebDriverWait wait;
	
	public ProductPOM(IOSDriver driver) {
		this.driver=driver;
		this.guest= new Guesters(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	 By productpage = By.xpath("//XCUIElementTypeStaticText[@name='PRODUCTS']");
	    By productList = AppiumBy.accessibilityId("test-Item");
	    By addtocart = AppiumBy.accessibilityId("test-ADD TO CART");
	    By scrollView = AppiumBy.className("XCUIElementTypeScrollView"); // Define it here

	    By cartClassChain = AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther");
	    
	    public void productscroll(String productname)
	    {
	    	 System.out.println("🔍 Jenkins Sync: Waiting for Page to settle...");
	 		wait.until(ExpectedConditions.presenceOfElementLocated(productpage));
	 		 wait.until(ExpectedConditions.visibilityOfElementLocated(productpage));
	 		 driver.findElement(productpage).isDisplayed();
	 		// CALL THE GUESTERS HERE - This was the missing link!
	 	    guest.scrolltoElement(productname);  		
	    }
	    
	    public void clicktoproduct(String productname)
	    {
	    	
	    	 // 1. Find all product containers (boxes)
	        List<WebElement> products = driver.findElements(productList);
	        boolean found = false;

	        for (int i = 0; i < products.size(); i++) {
	            // 2. Get the label from the specific box
	            String actualName = products.get(i).getAttribute("label");

	            if (actualName != null && actualName.contains(productname)) {
	                // 3. IMPORTANT: Search INSIDE this specific box for the button
	                products.get(i).findElement(addtocart).click(); 
	                System.out.println("✅ CLICKED: " + productname);
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            Assert.fail("Could not find product to click: " + productname);
	        }
	    	}
	    	
	    	
	    }
	    
	    
	
	


