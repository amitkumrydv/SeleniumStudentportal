package com.nmims.selenium.studentportal.pageObjectMethod;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nmims.selenium.studentportal.pageObject.UserDtailsPageObject;




public class UserDtailsPageObjectMethod extends UserDtailsPageObject {
	 WebDriver driver;
	
	//List<WebElement> listOfasicDetails;

	public UserDtailsPageObjectMethod(WebDriver driver) {
		super(driver);
		}


	

}
