package com.nmims.selenium.studentportal.testCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.pageObject.LoginPageObject;
import com.nmims.selenium.studentportal.testutil.SideBarMenuTest;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_SingleStudentDetails_00002 extends BaseClass {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	

	public String path = readStudentdata.getStudentDetailsExcel();

	@Test
	public void singleStudentAllData(String user, String pwd) throws Exception {
		LoginPageObject loginPage = new LoginPageObject(driver);
		loginPage.commanLogin();
		logger.info("Successful login test ");
		
		SideBarMenuTest.sideBarMenueIconsTest();
		logger.info("Validate the side-bar menu");

	}
}
