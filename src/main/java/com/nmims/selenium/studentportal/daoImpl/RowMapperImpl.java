package com.nmims.selenium.studentportal.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;



public class RowMapperImpl implements RowMapper<StudentStudentPortalBean> {

	@Override
	public StudentStudentPortalBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


//	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//	
//		Student student = new Student();
//		student.setId(rs.getInt(1));
//		student.setName(rs.getString(2));
//		student.setCity(rs.getString(3));
//		
//		return student;
//	}

}
