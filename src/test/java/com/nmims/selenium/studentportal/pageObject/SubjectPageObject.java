package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPageObject {

	protected SubjectPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//small[normalize-space()='0 Courses']")
	protected WebElement zeroOngoingSubject;

}
