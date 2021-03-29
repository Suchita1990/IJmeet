
/*Project Name :Test Automation Framework
 * Author:Suchita Dorage for Resonantia
 * Client:
 * Organization:Testing Shastra
 */
package com.testingshastra.keywords;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class include all keywords which can be used to perform different
 * actions on Webpage.
 * 
 * @author Suchita
 *
 */
public class UIKeyword {

	/**
	 * this method used to open a specified browser
	 * @param browserName should only include Chrome,Firefox,IE,Edge.No browsername apart from mentioned is allowed
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			System.out.println("Chrome browser opening..");
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			Constants.driver = new EdgeDriver();
			break;
		default:
			System.err.println("Invalid Browser : " + browserName);
			break;
		}

	}

	
	/** 
	 * This method will Open the specified url in browser recently opened by driver instance
	 */
	
	public static void getURL(String url) {
		System.out.println(url + "  is loading...");
		Constants.driver.get(url);

	}

	/**
	 * Use this method to maximize the window 
	 * */
	
  	public static void maximize() {
		Constants.driver.manage().window().maximize();
	}
	
  	private static WebElement getWebElement(String locatorType, String locatorValue) {
  		WebElement element=null;
  		switch (locatorType) {
		case "XPATH":
			element=Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element=Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element=Constants.driver.findElement(By.id(locatorValue));
			break;
		case "LINKTEXT":
			element=Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element=Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "CLASS_NAME":
			element=Constants.driver.findElement(By.className(locatorValue));
			break;	

		default:
			System.err.println("Invalid locatorType : " + locatorType);
			break;
		}
  	   return element;
  	}
	/**
	 *Use this method to click on Radio button, check box, button or link 
	 * @param element
	 */
	
	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();

	}
	
	/**
	 * Use this method to enter text in text box.
	 * @param element
	 * @param text
	 */
	public static void enterText(String locatorType, String locatorValue , String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);

	}
	
	public void selectValueFromDropdown(String locatorType,String locatorValue,String textToSelect) {
		WebElement element = getWebElement(locatorType, locatorValue);
		Select select = new Select(element);
		select.selectByVisibleText(textToSelect);
		
	}

	/**
	 * Use this method to close the windows which pointed by the driver instance.
	 */
	public static void quiteBrowser() {
		Constants.driver.quit();

	}
	
	public void closeBrowser() {
		Constants.driver.close();

	}

}
