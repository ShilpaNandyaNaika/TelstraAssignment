package com.flipkart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flipkart.utils.Base;

public class LoginPage {

	public WebDriver driver;

	private By Login = By.xpath("//a[text()='Login']");
	private By closeButton = By.xpath("//button[text()='✕']");
	private By userName= By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	private By passWord = By.xpath("//input[@type='password']");
	private By submitButton = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(Login);
	}
	
	public WebElement getCloseIcon() {
		return driver.findElement(closeButton);
	}
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getpassWord() {
		return driver.findElement(passWord);
	}

	public WebElement getsubmitButton() {
		return driver.findElement(submitButton);
	}
	

	
}
