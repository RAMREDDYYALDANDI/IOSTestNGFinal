package Logics;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.ProductPOM;

public class PageLogic extends BaseTest{
	
	@Test(dependsOnMethods="Logics.LoginLogic.logintest")
	public void productselection()
	{
		ProductPOM productPage = new ProductPOM(driver);
		driver.getPageSource();
		
		System.out.println("✅ Starting Product Selection Flow...");
		productPage.productscroll("Sauce Labs Onesie");
		productPage.clicktoproduct("Sauce Labs Onesie");
		System.out.println("✅ Added Item 1: Onesie");
		
		productPage.productscroll("Sauce Labs Backpack");
		productPage.clicktoproduct("Sauce Labs Backpack");
System.out.println("✅ Added Item 2: Backpack");
        
        System.out.println("✅ Both products added successfully!");
		
	}

}
