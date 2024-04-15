package com.nmims.selenium.studentportal.pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.testutil.Login;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class LoginPageObject extends BaseClass{
	
	
	
	ReadConfig readConfig = new ReadConfig();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getPassword();

	
	public LoginPageObject(WebDriver driver) {
		
		PageFactory.initElements(driver, this); // Define as page object class
	}
	
	
    // Xpath
	@FindBy(xpath = "//h2[contains(text(),'WELCOME TO NGASCE')]")
	@CacheLookup
	protected WebElement loginPageTitle;

	@FindBy(id = "userId")
	@CacheLookup
	protected WebElement userId;

	@FindBy(name = "password")
	@CacheLookup
	protected WebElement pswd;

	@FindBy(xpath = "//button[contains(text(), 'LOGIN')]")
	@CacheLookup
	protected WebElement loginButton;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	protected WebElement logoutButton;
	
	
	@FindBy(xpath = "//div[@class='sz-logo']//img[@class='img-responsive']")
	@CacheLookup
	protected WebElement nmimsLogo;
	
	
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

	public void commanLogin() throws InterruptedException, IOException {


			logger = Logger.getLogger("Selenium_studentPortal");
			PropertyConfigurator.configure("Log4j.properties");

			Login.loginPageTitleVerify();

			setUserName(userName);
			logger.info("Entered the UserId");
			setPassword(password);
			logger.info("Entered the password");
			clickSubmit();
			logger.info("Click on the login button ");
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			
			

		
	}


}
