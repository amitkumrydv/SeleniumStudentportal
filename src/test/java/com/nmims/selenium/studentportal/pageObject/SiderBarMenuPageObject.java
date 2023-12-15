package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nmims.selenium.studentportal.action.ActionClass;
import com.nmims.selenium.studentportal.baseClass.BaseClass;

public class SiderBarMenuPageObject extends BaseClass {

	ActionClass actionClass;
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public SiderBarMenuPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='toggle-nav']//a")
	public WebElement expandMenueArrow;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/authenticate/home']")
	public WebElement clickableDashboardAuthenticate;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/home']")
	public WebElement clickableDashboardStudentportal;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/acads/student/viewStudentTimeTable']")
	public WebElement clickableAcad;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/viewCourseHomePage']")
	public WebElement clickableMycourses;

	// This is dynamic xpath becouse of change month and year
	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href=\"/acads/student/videosHome?pageNo=1&academicCycle=Jul2023\"]")
	public WebElement clickableSesionvideo;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/bookmarks']")
	public WebElement clickableBookmark;

	@FindBy(xpath = "//a[@href='/exam/student/getMostRecentResults']")
	public WebElement ClickableMousHoverExam;

	@FindBy(xpath = "//a[@href=\"/studentportal/student/connectWithUs\"]//span")
	public WebElement ClickableMousHoverStudentSupport;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href=\"/almashines/student/welcomeToAlmashines\"]")
	public WebElement ClickableNGASCEAlumniPortal;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/myBadges']")
	public WebElement ClickableMyBadges;

	@FindBy(xpath = "//a[@href=\"#\"]")
	public WebElement mouseHoverQuickLinks;

	public void clickOnDisplayExamIcon() {

//		//actionClass.mouseover(driver, ClickableMousHoverExam);
//		boolean ExamButtonelement = ClickableMousHoverExam.isDisplayed();
//		System.out.println("ExamButtonelement "+ExamButtonelement);
//		
//		ClickableMousHoverExam.click();
	}

//To check the Dashboard top arrow
	public boolean isVisibleExpandArrow() {

		boolean isDisplayManueArrow = expandMenueArrow.isDisplayed();
		System.out.println("isDisplayManueArrow " + isDisplayManueArrow);
		return isDisplayManueArrow;

	}

	// Dashboard
	public void isDisplayDashboardIcon() {
		
		
		

//		if (clickableDashboardAuthenticate != null && clickableDashboardAuthenticate.isSelected()) {
//			WebElement clickableDashboardIconAuthenticate = wait
//					.until(ExpectedConditions.elementToBeClickable(clickableDashboardAuthenticate));
//			boolean isDisplayDashboardIcon = clickableDashboardIconAuthenticate.isDisplayed();
//			System.out.println("isDisplayDashboardIcon " + isDisplayDashboardIcon);
//		}
		if (clickableDashboardStudentportal != null && clickableDashboardStudentportal.isEnabled()) {
			WebElement clickableDashboardIconStudentportal = wait
					.until(ExpectedConditions.elementToBeClickable(clickableDashboardStudentportal));

			boolean isDisplayDashboardIcon = clickableDashboardIconStudentportal.isDisplayed();
			logger.info("isDisplayDashboardIcon " + isDisplayDashboardIcon);

		} else {
			System.out.println(" Element not found ");
		}
	}

	public void clickOnDisplayDashboardIcon() {

		clickableDashboardAuthenticate.click();
	}

	// Acads

	public void isDisplayAcadIcon() {

		WebElement clickableAcadIcan = wait.until(ExpectedConditions.elementToBeClickable(clickableAcad));
		boolean acadButtonelement = clickableAcadIcan.isDisplayed();
		logger.info("clickableAcadIcan " + acadButtonelement);
	}

	public void clickOnDisplayAcadIcon() {

		clickableAcad.click();
	}

	// My Courses
	public void isDisplayMycoursesIcon() {

		WebElement clickableMycoursesIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableMycourses));
		boolean myCoursesIconButtone = clickableMycoursesIcon.isDisplayed();
		logger.info("myCoursesIconButtonelement " + myCoursesIconButtone);
	}

	public void clickOnDisplayMycoursesIcon() {

		clickableMycourses.click();
	}

	// Session video

	public void isDisplaySesionvideoIcon() {

		WebElement clickableSesionvideoIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableSesionvideo));
		boolean sesionvideoIconButtone = clickableSesionvideoIcon.isDisplayed();
		logger.info("sesionvideoIconButtone " + sesionvideoIconButtone);

		clickableSesionvideo.isDisplayed();
	}

	public void clickOnDisplaySesionvideoIcon() {

		clickableSesionvideo.click();
	}

	// BookMark

	public void isDisplayBookmarkIcon() {

		WebElement clickableBookmarkIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableBookmark));
		boolean bookmarkIconButtone = clickableBookmarkIcon.isDisplayed();
		logger.info("bookmarkIconButtone " + bookmarkIconButtone);

		clickableBookmark.isDisplayed();
	}

	public void clickOnDisplayBookmarkIcon() {

		clickableBookmark.click();
	}

	// Exam
	public void isDisplayExamIcon() {

		WebElement clickableExamIconn = wait.until(ExpectedConditions.elementToBeClickable(ClickableMousHoverExam));
		boolean examIconButtone = clickableExamIconn.isDisplayed();
		logger.info("examIconButtone " + examIconButtone);

	}

	// StudentSupport

	public void isDisplayStudentSupportIcon() {

		WebElement clickableStudentSupportIcon = wait
				.until(ExpectedConditions.elementToBeClickable(ClickableMousHoverStudentSupport));
		boolean studentSupportIconButtone = clickableStudentSupportIcon.isDisplayed();
		logger.info("studentSupportIconButtone " + studentSupportIconButtone);

	}

	public void clickOnDisplayStudentSupportIcon() {

		ClickableMousHoverStudentSupport.click();
	}

	// NGASCEAlumniPortal

	public void isDisplayNGASCEAlumniPortalIcon() {

		WebElement clickableNGASCEAlumniPortalIcon = wait
				.until(ExpectedConditions.elementToBeClickable(ClickableNGASCEAlumniPortal));
		boolean NGASCEAlumniPortalIconButtone = clickableNGASCEAlumniPortalIcon.isDisplayed();
		logger.info("NGASCEAlumniPortalIconButtone " + NGASCEAlumniPortalIconButtone);

	}

	public void clickOnDisplayNGASCEAlumniPortalIcon() {

		ClickableNGASCEAlumniPortal.click();
	}

	// MyBadges
	public void isDisplayMyBadgesIcon() {

		WebElement clickableMyBadgesIcon = wait.until(ExpectedConditions.elementToBeClickable(ClickableMyBadges));
		boolean myBadgesIconButtone = clickableMyBadgesIcon.isDisplayed();
		logger.info("myBadgesIconButtone " + myBadgesIconButtone);
	}

	public void clickOnDisplayMyBadgesIcon() {

		ClickableMyBadges.click();
	}

	// QuickLinks
	public void isDisplayQuickLinksIcon() {

		WebElement clickableQuickLinksIcon = wait.until(ExpectedConditions.elementToBeClickable(mouseHoverQuickLinks));
		boolean quickLinksIconButtone = clickableQuickLinksIcon.isDisplayed();
		logger.info("quickLinksIconButtone " + quickLinksIconButtone);

	}

	public void clickOnDisplayQuickLinksIcon() {

		mouseHoverQuickLinks.click();
	}

}
