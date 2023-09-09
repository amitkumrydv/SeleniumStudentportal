package com.nmims.selenium.studentportal.testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BasClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;

public class TC_StudenBasicInfo00004 extends BasClass {

	@Test(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
	public void studentDetailsTest(String user, String pwd) throws Exception {

		LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);

		loginPage.setUserName(user);
		logger.info("Entered the UserId");

		loginPage.setPassword(pwd);
		logger.info("Entered the password");

		loginPage.clickSubmit();
		logger.info("Click on the login button ");

		
         // get student details from the UI
		 List<WebElement> countData =
		 driver.findElements(By.xpath("//ul[contains(@class,'student-info-list')]//li"));
		 int countDataSize = countData.size();
		 logger.info("Count displayed " + countDataSize);

		for (int i = 1; i <= countDataSize; i++) {
			String studentInfo = "//ul[contains(@class,'student-info-list')]//li[" + i + "]";

			WebElement item = driver.findElement(By.xpath(studentInfo));
			String studentInfoList = item.getText();
			logger.info("Data displayed " + studentInfoList);
			
			item.click();

		}

	}

}
