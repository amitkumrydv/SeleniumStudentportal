package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SymbolsPageObject {
	
	// Dasboard Header Symbols
	@FindBy (xpath="//a[@href='#']") 
	@CacheLookup
	WebElement globalSearchsymbol;  
	
	@FindBy (xpath="//a[@href=\"/studentportal/student/myEmailCommunicationsForm\"]" ) 
	@CacheLookup
	WebElement communicationSymbol;  
	
	@FindBy (xpath="//a[@class='studentAnnouncementCounter']" ) 
	@CacheLookup
	WebElement notificationSymbol;  
	
	@FindBy (xpath="//span[contains(@class,'fa-regular fa-user')]" ) 
	@CacheLookup
	WebElement myProfileButon;  

}
