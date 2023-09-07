package com.selenium.studentportal.testCase;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.studentportal.action.ActionHandler;
import com.selenium.studentportal.baseClass.BasClass;
import com.selenium.studentportal.data.DataProvideLogin;
import com.selenium.studentportal.pageObject.LoginPageObject;
import com.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.selenium.studentportal.testutil.LoginTestutil;
import com.selenium.studentportal.utilities.XLUtils;

public class TC_LoginTest_00001 extends LoginTestutil {
	

	

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

	@Test(dependsOnMethods = "loginTest", alwaysRun = true)
	public void logoutTest() throws InterruptedException, IOException {
		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);
		loginPage.clickLogout();
		Thread.sleep(5000);
		logger.info("Page logout ");
		
//		boolean isAlertPresent = ActionHandler.isAlertPresent();
//		
//		 if (isAlertPresent) {
//	            // Handle the alert
//	            Alert alert = driver.switchTo().alert();
//	            System.out.println("Alert text Displayed : " + alert.getText());
//	            alert.accept(); // Click OK (or dismiss with alert.dismiss() in case of a Cancel button)
//	        } else {
//	            System.out.println("No alert found.");
//	        }
		
		
		driver.switchTo().alert();                    //Switch on the alert alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text Displayed : " + alert.getText());
		
		
		
		
		LoginPageObjectMethod loginPageObject = new LoginPageObjectMethod(driver);

		String pageHeaderTitle = loginPageObject.verifyTitle(); // This is page header title
		System.out.println("page header title is " + pageHeaderTitle);

		String tabTitle = driver.getTitle(); // This is page tab title
		logger.info("page title is " + tabTitle);

		// Verify the tab title
		if (driver.getTitle().equals(tabTitle)) {
			Assert.assertTrue(true);
			logger.info("After logout the Login page title is match");

		} else {
			captureScreen(driver, "loginTest");
			logger.info("After logout the Login page title is not match");
			Assert.assertTrue(false);
		}
		
		
		
	
			
		

	}
	
	
	



}
