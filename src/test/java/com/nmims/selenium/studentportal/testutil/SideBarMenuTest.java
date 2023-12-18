package com.nmims.selenium.studentportal.testutil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.dao.StudentSubjectDao;
import com.nmims.selenium.studentportal.pageObject.SiderBarMenuPageObject;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.SiderBarMenuPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class SideBarMenuTest extends BaseClass {

	ReadConfig readConfig = new ReadConfig();
	private String user = readConfig.getUsername();
	CaptureScreen captureScreenshot;

	// Using for dao call
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentSubjectDao studentSubjectDao = context.getBean("ongoingSubjectDao", StudentSubjectDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);

	public String path = readStudentdata.getStudentDetailsExcel();

	
	public static void sideBarMenueIconsTest() throws Exception {

        logger.info("Start to validate side-bar menue");
		SiderBarMenuPageObject sideBarMenu = new SiderBarMenuPageObject(driver);
		sideBarMenu.isVisibleExpandArrow();
		sideBarMenu.isDisplayDashboardIcon();
		sideBarMenu.isDisplayAcadIcon();
		sideBarMenu.isDisplayMycoursesIcon();
		sideBarMenu.isDisplaySesionvideoIcon();
		sideBarMenu.isDisplayBookmarkIcon();
		sideBarMenu.isDisplayExamIcon();
		sideBarMenu.isDisplayStudentSupportIcon();
		sideBarMenu.isDisplayNGASCEAlumniPortalIcon();
		sideBarMenu.isDisplayMyBadgesIcon();
		sideBarMenu.isDisplayQuickLinksIcon();

	}

}
