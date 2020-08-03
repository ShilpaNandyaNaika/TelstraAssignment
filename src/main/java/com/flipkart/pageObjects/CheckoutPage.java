package com.flipkart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

	public WebDriver driver;

	private By checkoutScreenProductNames = By.xpath("//div[contains(text(),'My Cart')]/../../../..//div[@class='_1Ox9a7']");
	private By checkoutScreenPrice = By.xpath("//div[contains(text(),'My Cart')]/../../../..//span[@class='pMSy0p XU9vZa']");
	private By checkoutScreenDescription = By.xpath("//div[contains(text(),'My Cart')]/../../../..//div[@class='v7-Wbf']");
	private By placeOrder = By.xpath("//span[text()='Place Order']");
	private By logout = By.partialLinkText("Logout & Sign in to another account");
	private	By change = By.xpath("//button[text()='Change']");
	private	By deliverhere = By.xpath("//button[text()='Deliver Here']");
	private By myCart = By.xpath("//div[text()='My Cart']");
	private By remove = By.xpath("//div[text()='Remove']");
	String removeitem = "//div[@class='gdUKd9 _3Z4XMp _2nQDKB']";
	//private By removeItem = By.xpath("//div[@class='gdUKd9 _3Z4XMp _2nQDKB']");
	
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public List<WebElement> getcheckoutScreenProductNames() {
		return driver.findElements(checkoutScreenProductNames);
	}

	public WebElement getcheckoutScreenPrice() {
		return driver.findElement(checkoutScreenPrice);
	}

	public WebElement getcheckoutScreenDescription() {
		return driver.findElement(checkoutScreenDescription);
	}

	public WebElement getmyCart() {
		return driver.findElement(myCart);
	}
	public WebElement getremove() {
		return driver.findElement(remove);
	}
	public WebElement getplaceOrder() {
		return driver.findElement(placeOrder);
	}
	public WebElement getchange() {
		return driver.findElement(change);
	}
	public WebElement getlogout() {
		return driver.findElement(logout);
	}
	public WebElement getdeliverhere() {
		return driver.findElement(deliverhere);
	}
	public String getremoveItem() {
		return removeitem;
	}
	
}
