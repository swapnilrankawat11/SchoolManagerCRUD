package com.setmax.service;

import java.util.List;

import com.setmax.dao.StudentDAO;
import com.setmax.dto.StudentDetails;

public class StudentDetailService {
	public int save(StudentDetails student) {
		int status = 0;
		StudentDAO studentDAO = new StudentDAO();
		status = studentDAO.saveData(student);
		return status;
	}

	public List<StudentDetails> showList() {
		StudentDAO studentDAO = new StudentDAO();
		List<StudentDetails> studentDetailList = studentDAO.showListOfStudents();
		return studentDetailList;
	}

	public StudentDetails getStudentData(int serial_no) {
		StudentDAO studentDAO = new StudentDAO();
		StudentDetails student = studentDAO.getStudentDetails(serial_no);
		return student;
	}

	public int delete(int serial_no) {
		int status = 0;
		StudentDAO studentDAO = new StudentDAO();
		status = studentDAO.deleteData(serial_no);
		return status;
	}

	public int update(StudentDetails student) {
		int status = 0;
		StudentDAO dao = new StudentDAO();
		status = dao.updateData(student);
		return status;
	}
}