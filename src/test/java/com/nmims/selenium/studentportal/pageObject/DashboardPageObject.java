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
		// js.executeScript("arguments[0].scrollIntoView(true);", footerText);

		// Set window size to full height
	//	driver.manage().window().setSize(new Dimension(1920, totalHeight.intValue()));

		// Get the dimensions of the footer element
		int footerHeight = footerText.getSize().getHeight();

		// Calculate the height to scroll, excluding the footer
		int scrollHeight = totalHeight.intValue() - footerHeight;

		// Scroll to the bottom of the page
		// js.executeScript("window.scrollTo(0, arguments[0]);", scrollHeight);

		return scrollHeight;

	}

}