package com.nmims.selenium.studentportal.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nmims.selenium.studentportal.dataBas.StudentSubjectDao;

public class SubjectDaoImpl implements StudentSubjectDao {
	
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

	@Override
	public List<String> getBacklogSubjects(String sapid) {
		List<String> backlogSubject = new ArrayList<String>();
		
		String query= "select p.subject from exam.passfail p \r\n"
				+ "inner join \r\n"
				+ "exam.students s on s.sapid = p.sapid \r\n"
				+ "inner join\r\n"
				+ " exam.program_sem_subject p_s_s on p_s_s.consumerProgramStructureId = s.consumerProgramStructureId and p_s_s.subject = p.subject and p_s_s.sem = p.sem where p.isPass = 'N' and p.sapid = ? order by p.sem  asc;";
		
		backlogSubject = jdbcTemplate.queryForList(query, new Object[]{sapid}, String.class );
		
		return backlogSubject;
	}



}
