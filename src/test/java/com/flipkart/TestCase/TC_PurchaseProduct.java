package com.flipkart.TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.pageObjects.CheckoutPage;
import com.flipkart.pageObjects.LandingPage;
import com.flipkart.pageObjects.LoginPage;
import com.flipkart.pageObjects.ProductsSeachPage;
import com.flipkart.utils.Base;
import com.flipkart.utils.CommonUtilities;
import com.google.inject.spi.DependencyAndSource;

public class TC_PurchaseProduct extends Base {
	
	
    //Launches the required browser - provide the BrowserType in BaseClass
	@BeforeTest
	public void initalize() throws IOException {
		driver = initalizeDriver();
	}
 
	//Verifies Successful Login of user - Credentials shall be provided in Data.properties
	@Test
	public void loginUser() throws IOException, InterruptedException {

		LoginPage LoginPage = new LoginPage(driver);

		LoginPage.getCloseIcon().click();
		LoginPage.getLogin().click();
		LoginPage.getUserName().sendKeys(properties.getProperty("username"));
		LoginPage.getpassWord().sendKeys(properties.getProperty("password"));
		LoginPage.getsubmitButton().click();

	}

		
   // Search & Select camera only after successful login
	@Test(dependsOnMethods = { "loginUser" })
	public void searchAndSelectProduct() throws IOException, InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		CommonUtilities.waitTillVisibilityOf(landingPage.getMyAccount());
		
		landingPage.getSearch().sendKeys("Camera");
		landingPage.getsearchButton().click();
		CommonUtilities.waitTillVisibilityOf(landingPage.getlistCameraToSelect());
	
		landingPage.getlistCameraToSelect().click();
		System.out.println(driver.getTitle());
		CommonUtilities.getwindowHandle(driver);

	}

	//Clears the cart , Purchases the product selected in previous TC 
	@Test(dependsOnMethods = { "searchAndSelectProduct" })
	public void purchaseProduct() throws IOException, InterruptedException {
		ProductsSeachPage productsSeachPage = new ProductsSeachPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		String displayedName = productsSeachPage.getsearchScreenProductName().getText();
		String searchScreenProductName = CommonUtilities.formatProductName(displayedName);
		String searchScreenDescription = CommonUtilities.formatProductDescription(displayedName);

		
		if (!productsSeachPage.getgoToCart().isEnabled()) {
			System.out.println("Item is out of Stock");
		} else {
			productsSeachPage.getgoToCart().click();
		}

		CommonUtilities.waits();		
		String checkoutScreenProductName =CommonUtilities.removeUnWantedProductFromList(searchScreenProductName,checkoutPage.getcheckoutScreenProductNames(),checkoutPage.getremove(),checkoutPage.getremoveItem());
		
		CommonUtilities.waits();
		System.out.println(checkoutPage.getcheckoutScreenPrice().getText()) ;
		String checkoutScreenDescription = checkoutPage.getcheckoutScreenDescription().getText();
		
		// Asserts whether expected and actual prduct name & Description are same
		System.out.println(searchScreenProductName+"=="+checkoutScreenProductName);
		System.out.println(searchScreenDescription+"=="+checkoutScreenDescription);
		assertTrue(CommonUtilities.verifyName(searchScreenProductName, checkoutScreenProductName));
		assertTrue(CommonUtilities.verifyName(searchScreenDescription, checkoutScreenDescription));
		checkoutPage.getplaceOrder().click();

		CommonUtilities.waitTillVisibilityOf(checkoutPage.getdeliverhere());
		checkoutPage.getchange().click();
		checkoutPage.getlogout().click();
	}

	@AfterTest
	public void teardown() {
		driver.quit();

	}
}
