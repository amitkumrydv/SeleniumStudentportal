package com.nmims.selenium.studentportal.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObjectMethod.StudentBasicInfoPageObjectMethod;

public class StudentBasicInfoPageObject extends BaseClass {

	StudentBasicInfoPageObjectMethod webElementFetcher;

	public StudentBasicInfoPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[@class='student-name']")
	@CacheLookup
	protected WebElement studentName;

	@FindBy(xpath = "//div[@id='main-content-info-bar']//ul//li[contains(text(),'Validity End')]")
	@CacheLookup
	protected WebElement dateValidity;

	@FindBy(xpath = "//div[@id='main-content-info-bar']//ul//li")
	@CacheLookup
	protected List<WebElement> headerValue;
	
	
	
	
// get the name from the UI
	public String getStudentName() {

		String studentNameOnUI = studentName.getText();
		System.out.println("studentNameOnUI " + studentNameOnUI);
		return studentNameOnUI;
	}

	
	
	
	// get the header bar data from the ui
	public List<String> getHedartValues() {

		List<String> actualTextValues = new ArrayList<String>();

		for (WebElement element : headerValue) {
			actualTextValues.add(element.getText());
		}
		return actualTextValues;

	}
}
