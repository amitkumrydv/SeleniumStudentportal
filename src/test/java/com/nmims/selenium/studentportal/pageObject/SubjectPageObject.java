package com.nmims.selenium.studentportal.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubjectPageObject {
	
	

	protected SubjectPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//small[normalize-space()='0 Courses']")
	protected WebElement zeroOngoingSubject;
	
	
	@FindBy (xpath="//a[@class=' text-dark list-group-item list-group-item-action']")
	public static List< WebElement> backlogSubjects;
	
	
	@FindBy (xpath="//a[contains(text(),'View  Backlog')]")
	public  WebElement viewBacklogSubjectsTextLink;

	@FindBy (xpath="//a[contains(@href,'/authenticate/student/viewCourseDetails')]")
	public static List< WebElement> listOfBacklogSubjctsInPopup;

}
