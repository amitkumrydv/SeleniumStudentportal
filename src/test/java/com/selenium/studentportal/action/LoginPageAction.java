package com.selenium.studentportal.action;

import org.openqa.selenium.WebDriver;

import com.selenium.studentportal.pageObject.LoginPageObject;

public class LoginPageAction extends LoginPageObject{
	

	
	public LoginPageAction(WebDriver driver) {
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

}
