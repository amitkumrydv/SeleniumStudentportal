package com.nmims.selenium.studentportal.dao;


import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;

public interface StudentDao {
	
	  public StudentStudentPortalBean getsinglStudentdata (String sapid);
	  public StudentStudentPortalBean getstudentLatestRegistration (String sapid);
	  
	   

}
