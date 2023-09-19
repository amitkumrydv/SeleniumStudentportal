package com.nmims.selenium.studentportal.dao;

import java.util.List;


public interface OngoingSubjectDao {
	
	public List<String> getOngoingSubject(String sem , String consumerProgramStructureId);

}
