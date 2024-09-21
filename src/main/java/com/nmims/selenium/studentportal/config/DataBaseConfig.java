package com.nmims.selenium.studentportal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nmims.selenium.studentportal.daoImpl.StudentDaoImpl;
import com.nmims.selenium.studentportal.daoImpl.SubjectDaoImpl;
import com.nmims.selenium.studentportal.dataBas.StudentDao;
import com.nmims.selenium.studentportal.dataBas.StudentSubjectDao;

@Configuration
public class DataBaseConfig {
	
	
	@Autowired
    private DataSource dataSource;
	
	
	@Bean (name =	{ "dataSources" })
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
	
	@Bean (name =	{ "SubjectListDao" })
	public StudentSubjectDao getStudentDao (){
		SubjectDaoImpl ongoingSubjectDaoImpl =	new SubjectDaoImpl();
		ongoingSubjectDaoImpl.setJdbcTemplate (getTemplate ());
		return  ongoingSubjectDaoImpl;

	}
	 
	@Bean (name =	{ "singleStudentData" })
	public StudentDao getStudentDetails (){
		StudentDaoImpl singleStudentDetails =	new StudentDaoImpl();
		singleStudentDetails.setJdbcTemplate (getTemplate ());
		return  singleStudentDetails;

	}
	
	

// Create for NamedParameterJdbcTemplate
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }
	
	
	
	
}

