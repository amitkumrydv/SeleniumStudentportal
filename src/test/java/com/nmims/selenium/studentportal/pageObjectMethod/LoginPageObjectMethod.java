package com.nmims.selenium.studentportal.pageObjectMethod;

import org.openqa.selenium.WebDriver;

import com.nmims.selenium.studentportal.pageObject.LoginPageObject;

public class LoginPageObjectMethod extends LoginPageObject {

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
<<<<<<< HEAD:src/test/java/com/selenium/studentportal/pageObjectMethod/LoginPageObjectMethod.java
		logoutButton.click();
		
	}
	
	
	
=======

		logoutButton.click();
	}
>>>>>>> a3a49d57e246893560c10009f37d1a90defaf7f4:src/test/java/com/nmims/selenium/studentportal/pageObjectMethod/LoginPageObjectMethod.java

}
