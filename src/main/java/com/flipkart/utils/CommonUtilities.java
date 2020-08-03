package com.flipkart.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities extends Base
{
	//reusable actions coded in this class
	
	public CommonUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public static WebDriver getwindowHandle(WebDriver driver)
	{
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> Iterator = windowIds.iterator();
		while(Iterator.hasNext())
		{
			//String parentWindow = Iterator.next();
			String childWindow =Iterator.next();
			driver.switchTo().window(childWindow);
			//System.out.println(driver.getTitle());
		}
		return driver;
		
	}
	
	public static WebDriver waitTillVisibilityOf(WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
//	wait.until(ExpectedConditions.)
	return driver;
	}
	public static WebDriver waitAndClick(String element)
	{
		WebElement newelement = driver.findElement(By.xpath(element));
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(newelement));
	newelement.click();
//	wait.until(ExpectedConditions.)
	return driver;
	}
	
	public static WebDriver waitTillAlertisPresent()
	{
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.alertIsPresent());
//	wait.until(ExpectedConditions.)
	return driver;
	}
	
	public static void waits() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public static boolean verifyName(String actual, String expected)
	{
		boolean result = false;
		if(actual.equalsIgnoreCase(expected))
		{
			result=true;
		}
		return result;
	}

	public static String formatProductName(String unFormattedName)
	{
		String[] name1=unFormattedName.split(Pattern.quote("("));
		String searchScreenProductName = name1[0].trim();
		return searchScreenProductName;
	}

	public static String formatProductDescription(String unFormattedName)
	{
		String[] name1=unFormattedName.split(Pattern.quote("("));
		String[] SSdescription1 = name1[1].split(Pattern.quote(")"));
		String searchScreenDescription = SSdescription1[0];
		return searchScreenDescription;
	}
	public static void clickRemove(WebElement removeItem)
	{
		removeItem.click();
		
	}
	
	
	public static String removeUnWantedProductFromList(String productName, List<WebElement> element,WebElement remove,String removeitem)
	{
		
		List<WebElement> checkoutScreenProductNames= element;
		String requiredcheckoutScreenProductName="";
	//List<WebElement> checkoutScreenProductNames= checkoutPage.getcheckoutScreenProductNames();
	for(int i=0;i<checkoutScreenProductNames.size();i++)
	{ 
		String checkoutScreenProductName = checkoutScreenProductNames.get(i).getText();
		if (!checkoutScreenProductName.equals(productName))
		{
			remove.click();
			waitAndClick(removeitem);
		}
		else
		{
			 requiredcheckoutScreenProductName =checkoutScreenProductName;
		}
		
	}
	return requiredcheckoutScreenProductName;
	}
	
	}
