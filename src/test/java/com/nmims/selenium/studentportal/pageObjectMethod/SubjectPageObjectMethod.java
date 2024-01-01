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
	
	
	

	// Comman method to apply substring on the web element 
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
	
	
	// If student does not have subject
	public String getZeroOngoingSubject() {
		
		String ZeroSubject =zeroOngoingSubject.getText();
		return ZeroSubject;
	}
	

	
	// Using above method for substring logic
	public List<String> getBacklogSubjectList() {
		
		 ArrayList<WebElement> backlogSubjectsListFromUI = new ArrayList<>(SubjectPageObject.backlogSubjects);
		 
		 System.out.println("backlogSubjectsListFromUI         --->" +backlogSubjectsListFromUI);
		 List<String> elementTexts = new ArrayList<>();
		
		 for (WebElement element : backlogSubjectsListFromUI) {
	            elementTexts.add(element.getText());
	        }
		// List<String> modifiedList = applySubstring(backlogSubjectsListFromUI, 2);
		
		 
		 System.out.println("elementTexts         --->"+elementTexts);
		return elementTexts;
	}
	
	
	public List<String> getBacklogSubjectFromPopup(){
		
		ArrayList <WebElement> backlogSubjectFromPopup= new ArrayList<>(SubjectPageObject.listOfBacklogSubjctsInPopup);
		List<String> elementTexts = new ArrayList<>();
		 for (WebElement element : backlogSubjectFromPopup) {
	            elementTexts.add(element.getText());
         }
		// List<String> removeNumbersFromeSubject = applySubstring(backlogSubjectFromPopup, 2);
		
		return elementTexts;
	}
	
	
	
}
