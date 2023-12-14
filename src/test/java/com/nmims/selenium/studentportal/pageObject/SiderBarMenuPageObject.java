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
	
	public SiderBarMenuPageObject (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
  @FindBy (xpath="//li[@id='toggle-nav']//a")
  public WebElement expandMenueArrow;
  
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href='/authenticate/home']")
  public WebElement clickableDashboard;
  
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href='/acads/student/viewStudentTimeTable']")
  public WebElement clickableAcad;
	
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/viewCourseHomePage']")
  public WebElement clickableMycourses;
  
  
  // This is dynamic xpath becouse of change month and year
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href=\"/acads/student/videosHome?pageNo=1&academicCycle=Jul2023\"]")
  public WebElement clickableSesionvideo;
  
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/bookmarks']")
  public WebElement clickableBookmark;
  
  
  @FindBy (xpath="//a[@href=\"/exam/student/getMostRecentResults\"]/p[text()='Exam']")
  public WebElement ClickableMousHoverExam;
  
 
  @FindBy (xpath="//a[@href=\"/studentportal/student/connectWithUs\"]/p[text()='Student Support']")
  public WebElement ClickableMousHoverStudentSupport;
  
  
  
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href=\"/almashines/student/welcomeToAlmashines\"]")
  public WebElement ClickableNGASCEAlumniPortal;
  
  
  
  
  @FindBy (xpath="//li[@id=\"ListwithToltip\"]//a[@href='/studentportal/student/myBadges']")
  public WebElement ClickableMyBadges;
  
  
  
  @FindBy (xpath="//a[@href=\"#\"]/p[text()='Quick Links']")
  public WebElement mouseHoverQuickLinks;
  
  
  
  
  
  public void clickOnDisplayExamIcon() {
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/exam/student/getMostRecentResults\"]")));
	  
	  boolean ExamButtonelement = element.isDisplayed();
	  System.out.println("ExamButtonelement "+ExamButtonelement);
	  element.click();

//		//actionClass.mouseover(driver, ClickableMousHoverExam);
//		boolean ExamButtonelement = ClickableMousHoverExam.isDisplayed();
//		System.out.println("ExamButtonelement "+ExamButtonelement);
//		
//		ClickableMousHoverExam.click();
	}
  
//To check the Dashboard top arrow
	public boolean isVisibleExpandArrow() {

		boolean isDisplayManueArrow = expandMenueArrow.isDisplayed();
		System.out.println("isDisplayManueArrow "+isDisplayManueArrow);
		return isDisplayManueArrow;

	}

	// Dashboard
	public void isDisplayDashboardIcon() {

		boolean isDisplayDashboardIcon= clickableDashboard.isDisplayed();
		System.out.println("isDisplayDashboardIcon "+isDisplayDashboardIcon);
	}

	public void clickOnDisplayDashboardIcon() {

		clickableDashboard.click();
	}

	// Acads

	public void isDisplayAcadIcon() {

		boolean isDisplayAcadIcon=clickableAcad.isDisplayed();
		System.out.println("isDisplayAcadIcon "+isDisplayAcadIcon);
	}

	public void clickOnDisplayAcadIcon() {

		clickableAcad.click();
	}

	// My Courses
	public void isDisplayMycoursesIcon() {

		boolean isDisplayMycoursesIcon=clickableMycourses.isDisplayed();
		
		System.out.println("isDisplayMycoursesIcon "+isDisplayMycoursesIcon);
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


	// StudentSupport

	public void isDisplayStudentSupportIcon() {

		//actionClass.mouseover(driver, ClickableMousHoverExam);
				boolean isDisplayStudentSupportIcon = ClickableMousHoverStudentSupport.isDisplayed();
				System.out.println("isDisplayStudentSupportIcon "+isDisplayStudentSupportIcon);
				
			     ClickableMousHoverExam.click();
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
