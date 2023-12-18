package com.nmims.selenium.studentportal.testutil;

import java.io.IOException;

import org.testng.Assert;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;

public class Login extends BaseClass{
	
	public static CaptureScreen captureScreenshot;
	
	
	
	public  static void  loginPageTitleVerify() throws IOException {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		String pageHeaderTitle = loginPage.verifyTitle(); // This is page header title
		logger.info("page header title is " + pageHeaderTitle);

		String tabTitle = driver.getTitle(); // This is page tab title
		logger.info("page title is " + tabTitle);

		// Verify the tab title
		if (driver.getTitle().equals(tabTitle)) {
			Assert.assertTrue(true);
			logger.info("Login page title is match");

		} else {
			captureScreenshot.captureFullScreen(driver, "loginTest");
			logger.info("Login page title is not match");
			Assert.assertTrue(false);
		}

	}
	


}
