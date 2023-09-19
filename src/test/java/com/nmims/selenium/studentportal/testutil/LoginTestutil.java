package com.nmims.selenium.studentportal.testutil;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BasClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pom.LoginPageObjectMethod;


 public class LoginTestutil extends BasClass {
	
	
	@Test(dataProvider = "Login" , dataProviderClass= DataProvideLogin.class)
	public void loginTest(String user, String pwd) throws Exception {	
		
		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		String pageHeaderTitle = loginPage.verifyTitle(); // This is page header title
		System.out.println("page header title is " + pageHeaderTitle);

		String tabTitle = driver.getTitle(); // This is page tab title
		System.out.println("page title is " + tabTitle);

		// Verify the tab title
		if (driver.getTitle().equals(tabTitle)) {
			Assert.assertTrue(true);
			logger.info("Login page title is match");

		} else {
			captureScreen(driver, "loginTest");
			logger.info("Login page title is not match");
			Assert.assertTrue(false);
		}
		
		loginPage.setUserName(user);
		logger.info("Entered the UserId");
		loginPage.setPassword(pwd); 
		logger.info("Entered the password");
		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		
	
	}
	

}
