package com.nmims.selenium.studentportal.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.nmims.selenium.studentportal.dao.OngoingSubjectDao;

public class OngoingSubjectDaoImpl implements OngoingSubjectDao {
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public List<String> getOngoingSubject(String sem, String consumerProgramStructureId) {
		List<String> currentSubjectList = new ArrayList<String>();
		
		String query="Select subject from exam.program_sem_subject where sem=? and consumerProgramStructureId =?";
		
		currentSubjectList = jdbcTemplate.queryForList(query, new Object[]{sem, consumerProgramStructureId}, String.class );
		
		return currentSubjectList;
	}


}
