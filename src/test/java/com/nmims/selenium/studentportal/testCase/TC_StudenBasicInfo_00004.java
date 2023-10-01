package com.nmims.selenium.studentportal.testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.data.StudaentDetail;
import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.UserDtailsPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_StudenBasicInfo_00004 extends BaseClass {
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);

	ReadConfig readStudentdata = new ReadConfig();
	public String path = readStudentdata.getStudentDetailsExcel();

	/*
	 * In this test will test all about basic details of student like Name, Program,
	 * Sapid, EmailID, Phone number and Sem.
	 */

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class )
	public void studentDetailsTest(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");

		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		// don't write above of the method
		UserDtailsPageObjectMethod studentActualNameOnUI = new UserDtailsPageObjectMethod(driver);

		String studentActualName = studentActualNameOnUI.setStudentName();
		logger.info(" Readed student Actual Name ");

		StudentStudentPortalBean actualSingleStudentDetails = singleStudentDetails.getsinglStudentdata(user);
		logger.info("Actual Student Details " +studentActualName);

		String studentFirstName = actualSingleStudentDetails.getFirstName();
		String studentLastName = actualSingleStudentDetails.getLastName();
		String studentFirstLastName = studentFirstName + " " + studentLastName;
		
		// Name required in Alphabet
		String studenNamecapitalAlphabetExpected = studentFirstLastName.toUpperCase();
		logger.info("Expected student Name " + studenNamecapitalAlphabetExpected);

		if (studenNamecapitalAlphabetExpected.equals(studentActualName)) {

			Assert.assertEquals(studenNamecapitalAlphabetExpected, studentActualName);
			logger.info("Student Name is matched");

		} else {

			logger.info("Student Name is not matched from the UI");
			captureScreen(driver, "TC_OngoingSubject00006");
			Assert.fail("Student Name is not matched from the UI");

		}
		
	
		// Verify header data

		StudaentDetail excelReader = new StudaentDetail();
		UserDtailsPageObjectMethod webElementFetcher = new UserDtailsPageObjectMethod(driver);

		List<String> actualTextValues = webElementFetcher.fetchTextValuesFromUI(driver,
				"//ul[contains(@class,'student-info-list')]//li");
		logger.info("Data Displyed on header " + actualTextValues);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<String> expectedOptions = excelReader.studentDetailExcel(path, "Details");
		logger.info("Excel data " + expectedOptions);

		if (expectedOptions.equals(actualTextValues)) {

			logger.info("Student details is matched from the UI");
			Assert.assertEquals(actualTextValues, expectedOptions);
		} else {
			logger.info("Student data is not matched from the Excel");
			captureScreen(driver, "TC_StudenBasicInfo00004");
			Assert.assertEquals(expectedOptions, actualTextValues);
		}

	}

}
