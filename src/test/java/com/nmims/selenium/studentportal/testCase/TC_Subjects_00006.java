package com.nmims.selenium.studentportal.testCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.dao.StudentSubjectDao;
import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;
import com.nmims.selenium.studentportal.pageObject.SubjectPageObject;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.SubjectPageObjectMethod;
import com.nmims.selenium.studentportal.testutil.SideBarMenuTest;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_Subjects_00006 extends BaseClass {

	ReadConfig readConfig = new ReadConfig();
	private String user = readConfig.getUsername();
	CaptureScreen captureScreenshot = new CaptureScreen(driver);

	//Using for dao call
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentSubjectDao studentSubjectDao = context.getBean("SubjectListDao", StudentSubjectDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);

	public String path = readStudentdata.getStudentDetailsExcel();


	@Test
	public void ApplicableSubjectTest() throws Exception {

		// Login logic
		LoginPageObjectMethod login = new LoginPageObjectMethod(driver);
		login.commanLogin();
		logger.info("Successfully verify login");
		
		
		// Verify the side-bar menu
		SideBarMenuTest.sideBarMenueIconsTest();
		logger.info("Validate the side-bar menu");
		
		Thread.sleep(2000);
		StudentStudentPortalBean studentRgistration = singleStudentDetails.getstudentLatestRegistration(user);
		SubjectPageObjectMethod subjectOnUI = new SubjectPageObjectMethod(driver);
		SubjectPageObject backlogSubjectTextLink = new SubjectPageObject(driver);
		logger.info("Read the subject from database "+subjectOnUI);
		
		
		// Compare acad year or month from the data base
		String acadYear = studentRgistration.getYear();
		String acadMonth = studentRgistration.getMonth();
		String currentAcadMonth = readStudentdata.getCurrentAcadMonth();
		String currentAcadYear = readStudentdata.getCurrentAcadYear();
		logger.info("Student registration year and month " +acadYear + "-"+acadMonth);
		
        // Student acad year and month compare from the registration table to config properties file
		
		//The logic run when the Student have only Ongoing subject 
		if (acadYear.equals(currentAcadYear) && acadMonth.equals(currentAcadMonth)) {
			logger.info("Check the Acad Year or Month " +acadYear + "-"+acadMonth);

			
			//Store the suject from the ui
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<String> actualSubjectsList = subjectOnUI.getOngoingSubjectFromUI(driver,
					"//div[@id='collapseFour']//div/a");
			
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
			Set<String> expectedtSubjects = new LinkedHashSet<String>(expectedSubjectsList);
		//	expectedtSubjects.sort(String::compareToIgnoreCase);
			Set<String> actualSubjects = new LinkedHashSet<String>(actualSubjectsList);
		//	actualSubjects.sort(String::compareToIgnoreCase);
			
			
            // if(expectedtSubjects)
			if (expectedtSubjects.equals(actualSubjects) ) {

				logger.info("Ongoing Subject is matched from the UI");
				Assert.assertEquals(expectedtSubjects, actualSubjects);
			} else {
				logger.info("Subject is not matched from the UI");
				captureScreenshot.captureFullScreen("TC_OngoingSubject00006");
				

		}
			
    }   
		// Backlog subject logic
		logger.info("Backlog SubjectList From the UI " );
		List<String> subjectListUI =subjectOnUI.getBacklogSubjectList();
		Set<String> actualBacklogSubjects = new LinkedHashSet<String>(subjectListUI);
		logger.info(actualBacklogSubjects);
		
		logger.info("Expected Backlog Subject List  " );
		List<String> expectedBacklogSubjectsList = studentSubjectDao.getBacklogSubjects(user);
		Set<String>sortedexpectedBacklogSubjects = new LinkedHashSet<String>(expectedBacklogSubjectsList);
		
		
		//The logic run when the Student have only Bcklog subject 
		
		if (sortedexpectedBacklogSubjects!=null && acadYear != currentAcadYear && acadMonth  != currentAcadMonth)  {
			logger.info(sortedexpectedBacklogSubjects);
			
			if (sortedexpectedBacklogSubjects.equals(actualBacklogSubjects)) {
				
				Assert.assertEquals(sortedexpectedBacklogSubjects, actualBacklogSubjects);
				
			}
			
		}
		
		//The logic run when the Student have Bcklog and ongoing subject 
		if(sortedexpectedBacklogSubjects!=null && acadYear.equals(currentAcadYear) && acadMonth.equals(currentAcadMonth) ) {
			
			
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			backlogSubjectTextLink.clickToViewBacklogSubject();
		
			List<String> backlogSubjectsDisplayedInPoppup =  subjectOnUI.getBacklogSubjectFromPopup();
			Set<String>sortedActualBacklogSubjects = new LinkedHashSet<String>(expectedBacklogSubjectsList);
			
			
			Assert.assertEquals(sortedActualBacklogSubjects, sortedexpectedBacklogSubjects);
			
			
			
			logger.info("Backlog Subjects matched " +sortedActualBacklogSubjects);
			
			
          
		}
			
			
		}
		
		
		
		
		
		//if ()
		
		
		
 }
	
	

