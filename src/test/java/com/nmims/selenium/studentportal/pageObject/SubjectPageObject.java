package com.nmims.selenium.studentportal.pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nmims.selenium.studentportal.action.ActionClass;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObjectMethod.SubjectPageObjectMethod;

public class SubjectPageObject extends BaseClass {

	ActionClass actionClass = new ActionClass();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
            

	public SubjectPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='collapseFour']//div/a")
	public List<WebElement> OngoingSubjectlistOnUI;

	@FindBy(xpath = "//small[normalize-space()='0 Courses']")
	protected WebElement zeroOngoingSubject;

	// When only displayed backlog subject on the ui
	@FindBy(xpath = "//div[@id='collapseFour']//a//span[contains(@class,'mt-2')]")
	public  List<WebElement> backlogSubjects;

	 //@FindBy(xpath = "//a[contains(text(),'View')]")
	// @FindBy(xpath = "//div[@id='collapseFour']//a[@href='#']")
	@FindBy(xpath = " //div[@id='collapseFour']//li//a")
	public WebElement viewBacklogSubjectsTextLink;

	//@FindBy(xpath = "//div[@id='modal']//div//p//a")
	@FindBy(xpath = "//div[@id='modal']//a")
	public List<WebElement> listOfBacklogSubjctsInPopup;

	// Click on the backlog view text link
	public void clickToViewBacklogSubject() throws Exception {

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("window.scrollBy(0, 500);");

		// System.out.println("Scroll the page for backlog subject");
		// actionClass.scrollByVisibilityOfElement(driver, viewBacklogSubjectsTextLink);

		actionClass.moveToElement(driver, viewBacklogSubjectsTextLink);

		// driver.execute_script("arguments[0].scrollIntoView({ behavior: 'smooth',
		// block: 'center', inline: 'center' });", viewBacklogSubjectsTextLink);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		viewBacklogSubjectsTextLink.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// }

	}

	// ongoing Subject list
	public List<String> getOngoingSubjectsFromUI() throws InterruptedException {
		List<String> modifiedList = new ArrayList<String>();
		for (WebElement OngoingSubjectlis : OngoingSubjectlistOnUI) {
			String OngoingSubjectlisText = OngoingSubjectlis.getText().substring(2);			
			modifiedList.add(OngoingSubjectlisText);

			// modifiedList.add(elementText);

		}
		
		System.out.println("modifiedList OngoingSubjectlistOnUI--> "+ modifiedList.size());

		return modifiedList;
	}

	// If student does not have subject
	public String getZeroOngoingSubject() {

		String ZeroSubject = zeroOngoingSubject.getText();
		return ZeroSubject;
	}

	// Using above method for substring logic
	public List<String> getBacklogSubjectList() {

		List<String> backlogSubjectlistInText = new ArrayList<>();

		for (WebElement backlogSubjectList : backlogSubjects) {
			String listOfBacklogSubject = backlogSubjectList.getText();
			String useSubstringToRemoveTheCount = listOfBacklogSubject.substring(2);

			backlogSubjectlistInText.add(useSubstringToRemoveTheCount);

		}
		// List<String> modifiedList = applySubstring(backlogSubjectsListFromUI, 2);

		return backlogSubjectlistInText;
	}

	// Get the the subject list from the popup.
	public List<String> getBacklogSubjectFromPopup() throws InterruptedException {

		List<String> backlogSubjectlistInPopup = new ArrayList<>();
		for (WebElement element : listOfBacklogSubjctsInPopup) {
			backlogSubjectlistInPopup.add(element.getText());
		}
		// List<String> removeNumbersFromeSubject =
		// applySubstring(backlogSubjectFromPopup, 2);

		System.out.println("backlogSubjectlistInPopup " + backlogSubjectlistInPopup);
		return backlogSubjectlistInPopup;
	}

}
