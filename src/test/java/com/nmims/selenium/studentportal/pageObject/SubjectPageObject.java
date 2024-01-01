package com.nmims.selenium.studentportal.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nmims.selenium.studentportal.baseClass.BaseClass;

public class SubjectPageObject extends BaseClass{
	
	

	public  SubjectPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//small[normalize-space()='0 Courses']")
	protected WebElement zeroOngoingSubject;
	
	// When only displayed  backlog subject on the ui
	@FindBy (xpath="//a[@class=' text-dark list-group-item list-group-item-action']")
	public static List< WebElement> backlogSubjects;
	
	
	@FindBy (xpath="//a[contains(text(),'View')]")
	public  WebElement viewBacklogSubjectsTextLink;

	@FindBy (xpath="//div[@id='modal']//div//p//a")
	public static List< WebElement> listOfBacklogSubjctsInPopup;
	
	
	
	
	
	// Click on the backlog view text link
		public void clickToViewBacklogSubject() throws Exception {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0, 500);");

			Thread.sleep(5000);
			viewBacklogSubjectsTextLink.click();
			
			Thread.sleep(5000);
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
