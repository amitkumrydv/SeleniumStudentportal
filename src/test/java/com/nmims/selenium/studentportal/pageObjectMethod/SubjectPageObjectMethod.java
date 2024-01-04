package com.nmims.selenium.studentportal.pageObjectMethod;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;



public class SubjectPageObjectMethod {

	// Comman method to apply substring on the web element
	public List<String> applySubstring(List<WebElement> inputList, int startIndex) {
		List<String> modifiedList = new ArrayList<String>();
		
		System.out.println("input  ----");
		for (WebElement element : inputList) {
			String elementText = element.getText();
			String modifiedElement = elementText.substring(startIndex);
			modifiedList.add(modifiedElement);
			// modifiedList.add(elementText);

		}
		return modifiedList;
	}

}
