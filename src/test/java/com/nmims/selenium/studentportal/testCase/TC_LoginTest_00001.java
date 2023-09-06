package com.nmims.selenium.studentportal.testCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BasClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pageObject.LoginPageObject;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.XLUtils;

public class TC_LoginTest_00001 extends BasClass {
	
	

	// Read the data using property file
	/*
	 * @Test public void loginTest() throws IOException {
	 * 
	 * driver.get(baseURL); logger.info("URL is opend");
	 * 
	 * LoginPageAction loginPage = new LoginPageAction(driver);
	 * 
	 * String pageHeaderTitle=loginPage.verifyTitle(); // This is page header title
	 * System.out.println("page header title is "+pageHeaderTitle);
	 * 
	 * String tabTitle =driver.getTitle(); // This is page tab title
	 * System.out.println("page title is "+ tabTitle);
	 * 
	 * // Verify the tab title if(driver.getTitle().equals(pageHeaderTitle)){
	 * Assert.assertTrue(true); logger.info("Login page title is match"); } else {
	 * 
	 * captureScreen(driver, "TC_LoginTest_00001");
	 * logger.info("Login page title is not match"); Assert.assertTrue(false);
	 * 
	 * }
	 * 
	 * loginPage.setUserName(userName); logger.info("Entered the UserId");
	 * loginPage.setPassword(password); logger.info("Entered the password");
	 * loginPage.clickSubmit();
	 * 
	 * 
	 * }
	 * 
	 */

	// Using DataDriven frame-work for the login

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
			captureScreen(driver, "TC_LoginTest_00001");
			logger.info("Login page title is not match");
			Assert.assertTrue(false);
		}
		
		loginPage.setUserName(user);
		logger.info("Entered the UserId");
		loginPage.setPassword(pwd); 
		logger.info("Entered the password");
		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		loginPage.clickLogout();
		logger.info("Click on the Logout button ");
		
		

	}

	

}
