package com.flipkart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	private By myAccount = By.xpath("//div[text()='My Account']");
	private By searchBox = By.xpath("//input[@title ='Search for products, brands and more']");
	private By searchButton = By.xpath("//button[@type='submit']");
	private By camaraList =  By.xpath("//a[@class='_31qSD5']");
	private By listCameraToSelect = By.xpath("//div[@class='bhgxx2 col-12-12'][4]");
	private By cartForItems = By.xpath("//a[@class='_3ko_Ud']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

		public WebElement getSearch() {
		return driver.findElement(searchBox);
	}
	
	public WebElement getMyAccount() {
		return driver.findElement(myAccount);
	}
		
		public WebElement getsearchButton() {
			return driver.findElement(searchButton);
				
	}
		

		public WebElement getlistCameraToSelect() {
			return driver.findElement(listCameraToSelect);
			
	}

		public WebElement getcartForItems() {
			return driver.findElement(cartForItems);
			
	}
}
