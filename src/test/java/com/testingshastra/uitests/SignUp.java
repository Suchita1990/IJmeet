package com.testingshastra.uitests;



import org.testng.annotations.Test;

import com.baseclass.Base_Class;
import com.testingshastra.keywords.UIKeyword;

public class SignUp extends Base_Class {
	@Test
	public void signUpTest() {
		System.out.println("Click on Signup");
		UIKeyword.clickOnElement("XPATH", "//a[@class='nav-link nav-right-cutom-bg-1 font-weight-bold']");
		
	}

}
