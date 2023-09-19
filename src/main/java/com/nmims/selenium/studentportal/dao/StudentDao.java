package com.nmims.selenium.studentportal.dao;

import java.util.List;

import com.nmims.selenium.studentportal.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	
	public List<Student> read(int studentID);
	
	
	

}
