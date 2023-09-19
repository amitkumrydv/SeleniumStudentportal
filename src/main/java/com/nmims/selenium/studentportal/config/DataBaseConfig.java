package com.nmims.selenium.studentportal.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nmims.selenium.studentportal.dao.OngoingSubjectDao;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.daoImpl.OngoingSubjectDaoImpl;
import com.nmims.selenium.studentportal.daoImpl.StudentDaoImpl;

@Configuration
public class DataBaseConfig {
	
	@Bean (name =	{ "ds" })
	public DataSource getDataSource (){
	DriverManagerDataSource ds =new DriverManagerDataSource();
	ds .setDriverClassName("com.mysql.jdbc.Driver");
	ds .setUrl("jdbc:mysql://localhost:3306/");
	ds .setUsername ("root");
	ds .setPassword ("admin");
	return ds;
	}
	
	@Bean (name =	{ "jdbcTemplate" })
	public JdbcTemplate getTemplate (){
	JdbcTemplate jdbcTemplate =	new JdbcTemplate ();
	jdbcTemplate .setDataSource (getDataSource ());
	return jdbcTemplate;
	}
	
	@Bean (name =	{ "ongoingSubjectDao" })
	public OngoingSubjectDao getStudentDao (){
		OngoingSubjectDaoImpl ongoingSubjectDaoImpl =	new OngoingSubjectDaoImpl();
		ongoingSubjectDaoImpl.setJdbcTemplate (getTemplate ());
		return  ongoingSubjectDaoImpl;

	}
	 
	
}

