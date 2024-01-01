package com.nmims.selenium.studentportal.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nmims.selenium.studentportal.baseClass.BaseClass;

public class CaptureScreen extends BaseClass{
	
	//private WebDriver driver;
	
	
	public CaptureScreen(WebDriver driver){
		
		this.driver=driver;
	}
	
	
public void captureFullScreen(String tname) throws IOException   {
	
	if (driver == null) {
        System.err.println("WebDriver is not initialized.");
        return;
    }
	
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname +".png" );
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
		
	}



}
