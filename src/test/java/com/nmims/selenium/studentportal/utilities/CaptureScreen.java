package com.nmims.selenium.studentportal.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nmims.selenium.studentportal.baseClass.BaseClass;

public class CaptureScreen extends BaseClass {
	
public void captureFullScreen(WebDriver driver, String tname) throws IOException   {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname +".png" );
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
		
	}

}
