package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;

public class DashboardPageObject extends BaseClass {

	public DashboardPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	private CaptureScreen captureScreenshot;

//Footer

	@FindBy(xpath = "//p[text()=\"© 2024 NMIMS. All Rights Reserved.\"]")
	WebElement footerText;

	public int footerHeight() throws InterruptedException {

		// Scroll to the footer
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		// Get the total height of the webpage
		Long totalHeight = (Long) js.executeScript("return document.body.scrollHeight");

		System.out.println("totalHeight--- " + totalHeight);
		
		int footerHeight = footerText.getSize().getHeight();
		
		System.out.println("footerHeight -"+ footerHeight);

		int scrollHeight = totalHeight.intValue() - footerHeight;

		return scrollHeight;

	}

}