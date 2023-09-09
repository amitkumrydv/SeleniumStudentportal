package com.nmims.selenium.studentportal.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StudaentDetail {

	 

	public StudaentDetail(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	
}
