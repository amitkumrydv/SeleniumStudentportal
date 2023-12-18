package com.nmims.selenium.studentportal.pageObjectMethod;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;

import com.nmims.selenium.studentportal.pageObject.LoginPageObject;
import com.nmims.selenium.studentportal.testutil.Login;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class LoginPageObjectMethod extends LoginPageObject {

//	WebDriver LoginPageDriver= BaseClass.setup();
	public Login login;

	ReadConfig readConfig = new ReadConfig();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getPassword();

	public static Logger logger;

	public LoginPageObjectMethod(WebDriver driver) {
		super(driver);

	}

	public String verifyTitle() {
		return loginPageTitle.getText();
	}

	public void setUserName(String userName) {
		System.out.println(" Inside setUserName " + userName);
		userId.clear();
		userId.sendKeys(userName);
	}

	public void setPassword(String password) {
		pswd.clear();
		pswd.sendKeys(password);
	}

	public void clickSubmit() {
		loginButton.click();
	}

	public void clickLogout() {
		logoutButton.click();
	}

	public boolean verifyNmimsLogo() {
		return nmimsLogo.isDisplayed();
	}

	public void commanLogin() {

		try {
			logger = Logger.getLogger("Selenium_studentPortal");
			PropertyConfigurator.configure("Log4j.properties");

			Login.loginPageTitleVerify();

			setUserName(userName);
			logger.info("Entered the UserId");
			setPassword(password);
			logger.info("Entered the password");
			clickSubmit();
			logger.info("Click on the login button ");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
