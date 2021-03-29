package com.testingshastra.uitests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.Base_Class;
import com.testingshastra.keywords.Constants;
import com.testingshastra.keywords.UIKeyword;

public class Homepage extends Base_Class {
	
	

	@Test
	public void verifyHomePageLogo() {
		String actual = Constants.driver.getTitle();
		System.out.println(actual);
		String expected = "IJmeet";
		Assert.assertEquals(expected, actual);
	}
	
}
