package com.nmims.selenium.studentportal.baseClass;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.utilities.CaptureScreen;
import com.nmims.selenium.studentportal.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static ReadConfig readConfig = new ReadConfig();

	public static String baseURL = readConfig.getApplicationURL();
	// public String userName = readConfig.getUsername();
	// public String password = readConfig.getPassword();
	static String br = "chrome";
	public static WebDriver driver;
	public static Logger logger;
	CaptureScreen captureScreenshot;

	@Parameters("browser")
	@BeforeClass
	public static void setup() {

		logger = Logger.getLogger("Selenium_studentPortal");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver", readConfig.getChrome());

			WebDriverManager.chromedriver().setup();
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
		if (br.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		if (br.equals("ie")) {
			// System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		if (br.equals("edg")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		
		// Capture cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		logger.info("Size of the cookies : " + cookies.size());

		// How to print the cookies from the browser
		for (Cookie cookie : cookies) {

			logger.info("Cookie Name  " + cookie.getName() + " Cookie Value  " + cookie.getValue());
		}

		driver.manage().window().maximize();
		//return driver;
	}

	public String randomestring() // Generat rendom email user defne method method
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public String randomeNum() // Generat rendom Number user defne method method
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}

	

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
