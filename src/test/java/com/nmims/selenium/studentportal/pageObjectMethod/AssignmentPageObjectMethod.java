package com.nmims.selenium.studentportal.pageObjectMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nmims.selenium.studentportal.pageObject.AssignmentPageObject;

public class AssignmentPageObjectMethod extends AssignmentPageObject {

	List<WebElement> CurrentAssignmentsOnUI;
	List<String> assignmentListInText = new ArrayList<String>();
	List<String> assignmentList = new ArrayList<String>();

	public AssignmentPageObjectMethod(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	public List<String> getAssignmentFromUI(WebDriver driver, String xpath) {
//		List<WebElement> CurrentAssignmentsOnUI = driver.findElements(By.xpath(xpath));
//		List<String> assignmentListInText = new ArrayList<String>();
//
//		for (WebElement elements : CurrentAssignmentsOnUI) {
//			String elementsText = elements.getText();
//			assignmentListInText.add(elementsText);
//		}
//
//		System.out.println("assignmentListInText " + assignmentListInText);
//
//		return assignmentListInText;
//	}

	
	//Display on UI assignment name store in list with single xpath
	public List<String> assignmetCountOnUI(WebDriver driver) {

		int numberOfAssignment = assignmentCount.size();

		System.out.println("numberOfAssignment -> " + numberOfAssignment);

		for (int i = 1; i <= numberOfAssignment; i++) {

			String assignmentXpath = "//div[@class='sz-content large-padding-top']//li["+i+"]//div[1]//div[1]//a//span[1]";
			CurrentAssignmentsOnUI = driver.findElements(By.xpath(assignmentXpath));

			for (WebElement elements : CurrentAssignmentsOnUI) {
				String elementsText = elements.getText();
				assignmentListInText.add(elementsText);
			}
		}
		
		// Use a regular expression to find repeated consecutive words
//        Pattern pattern = Pattern.compile("(\\b\\w+\\b)(?:\\s+\\1)+|\\s+");// Pattern.CASE_INSENSITIVE);
//        for (String inputText : assignmentListInText) {
//            Matcher matcher = pattern.matcher(inputText);
//            String resultText = matcher.replaceAll("$1");
//            assignmentList.add(resultText);
//        }
//        
//        for (String resultText : assignmentList) {
//            System.out.println("+++++++++++"+resultText);
//        }
//        
//


		return assignmentListInText;

	}

}
