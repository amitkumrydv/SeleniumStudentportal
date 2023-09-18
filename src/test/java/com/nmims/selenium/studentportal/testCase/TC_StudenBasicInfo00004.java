package com.nmims.selenium.studentportal.testCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BasClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.data.StudaentDetail;
import com.nmims.selenium.studentportal.pom.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.pom.UserDtailsPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TC_StudenBasicInfo00004 extends BasClass {

	ReadConfig readStudentdata = new ReadConfig();
	public String path = readStudentdata.getStudentDetailsExcel();

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
	public void studentDetailsTest(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");

		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		StudaentDetail excelReader = new StudaentDetail();
		UserDtailsPageObjectMethod webElementFetcher = new UserDtailsPageObjectMethod();

		
		List<String> actualTextValues = webElementFetcher.fetchTextValuesFromUI(driver,"//ul[contains(@class,'student-info-list')]//li");
		logger.info("Header Xpath pass " + actualTextValues);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<String> expectedOptions = excelReader.studentDetailExcel(path, "Details");
		logger.info(expectedOptions);
		
		
		
		
		if (expectedOptions.equals(actualTextValues)) {
			
			logger.info("Excel Data matched from the UI");
			Assert.assertEquals(actualTextValues, expectedOptions);
		} else {
			logger.info("Student data is not matched from the Excel");
			captureScreen(driver, "loginTest");
			Assert.assertEquals(expectedOptions, actualTextValues);
		}

	}

}
