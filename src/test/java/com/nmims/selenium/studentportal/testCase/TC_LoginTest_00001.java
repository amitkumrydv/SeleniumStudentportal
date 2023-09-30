package com.nmims.selenium.studentportal.testCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;

public class TC_LoginTest_00001 extends BaseClass {

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class, groups = "authentication")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {

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
        
		// Wait for all element in script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Is display title
		Assert.assertTrue(loginPage.verifyNmimsLogo(), "Logo is not displayed on the page");

		loginPage.clickLogout();
		logger.info("Click on the logout button ");

		Thread.sleep(5000);
		logger.info("Page logout ");

		// Switch on the alert alert
		Alert alert = driver.switchTo().alert();
		logger.info("Alert text Displayed : " + alert.getText());
		alert.accept();
		logger.info("Logout");
		Assert.assertEquals(driver.getTitle(), tabTitle);

	}


}
