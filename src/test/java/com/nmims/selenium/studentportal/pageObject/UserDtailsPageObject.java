package com.nmims.selenium.studentportal.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDtailsPageObject {
	
	public static WebDriver driver;
	
	public UserDtailsPageObject(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[@class=\"student-name\"]")
	@CacheLookup
	public static WebElement studentName;


	
	
	
	


}
