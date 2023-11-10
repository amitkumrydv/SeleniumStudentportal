package com.nmims.selenium.studentportal.testCase;

import java.util.ArrayList;
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
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_Subjects_00006 extends BaseClass {

	ReadConfig readConfig = new ReadConfig();
	private String user = readConfig.getUsername();
	CaptureScreen captureScreenshot;

	//Using for dao call
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentSubjectDao studentSubjectDao = context.getBean("ongoingSubjectDao", StudentSubjectDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);

	public String path = readStudentdata.getStudentDetailsExcel();

	@Test
	public void ongoingSubjectTest() throws Exception {

		// Login logic
		LoginPageObjectMethod login = new LoginPageObjectMethod(driver);
		login.commanLogin();
		logger.info("Successfully verify login");
		
		
		Thread.sleep(2000);
		StudentStudentPortalBean studentRgistration = singleStudentDetails.getstudentLatestRegistration(user);
		SubjectPageObjectMethod actualSebjectOnUI = new SubjectPageObjectMethod(driver);
		logger.info("Read the subject from database "+actualSebjectOnUI);
		
		
		// Compare acad year or month from the data base
		String acadYear = studentRgistration.getYear();
		String acadMonth = studentRgistration.getMonth();
		String currentAcadMonth = readStudentdata.getCurrentAcadMonth();
		String currentAcadYear = readStudentdata.getCurrentAcadYear();
		logger.info("Student registration year and month " +acadYear + "-"+acadMonth);
		
        // Student acad year and month compare from the registration table to config properties file
		if (acadYear.equals(currentAcadYear) && acadMonth.equals(currentAcadMonth)) {
			logger.info("Check the Acad Year or Month " +acadYear + "-"+acadMonth);

			
			//Store the suject from the ui
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<String> actualSubjectsList = actualSebjectOnUI.getOngoingSubjectFromUI(driver,
					"//a[@class=\" text-dark list-group-item list-group-item-action\"]");
			
			//a[@class=" text-dark list-group-item list-group-item-action"]
			//a[@class=\" text-dark fw-semibold list-group-item list-group-item-action\

			logger.info("suject visible on the UI" + actualSubjectsList);

			String consumerProgramStructureId = studentRgistration.getConsumerProgramStructureId();
			String sem = studentRgistration.getSem();

			logger.info("Get student sem and consumerProgramStructureId");

			//pass Value for sem & consumerstructure
			List<String> expectedSubjectsList = studentSubjectDao.getOngoingSubject(sem, consumerProgramStructureId);
			logger.info("applicableCurrentSubject " + expectedSubjectsList);

//		 This approach will work for store unique in order subject .
			List<String> expectedtSubjects = new ArrayList<String>(expectedSubjectsList);
			expectedtSubjects.sort(String::compareToIgnoreCase);
			List<String> actualSubjects = new ArrayList<String>(actualSubjectsList);
			actualSubjects.sort(String::compareToIgnoreCase);
			
			logger.info("expected---> "+ expectedtSubjects + "  "+"actualSubjects---> "+actualSubjects);
			
			
            // if(expectedtSubjects)
			if (expectedtSubjects.equals(actualSubjects) ) {

				logger.info("Subject is matched from the UI");
				Assert.assertEquals(expectedtSubjects, actualSubjects);
			} else {
				logger.info("Subject is not matched from the UI");
				captureScreenshot.captureFullScreen(driver, "TC_OngoingSubject00006");
				

		}
		

		}
	}
}
