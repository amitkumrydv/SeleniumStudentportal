package com.nmims.selenium.studentportal.testCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.dao.StudentSubjectDao;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.SubjectPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_OngoingSubject_00006 extends BaseClass {

	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentSubjectDao studentSubjectDao = context.getBean("ongoingSubjectDao", StudentSubjectDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);

	public String path = readStudentdata.getStudentDetailsExcel();

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
	public void ongoingSubjectTest(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");
 
		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		SubjectPageObjectMethod actualSebjectOnUI = new SubjectPageObjectMethod();
		List<String> actualSubjectsList = actualSebjectOnUI.getOngoingSubjectFromUI(driver,
				"//a[@class=\" text-dark fw-semibold list-group-item list-group-item-action\"]");

		logger.info("suject visible on the UI" + actualSubjectsList);

		StudentStudentPortalBean studentRgistration = singleStudentDetails.getstudentLatestRegistration (user);
		String consumerProgramStructureId = studentRgistration.getConsumerProgramStructureId();
		String sem =studentRgistration.getSem();
		
		logger.info("Get student sem and consumerProgramStructureId");

		// Static Value pass sem & consumerstructure
		List<String> expectedSubjectsList = studentSubjectDao.getOngoingSubject(sem, consumerProgramStructureId);
		logger.info("applicableCurrentSubject " + expectedSubjectsList);

//		 This approach will work if you want to check whether the lists contain the same unique elements, regardless of their order.
		Set<String> expectedtSubjects = new HashSet<String>(expectedSubjectsList);
		Set<String> actualSubjects = new HashSet<String>(actualSubjectsList);

		if (expectedtSubjects.equals(actualSubjects)) {

			logger.info("Subject is matched from the UI");
			Assert.assertEquals(expectedtSubjects, actualSubjects);
		} else {
			logger.info("Subject is not matched from the UI");
			captureScreen(driver, "TC_OngoingSubject00006");
			Assert.fail("Subject is not matched from the UI");
		}

	}
}
