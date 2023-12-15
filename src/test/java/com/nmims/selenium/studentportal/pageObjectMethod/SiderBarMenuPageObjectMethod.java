package com.nmims.selenium.studentportal.pageObjectMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;

import com.nmims.selenium.studentportal.action.ActionClass;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObject.SiderBarMenuPageObject;

public class SiderBarMenuPageObjectMethod extends SiderBarMenuPageObject  {
	
	
	
	
	public ActionClass actionClass;

	public SiderBarMenuPageObjectMethod(WebDriver driver) {
		super(driver);

	}
	

	// To check the Dashboard top arrow
	public boolean isVisibleExpandArrow() {

		boolean isDisplayManueArrow = expandMenueArrow.isDisplayed();
		return isDisplayManueArrow;

	}

	// Dashboard
	public void isDisplayDashboardIcon() {

		clickableDashboardStudentportal.isDisplayed();
	}

	public void clickOnDisplayDashboardIcon() {

		clickableDashboardStudentportal.click();
	}

	// Acads

	public void isDisplayAcadIcon() {

		clickableAcad.isDisplayed();
	}

	public void clickOnDisplayAcadIcon() {

		clickableAcad.click();
	}

	// My Courses
	public void isDisplayMycoursesIcon() {

		clickableMycourses.isDisplayed();
	}

	public void clickOnDisplayMycoursesIcon() {

		clickableMycourses.click();
	}

	// Session video

	public void isDisplaySesionvideoIcon() {

		clickableSesionvideo.isDisplayed();
	}

	public void clickOnDisplaySesionvideoIcon() {

		clickableSesionvideo.click();
	}

	// BookMark

	public void isDisplayBookmarkIcon() {

		clickableBookmark.isDisplayed();
	}

	public void clickOnDisplayBookmarkIcon() {

		clickableBookmark.click();
	}

	// Exam
	public void isDisplayExamIcon() {

		ClickableMousHoverExam.isDisplayed();
	}

	public void clickOnDisplayExamIcon() {

		//actionClass.mouseover(driver, ClickableMousHoverExam);
		boolean ExamButtonelement = ClickableMousHoverExam.isDisplayed();
		System.out.println("ExamButtonelement "+ExamButtonelement);
		
		ClickableMousHoverExam.click();
	}

	// StudentSupport

	public void isDisplayStudentSupportIcon() {

		ClickableMousHoverStudentSupport.isDisplayed();
	}

	public void clickOnDisplayStudentSupportIcon() {

		ClickableMousHoverStudentSupport.click();
	}
	
	
	//NGASCEAlumniPortal
	
	public void isDisplayNGASCEAlumniPortalIcon() {

		ClickableNGASCEAlumniPortal.isDisplayed();
	}
	
	
	public void clickOnDisplayNGASCEAlumniPortalIcon() {


		ClickableNGASCEAlumniPortal.click();
	}
	
	
	
	//MyBadges
	public void isDisplayMyBadgesIcon() {

		ClickableMyBadges.isDisplayed();
	}
	
	
	public void clickOnDisplayMyBadgesIcon() {


		ClickableMyBadges.click();
	}
	
	
	
	//QuickLinks
	public void isDisplayQuickLinksIcon() {

		mouseHoverQuickLinks.isDisplayed();
	}
	
	
	public void clickOnDisplayQuickLinksIcon() {


		mouseHoverQuickLinks.click();
	}
	
	
	
	
	
	
	

}
