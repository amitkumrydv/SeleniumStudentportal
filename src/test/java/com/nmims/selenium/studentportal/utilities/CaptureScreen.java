package com.nmims.selenium.studentportal.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nmims.selenium.studentportal.baseClass.BaseClass;


	
	
	public class CaptureScreen extends BaseClass{
		
		//private WebDriver driver;
		
		
		public CaptureScreen(WebDriver driver){
			
			this.driver=driver;
		}
	
	
	

	public void captureFullScreen(String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);

		System.out.println("Screenshot taken");

	}

	public static void takeScreenshotUpToFooter(String tname) {
		try {
			
			
			
			

			// Take a screenshot of the entire page
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Read the screenshot as BufferedImage
			BufferedImage fullImg = ImageIO.read(screenshot);

			// Crop the screenshot up to the footer
//			BufferedImage footerScreenshot = fullImg.getSubimage(0, 0, fullImg.getWidth(),
//					fullImg.getHeight() - footerHeight);
			
			
			// Combine the two images
            BufferedImage combinedImg = new BufferedImage(fullImg.getWidth(), fullImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
            combinedImg.createGraphics().drawImage(fullImg, 0, 0, null);
           // combinedImg.createGraphics().drawImage(fullImg, 0, scrollHeight, null);
			
            // Take the screenshot with timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(new Date());
			
            System.out.println("timestamp--> "+timestamp);

			// Save the cropped screenshot
			String filePath = System.getProperty("user.dir") + "/AllScreenshots/"+timestamp+" " + tname + ".png";
			ImageIO.write(combinedImg, "png", new File(filePath));

			System.out.println("Screenshot saved successfully at: " + filePath);
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}

	

}