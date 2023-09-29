package com.nmims.selenium.studentportal.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentPageObject {
	
	protected AssignmentPageObject(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	// Dynamic xpath
	@FindBy (xpath="//div[@class='sz-content large-padding-top']//li[1]//div[1]//div[1]//a//span")
	WebElement assignment;
	
	@FindBy (xpath="//ul[@class='list-group ']//li")
	protected List<WebElement> assignmentCount;
	

}
