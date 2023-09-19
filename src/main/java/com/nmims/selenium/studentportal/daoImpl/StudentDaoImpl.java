package com.nmims.selenium.studentportal.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.entities.Student;

public class StudentDaoImpl  implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		
		String query ="insert into studentData.student(id,name,city) values(?,?,?)";
		int r =this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
		
	}
	
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





	public List<Student> read(int studentID) {
		List<Student> student = new ArrayList<Student>();
		String query="Select * from studentData.student where id=?";
		//int r =this.jdbcTemplate.update(query,studentID.getId());
		
		RowMapper<Student> rowMapper =new RowMapperImpl();
		student = jdbcTemplate.query(query, new Object[]{studentID}, rowMapper);
		
		
		return student;
	}




	
	
	

}
