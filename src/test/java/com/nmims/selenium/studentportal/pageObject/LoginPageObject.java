package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	
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
	
	

	
	



}
