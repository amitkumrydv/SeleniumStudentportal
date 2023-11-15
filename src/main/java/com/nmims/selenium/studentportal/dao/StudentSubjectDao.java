package com.nmims.selenium.studentportal.dao;

import java.util.List;


public interface StudentSubjectDao {
	
	public List<String> getOngoingSubject(String sem , String consumerProgramStructureId);

	public List<String> getBacklogSubjects(String sapid);
  
}
