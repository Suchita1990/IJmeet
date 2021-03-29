package com.baseclass;

import org.testng.annotations.BeforeMethod;

import com.testingshastra.keywords.UIKeyword;

public class Base_Class {

	@BeforeMethod
	public void openBrowser() {
		UIKeyword.openBrowser("Chrome");
		UIKeyword.maximize();
		UIKeyword.getURL("https://ijmeet.com/");

	}
	
	/*@AfterMethod
	public void quitBrowser() {
		keyword.quiteBrowser();

	}*/
}
