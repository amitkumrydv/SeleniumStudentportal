package com.nmims.selenium.studentportal.TakingScreenshortAllPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.pageObject.DashboardPageObject;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

public class TakingScreenShortAllPages  extends BaseClass{
	
	
	private List<String> assignmentList;
	private CaptureScreen captureScreenshot;
	ReadConfig readConfig = new ReadConfig();
	private String user = readConfig.getUsername();

	@Test
	public void prtalScreenshors() throws InterruptedException, IOException {
	LoginPageObjectMethod loginPage = new LoginPageObjectMethod(driver);
	loginPage.commanLogin();
	logger.info("Successful login test ");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	DashboardPageObject  footer = new DashboardPageObject(driver);
	
	int footersize = footer.footerHeight();
	System.out.println("footersize-- " +footersize);
	
	//CaptureScreen.takeScreenshotUpToFooter(driver,"TakingScreenShortAllPages");
	
	 for (int i = 0; i < footersize; i += 320) {
	    	Thread.sleep(1000);
	    	
	    	CaptureScreen.takeScreenshotUpToFooter("TakingScreenShortAllPages"+i);
	    	
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + i + ")");
	     
	            Thread.sleep(4000); // Adjust the delay as needed
	        
	    }
	
	}
	
	
	
	
	
	
	

}