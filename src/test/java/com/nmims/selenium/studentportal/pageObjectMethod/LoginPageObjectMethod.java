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

	public static Logger logger;

	public LoginPageObjectMethod(WebDriver driver) {
		super(driver);

	}



}
