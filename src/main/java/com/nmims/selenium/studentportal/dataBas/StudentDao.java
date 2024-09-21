package com.nmims.selenium.studentportal.dataBas;


import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;

public interface StudentDao {
	
	  public StudentStudentPortalBean getsinglStudentdata (String sapid);
	  public StudentStudentPortalBean getstudentLatestRegistration (String sapid);
	  
	   

}
