package com.selenium.studentportal.action;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class ActionHandler {
	
	 static WebDriver driver;
	
	public static boolean isAlertPresent( ) // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			
			return true;
			
		} catch (NoAlertPresentException e) {
			
			return false;
		}
	}


	

	

}
