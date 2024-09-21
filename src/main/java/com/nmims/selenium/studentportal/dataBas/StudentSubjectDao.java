package com.nmims.selenium.studentportal.dataBas;

import java.util.List;


public interface StudentSubjectDao {
	
	public List<String> getOngoingSubject(String sem , String consumerProgramStructureId);

	public List<String> getBacklogSubjects(String sapid);
  
}
