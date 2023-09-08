package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardHeaderPageObject {

	WebDriver driver;

	public DashboardHeaderPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Dashboard Header buttons  
	
	@FindBy (xpath="//a[contains(text(),'Search')]" ) 
	@CacheLookup
	private WebElement searchButon;
	
	
	
	@FindBy (xpath="//a[normalize-space()='My Communications']") 
	@CacheLookup
	private WebElement communicationButon;  

	
	@FindBy (xpath="//div[@class='notification-count']") 
	@CacheLookup
	private WebElement notificationCount;  
	
	@FindBy (xpath="//a[@class='studentAnnouncementCounter']" ) 
	@CacheLookup
	private WebElement notificationButon;  
	
	@FindBy (xpath="//a[normalize-space()='My Profile']" ) 
	@CacheLookup
	private WebElement myProfileButon;  
	
	
	

}
