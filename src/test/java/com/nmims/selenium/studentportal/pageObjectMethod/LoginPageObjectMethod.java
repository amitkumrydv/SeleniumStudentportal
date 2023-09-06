package com.nmims.selenium.studentportal.pageObjectMethod;

import org.openqa.selenium.WebDriver;

import com.nmims.selenium.studentportal.pageObject.LoginPageObject;

public class LoginPageObjectMethod extends LoginPageObject{
	

	
	public LoginPageObjectMethod(WebDriver driver) {
		super(driver);
	
	}


	public String verifyTitle() {
		return loginPageTitle.getText();
	}
	
	
	public void setUserName(String userName) {
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

}
