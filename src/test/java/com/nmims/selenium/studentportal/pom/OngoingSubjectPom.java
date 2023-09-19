package com.nmims.selenium.studentportal.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OngoingSubjectPom {
	
	
	
	List<String> actualSubjectList = new ArrayList<String>();

	public List<String> getOngoingSubjectFromUI(WebDriver driver, String xpath) {
		List<WebElement> OngoingSubjectLocationOnUI = driver.findElements(By.xpath(xpath));
		List<String> modifiedList = applySubstring(OngoingSubjectLocationOnUI, 2);           // on the web have every count numners of subjets  now here remove the number
		System.out.println(" modifiedList " +modifiedList);
		//logger.info("subject list modifiedList by substring ");

		return modifiedList;
	}
	
	
	

	// apply substring on the web element
	private List<String> applySubstring(List<WebElement> inputList, int startIndex) {
		List<String> modifiedList = new ArrayList<String>();
		for (WebElement element : inputList) {
			String elementText = element.getText();
			String modifiedElement = elementText.substring(startIndex);
			modifiedList.add(modifiedElement);
			//modifiedList.add(elementText);

		}
		return modifiedList;
	}

}
