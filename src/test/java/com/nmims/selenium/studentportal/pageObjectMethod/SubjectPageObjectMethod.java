package com.nmims.selenium.studentportal.pageObjectMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nmims.selenium.studentportal.pageObject.SubjectPageObject;


public class SubjectPageObjectMethod extends SubjectPageObject {
	
	
	public SubjectPageObjectMethod(WebDriver driver) {
		super(driver);
	}

	public List<String> getOngoingSubjectFromUI(WebDriver driver, String xpath) {
		List<WebElement> OngoingSubjectLocationOnUI = driver.findElements(By.xpath(xpath));
		// on the web have every subjets with numners now here remove the number
		List<String> modifiedList = applySubstring(OngoingSubjectLocationOnUI, 2);           

		return modifiedList;
	}
	
	
	

	// apply substring on the web element 
	private List<String> applySubstring(List<WebElement> inputList, int startIndex) {
		//logger.info("Applying Substring on the Suject");
		List<String> modifiedList = new ArrayList<String>();
		for (WebElement element : inputList) {
			String elementText = element.getText();
			String modifiedElement = elementText.substring(startIndex);
			modifiedList.add(modifiedElement);
			//modifiedList.add(elementText);

		}
		return modifiedList;
	}
	
	public String getZeroOngoingSubject() {
		
		String ZeroSubject =zeroOngoingSubject.getText();
		return ZeroSubject;
	}
	

}
