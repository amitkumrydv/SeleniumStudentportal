package com.nmims.selenium.studentportal.baseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nmims.selenium.studentportal.utilities.ReadConfig;



public class BasClass {
	
	
	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	//public String userName = readConfig.getUsername();
	//public String password = readConfig.getPassword();
	public  WebDriver driver;
	public static Logger logger; 
	
	
	
    @Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("Selenium_studentPortal");
		PropertyConfigurator.configure("Log4j.properties");
		
     if (br.equals("chrome"))
     {
    	 System.setProperty("webdriver.chrome.driver", readConfig.getChrome());
    	 
    	 
    	 // Add arguments to enable the "clear-browser-data" command-line switch
    	 ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-extensions"); // Disable extensions
       
//         options.addArguments("--disable-bundled-ppapi-flash");
//         options.addArguments("--disable-plugins-discovery");
//         options.addArguments("--disable-hang-monitor");
//         options.addArguments("--disable-prompt-on-repost");
//         options.addArguments("--enable-experimental-accessibility");
//         options.addArguments("--test-type");
//         options.addArguments("--disable-infobars");
//         options.addArguments("--disable-dev-shm-usage");
//         options.addArguments("--no-sandbox");
//         options.addArguments("--disable-browser-side-navigation");
//         options.addArguments("--disable-gpu");
//         options.addArguments("--disable-software-rasterizer");
//         options.addArguments("--disable-default-apps");
//         options.addArguments("--disable-extensions");
//         options.addArguments("--disable-popup-blocking");
//         options.addArguments("--disable-translate");
         options.addArguments("--disable-web-security");
         options.addArguments("--ignore-certificate-errors");

         driver = new ChromeDriver(options);
    	 
    	 
    	 
     }
     if (br.equals("firefox"))
     {
    	 System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
    	 driver = new FirefoxDriver();
     }
     
     if (br.equals("ie"))
     {
    	 System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
    	 driver = new InternetExplorerDriver();
     }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	    driver.get(baseURL);
 	                       
 	   driver.manage().window().maximize();
	}

	
	public void captureScreen(WebDriver driver, String tname) throws IOException   {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname +".png" );
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
		
	}
	
	
	public String randomestring()   //Generat rendom email user defne method method
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return (generatedstring)  ;
	}
	
	
	public String randomeNum()   //Generat rendom Number user defne method method
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return (generatedstring2)  ;
	}
	
	
	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
