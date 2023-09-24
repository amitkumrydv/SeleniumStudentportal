package com.nmims.selenium.studentportal.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDtailsPageObject {
	
	public UserDtailsPageObject(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[normalize-space()='ASHISH KUMAR']")
	@CacheLookup
	protected  WebElement studentName;


	
	
	
	


}
