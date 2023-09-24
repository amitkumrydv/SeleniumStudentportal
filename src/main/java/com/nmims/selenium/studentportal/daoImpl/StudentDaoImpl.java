package com.nmims.selenium.studentportal.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.nmims.selenium.studentportal.dao.StudentDao;
import com.nmims.selenium.studentportal.entities.StudentStudentPortalBean;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public StudentStudentPortalBean getStudentRegistration(String sapid) {
		StudentStudentPortalBean currenrtRgistration = new StudentStudentPortalBean();
		try {
			String sqlquery = "SELECT * FROM exam.students s where"
					+ "   s.sapid = ?  and s.sem = (Select max(sem) from exam.students where sapid =? ) ";

			currenrtRgistration = (StudentStudentPortalBean) jdbcTemplate.queryForObject(sqlquery,
					new Object[] { sapid, sapid }, new BeanPropertyRowMapper(StudentStudentPortalBean.class));
			currenrtRgistration.setProgramForHeader(currenrtRgistration.getProgram());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return currenrtRgistration;
	}

}
