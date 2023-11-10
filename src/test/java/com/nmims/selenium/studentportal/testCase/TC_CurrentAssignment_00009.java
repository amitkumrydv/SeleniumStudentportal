package com.nmims.selenium.studentportal.testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pageObjectMethod.AssignmentPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_CurrentAssignment_00009 extends BaseClass {
	
	private List<String> assignmentList;
	private CaptureScreen captureScreenshot;
	ReadConfig readConfig = new ReadConfig();
	private String user = readConfig.getUsername();

	@Test
	public void currentAssignmetTest () {
		
	LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);
	loginPage.commanLogin();
	logger.info("Successful login test ");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	AssignmentPageObjectMethod assignmentsListOnUI = new AssignmentPageObjectMethod(driver);
	assignmentList = assignmentsListOnUI.assignmetCountOnUI(driver);
	logger.info("assignmentList  --> "+ assignmentList);
	
	
	// Test Xpath
//	WebElement xpath =driver.findElement(By.xpath("//div[@class='sz-content large-padding-top']//li[1]//div[1]//div[1]//a//span[1]"));
//
//	String firstSubject = xpath.getText();
//	System.out.println("firstSubject  --> "+ firstSubject);
	
	
	
	
	}
}
