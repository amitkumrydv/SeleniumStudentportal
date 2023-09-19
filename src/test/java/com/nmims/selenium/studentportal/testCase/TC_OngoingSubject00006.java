package com.nmims.selenium.studentportal.testCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BasClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.OngoingSubjectDao;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pom.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pom.OngoingSubjectPom;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_OngoingSubject00006 extends BasClass {

	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	OngoingSubjectDao ongoingSubjectDao = context.getBean("ongoingSubjectDao", OngoingSubjectDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	OngoingSubjectPom actualSebjectOnUI = new OngoingSubjectPom();

	public String path = readStudentdata.getStudentDetailsExcel();

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
	public void ongoingSubject(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");

		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<String> actualSubjectsList = actualSebjectOnUI.getOngoingSubjectFromUI(driver,
				"//a[@class=\" text-dark fw-semibold list-group-item list-group-item-action\"]");
		
		logger.info("suject visible on the UI" + actualSubjectsList);

		// Static Value pass sem & consumerstructure
		List<String> expectedSubjectsList = ongoingSubjectDao.getOngoingSubject("4", "65");
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
			Assert.fail("Subject is not matched from the UI");;
		}

	}
}
