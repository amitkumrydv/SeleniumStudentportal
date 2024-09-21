package com.nmims.selenium.studentportal.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import com.nmims.selenium.studentportal.action.ActionClass;
import com.nmims.selenium.studentportal.baseClass.BaseClass;

public class SiderBarMenuPageObject extends BaseClass {

	ActionClass actionClass;
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public SiderBarMenuPageObject(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	Actions actions = new Actions(driver);

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

	@FindBy(xpath = "//li[@id='csSidebarIcon']//a[@href=\"/careerservices/Home\"]")
	public WebElement ClickableMousHoverCareerServices;

	@FindBy(xpath = "//a[@href=\"/studentportal/student/connectWithUs\"]//span")
	public WebElement ClickableMousHoverStudentSupport;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href=\"/almashines/student/welcomeToAlmashines\"]")
	public WebElement ClickableNGASCEAlumniPortal;

	@FindBy(xpath = "//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/myBadges']")
	public WebElement ClickableMyBadges;

	@FindBy(xpath = "//li[@data-parenttab='/studentportalapp/dashboard']//*[name()='svg']")
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

		boolean displayManueArrow = expandMenueArrow.isDisplayed();

		Assert.state(displayManueArrow);
		return displayManueArrow;

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

			boolean DashboardIcon = clickableDashboardIconStudentportal.isDisplayed();
			Assert.state(DashboardIcon);

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
		boolean acadicon = clickableAcadIcan.isDisplayed();
		Assert.state(acadicon);

	}

	public void clickOnDisplayAcadIcon() {

		clickableAcad.click();
	}

	// My Courses
	public void isDisplayMycoursesIcon() {

		WebElement clickableMycoursesIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableMycourses));
		boolean myCoursesIcon = clickableMycoursesIcon.isDisplayed();
		Assert.state(myCoursesIcon);

	}

	public void clickOnDisplayMycoursesIcon() {

		clickableMycourses.click();
	}

	// Session video

	public void isDisplaySesionvideoIcon() {

		WebElement clickableSesionvideoIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableSesionvideo));
		boolean sesionvideoIcon = clickableSesionvideoIcon.isDisplayed();
		Assert.state(sesionvideoIcon);

		clickableSesionvideo.isDisplayed();
	}

	public void clickOnDisplaySesionvideoIcon() {

		clickableSesionvideo.click();
	}

	// BookMark

	public void isDisplayBookmarkIcon() {

		WebElement clickableBookmarkIcon = wait.until(ExpectedConditions.elementToBeClickable(clickableBookmark));
		boolean bookmarkIcon = clickableBookmarkIcon.isDisplayed();
		Assert.state(bookmarkIcon);

		clickableBookmark.isDisplayed();
	}

	public void clickOnDisplayBookmarkIcon() {

		clickableBookmark.click();
	}

	// Exam
	public void isDisplayExamIcon() {

		WebElement clickableExamIconn = wait.until(ExpectedConditions.elementToBeClickable(ClickableMousHoverExam));
		boolean examIcon = clickableExamIconn.isDisplayed();
		Assert.state(examIcon);

	}

	public void mouseHoverExamIcon() {

		actions.moveToElement(ClickableMousHoverExam).perform();

	}

	// Career Service

	public void isDisplayCareerServicesIcon() {

		WebElement clickableCareerServicesIcon = wait
				.until(ExpectedConditions.elementToBeClickable(ClickableMousHoverCareerServices));
		boolean careerServicesIcon = clickableCareerServicesIcon.isDisplayed();
		Assert.state(careerServicesIcon);

	}

	public void clickOnDisplayCareerServicesIcon() {

		ClickableMousHoverCareerServices.click();
	}

	// StudentSupport

	public void isDisplayStudentSupportIcon() {

		WebElement clickableStudentSupportIcon = wait
				.until(ExpectedConditions.elementToBeClickable(ClickableMousHoverStudentSupport));
		boolean studentSupportIcon = clickableStudentSupportIcon.isDisplayed();
		Assert.state(studentSupportIcon);

	}

	public void clickOnDisplayStudentSupportIcon() {

		ClickableMousHoverStudentSupport.click();
	}

	// NGASCEAlumniPortal

	public void isDisplayNGASCEAlumniPortalIcon() {

		WebElement clickableNGASCEAlumniPortalIcon = wait
				.until(ExpectedConditions.elementToBeClickable(ClickableNGASCEAlumniPortal));
		boolean NGASCEAlumniPortalIcon = clickableNGASCEAlumniPortalIcon.isDisplayed();
		Assert.state(NGASCEAlumniPortalIcon);

	}

	public void clickOnDisplayNGASCEAlumniPortalIcon() {

		ClickableNGASCEAlumniPortal.click();
	}

	// MyBadges
	public void isDisplayMyBadgesIcon() {

		WebElement clickableMyBadgesIcon = wait.until(ExpectedConditions.elementToBeClickable(ClickableMyBadges));
		boolean myBadgesIcon = clickableMyBadgesIcon.isDisplayed();
		Assert.state(myBadgesIcon);

	}

	public void clickOnDisplayMyBadgesIcon() {

		ClickableMyBadges.click();
	}

	// QuickLinks
	public void isDisplayQuickLinksIcon() {

		WebElement clickableQuickLinksIcon = wait.until(ExpectedConditions.elementToBeClickable(mouseHoverQuickLinks));
		boolean quickLinksIcon = clickableQuickLinksIcon.isDisplayed();
		Assert.state(quickLinksIcon);

	}

	public void clickOnDisplayQuickLinksIcon() {

		mouseHoverQuickLinks.click();
	}

}
