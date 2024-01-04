package com.nmims.selenium.studentportal.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObjectMethod.SubjectPageObjectMethod;

public class SubjectPageObject extends BaseClass {

	

	public SubjectPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='collapseFour']//div/a")
	public List<WebElement> OngoingSubjectlistOnUI;

	@FindBy(xpath = "//small[normalize-space()='0 Courses']")
	protected WebElement zeroOngoingSubject;

	// When only displayed backlog subject on the ui
	@FindBy(xpath = "//a[@class=' text-dark list-group-item list-group-item-action']")
	public static List<WebElement> backlogSubjects;

	@FindBy(xpath = "//a[contains(text(),'View')]")
	public WebElement viewBacklogSubjectsTextLink;

	@FindBy(xpath = "//div[@id='modal']//div//p//a")
	public static List<WebElement> listOfBacklogSubjctsInPopup;

	// Click on the backlog view text link
	public void clickToViewBacklogSubject() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 500);");

		Thread.sleep(5000);
		viewBacklogSubjectsTextLink.click();

		Thread.sleep(5000);

	}

	// ongoing Subject list
	public List<String> getOngoingSubjectsFromUI() throws InterruptedException {

		List<String> modifiedList = new ArrayList<String>();
		for (WebElement OngoingSubjectlis : OngoingSubjectlistOnUI) {
			String OngoingSubjectlisText = OngoingSubjectlis.getText();
			String modifiedElement = OngoingSubjectlisText.substring(2);
			modifiedList.add(modifiedElement);
			
			// modifiedList.add(elementText);

		}

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
			backlogSubjectlistInText.add(backlogSubjectList.getText());
		}
		// List<String> modifiedList = applySubstring(backlogSubjectsListFromUI, 2);

		return backlogSubjectlistInText;
	}

	// Get the the subject list from the popup.
	public List<String> getBacklogSubjectFromPopup() {

		List<String> backlogSubjectlistInPopup = new ArrayList<>();
		for (WebElement element : listOfBacklogSubjctsInPopup) {
			backlogSubjectlistInPopup.add(element.getText());
		}
		// List<String> removeNumbersFromeSubject =
		// applySubstring(backlogSubjectFromPopup, 2);

		return backlogSubjectlistInPopup;
	}

}
