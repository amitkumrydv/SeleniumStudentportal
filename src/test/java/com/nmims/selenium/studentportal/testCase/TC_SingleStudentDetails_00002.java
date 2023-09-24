package com.nmims.selenium.studentportal.testCase;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.config.DataBaseConfig;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pageObjectMethod.UserDtailsPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

import junit.framework.Assert;

public class TC_SingleStudentDetails_00002 extends BaseClass {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);
	StudentDao singleStudentDetails = context.getBean("singleStudentData", StudentDao.class);
	ReadConfig readStudentdata = new ReadConfig();
	

	public String path = readStudentdata.getStudentDetailsExcel();

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
	public void singleStudentAllData(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");

		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
//		UserDtailsPageObjectMethod studentActualNameOnUI = new UserDtailsPageObjectMethod(driver);  // don't write above of the method
//		
//		String studentActualName= studentActualNameOnUI.setStudentName();
//		logger.info(" Readed student Actual Name " +studentActualName);
//	
//	
//		StudentStudentPortalBean actualSingleStudentDetails = singleStudentDetails.getStudentRegistration(user);
//		logger.info("ActualsingleStudentDetails" + actualSingleStudentDetails);
//		
//		String studentFirstName = actualSingleStudentDetails.getFirstName();
//		String studentLastName = actualSingleStudentDetails.getLastName();
//		String studentExpectedFirstLastName =studentFirstName +" "+ studentLastName;
//	   // Name required in Alphabet
//		String studenNamecapitalAlphabetExpected = studentExpectedFirstLastName.toUpperCase();
//		System.out.println(studenNamecapitalAlphabetExpected);
//
//		System.out.println( "studentExpectedName " +studenNamecapitalAlphabetExpected);
//		
//		if (studenNamecapitalAlphabetExpected.equals(studentActualName)){
//			
//			Assert.assertEquals(studenNamecapitalAlphabetExpected, studentActualName);
//			logger.info("Student Name is matched");
//			
//		} else {
//			
//			logger.info("Student Name is not matched from the UI");
//			captureScreen(driver, "TC_OngoingSubject00006");
//			Assert.fail("Student Name is not matched from the UI");
//
//			
//		}
		
	
	}

}
