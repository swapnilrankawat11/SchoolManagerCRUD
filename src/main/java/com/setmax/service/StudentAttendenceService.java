package com.setmax.service;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dao.StudentAttendenceDAO;
import com.setmax.dto.StudentAttendenceDTO;
import com.setmax.dto.StudentAttendenceSearchParamsDTO;
import com.setmax.dto.UserStudentAttendenceDTO;
import com.setmax.dto.UserStudentDTO;
import com.setmax.response.StudentAttendenceResponse;
import com.setmax.util.Constant;
import com.setmax.util.DateUtil;

public class StudentAttendenceService {
	public StudentAttendenceResponse getStudentAttendenceRecordsBySearchParams(
			StudentAttendenceSearchParamsDTO searchParams) {
		StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
		UserService userService = new UserService();
		StudentInfoService studentInfoService = new StudentInfoService();
		StandardService standardService = new StandardService();
		List<UserStudentAttendenceDTO> userStudentAttendenceDTOList = userService
				.getStudentAttendenceRecordsBySearchParams(searchParams);
		for (UserStudentAttendenceDTO student : userStudentAttendenceDTOList) {
			student.setAttendenceByUserFullName(
					userService.getFullName(Integer.parseInt(student.getAttendenceByUserId())));
			student.setStudentName(userService.getFullName(Integer.parseInt(student.getUserId())));
			student.setStandardValue(
					standardService.getStandardDetail(Integer.parseInt(student.getStandardId())).getStandardName());

			student.setFatherName(
					studentInfoService.getStudentDetail(Integer.parseInt(student.getUserId())).getFatherName());
		}
		if (userStudentAttendenceDTOList == null || userStudentAttendenceDTOList.isEmpty()) {
			studentAttendenceResponse.setStatus(false);
		} else {
			studentAttendenceResponse.setStatus(true);
			studentAttendenceResponse.setStudentAttendenceRecords(userStudentAttendenceDTOList);
		}
		return studentAttendenceResponse;
	}

	public StudentAttendenceDTO findStudentAttendenceByUserId(long studentUserId, int standardId,
			java.sql.Date attendenceDate) {
		StudentAttendenceDAO studentAttendenceDAO = new StudentAttendenceDAO();
		return studentAttendenceDAO.getStudentAttendenceRecordByStudentUserId(studentUserId, standardId,
				attendenceDate);
	}

	public StudentAttendenceResponse getStudentAttendenceRecordsByStandardAndDate(String standardId,
			String dateOfAttendence) {
		StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
		UserService userService = new UserService();
		List<UserStudentDTO> userStudentDTOList = userService
				.getAcademicSessionStudentsDataByStandardId(Integer.parseInt(standardId));
		for (UserStudentDTO userStudent : userStudentDTOList) {
			userStudent.setStudentName(userService.getFullName(Integer.parseInt(userStudent.getUserId())));
			userStudent.setAttendenceStatus(findStudentAttendenceByUserId(Integer.parseInt(userStudent.getUserId()),
					Integer.parseInt(standardId), DateUtil.parseToSqlDate(dateOfAttendence)).getAttendenceStatus());
		}
		if (userStudentDTOList == null || userStudentDTOList.isEmpty()) {
			studentAttendenceResponse.setStatus(false);
		} else {
			studentAttendenceResponse.setStatus(true);
			studentAttendenceResponse.setStudentsForAttendence(userStudentDTOList);
		}
		return studentAttendenceResponse;
	}

	public List<StudentAttendenceDTO> getStudentAttendenceRecordsByStandardAndAttendenceDate(int standardId,
			String attendenceDate) {
		StudentAttendenceDAO studentAttendenceDAO = new StudentAttendenceDAO();
		return studentAttendenceDAO.getStudentAttendenceRecordByStandardAndAttendenceDate(standardId,
				DateUtil.parseToSqlDate(DateUtil.parseToDate(attendenceDate)));
	}

	public StudentAttendenceResponse saveStudentAttendence(List<StudentAttendenceDTO> studentAttendenceDTOList) {
		StudentAttendenceDAO studentAttendenceDAO = new StudentAttendenceDAO();
		StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
		if (studentAttendenceDAO.saveStudentAttendence(studentAttendenceDTOList) > 0) {
			studentAttendenceResponse.setStatus(true);
		} else {
			studentAttendenceResponse.setStatus(false);
			List<String> errors = new ArrayList<String>();
			errors.add(Constant.PROCESSING_ERROR);
			studentAttendenceResponse.setErrors(errors);
		}
		return studentAttendenceResponse;
	}

	public StudentAttendenceResponse updateStudentAttendence(List<StudentAttendenceDTO> studentAttendenceDTOList) {
		StudentAttendenceDAO studentAttendenceDAO = new StudentAttendenceDAO();
		StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
		studentAttendenceDAO.updateStudentAttendence(studentAttendenceDTOList);
		studentAttendenceResponse.setStatus(true);
		return studentAttendenceResponse;
	}

}
