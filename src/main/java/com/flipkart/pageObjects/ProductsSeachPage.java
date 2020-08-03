package com.flipkart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsSeachPage {

	public WebDriver driver;

	private By searchScreenProductName = By.xpath("//span[@class='_35KyD6']");
	private By searchScreenPrice = By.xpath("//div[@class='_1vC4OE _3qQ9m1']");
	private By goToCart = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	
	
	public ProductsSeachPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getsearchScreenProductName() {
		return driver.findElement(searchScreenProductName);
	}
	
	public WebElement getsearchScreenPrice() {
		return driver.findElement(searchScreenPrice);
	}
	public WebElement getgoToCart() {
		return driver.findElement(goToCart);
	}
}
