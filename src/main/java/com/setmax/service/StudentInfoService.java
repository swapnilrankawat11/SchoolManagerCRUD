package com.setmax.service;

import com.setmax.dao.StudentInfoDAO;
import com.setmax.dto.StudentInfoDTO;
import com.setmax.response.StudentInfoResponse;

public class StudentInfoService {
	public long saveStudentInfo(StudentInfoDTO student) throws Exception {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		long id = studentInfoDAO.saveStudentInfo(student);
		return id;
	}

	public StudentInfoResponse updateStudentInfo(StudentInfoDTO student) throws Exception {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
		studentInfoResponse.setId(student.getId());
		int recordDeleted = studentInfoDAO.updateStudentInfo(student);
		if (recordDeleted == 1) {
			studentInfoResponse.setStatus(true);
		} else {
			studentInfoResponse.setStatus(false);
		}
		return studentInfoResponse;
	}

	public StudentInfoDTO getStudentDetail(int userId) {
		StudentInfoDAO studentInfoDAO = new StudentInfoDAO();
		StandardService standardService = new StandardService();
		StudentInfoDTO studentInfoDTO = studentInfoDAO.findByUserId(userId);
		studentInfoDTO.setStandardValue(
				standardService.getStandardDetail(Integer.parseInt(studentInfoDTO.getStandardId())).getStandardName());
		return studentInfoDTO;
	}

}
