package com.setmax.service;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dao.StudentAcademicSessionDAO;
import com.setmax.dto.StudentAcademicSessionDTO;
import com.setmax.dto.UserStudentDTO;
import com.setmax.response.AcademicSessionResponse;
import com.setmax.response.AcademicSessionStudentsResponse;

public class StudentAcademicSessionService {
	public AcademicSessionStudentsResponse getAcademicSessionStudents(int standardId, int academicSessionId) {
		AcademicSessionService academicSessionService = new AcademicSessionService();
		AcademicSessionStudentsResponse academicSessionStudentsResponse = new AcademicSessionStudentsResponse();
		UserService userService = new UserService();
		if (academicSessionId == academicSessionService.getCurrentAcademicSession().getId()) {
			List<UserStudentDTO> userStudentDTOList = userService
					.getAcademicSessionStudentsDataByStandardId(standardId);

			for (UserStudentDTO userStudent : userStudentDTOList) {
				userStudent.setStudentName(userService.getFullName(Integer.parseInt(userStudent.getUserId())));

				userStudent.setStudentAcademicSessionId(
						findByUserAndAcademicSessionId(Integer.parseInt(userStudent.getUserId()), academicSessionId));

			}
			if (userStudentDTOList == null || userStudentDTOList.isEmpty()) {
				academicSessionStudentsResponse.setStatus(false);
			} else {
				academicSessionStudentsResponse.setStatus(true);
				academicSessionStudentsResponse.setStudents(userStudentDTOList);
			}
		} else {
			List<UserStudentDTO> userStudentDTOList = userService
					.getAcademicSessionStudentsDataByStandardIdAndAcademicSessionId(standardId, academicSessionId);
			userStudentDTOList.stream().forEach((userStudent) -> userStudent
					.setStudentName(userService.getFullName(Integer.parseInt(userStudent.getUserId()))));
			if (userStudentDTOList == null || userStudentDTOList.isEmpty()) {
				academicSessionStudentsResponse.setStatus(false);
			} else {
				academicSessionStudentsResponse.setStatus(true);
				academicSessionStudentsResponse.setStudents(userStudentDTOList);
			}
		}

		return academicSessionStudentsResponse;
	}

	public String findByUserAndAcademicSessionId(int userId, int academicSessionId) {
		StudentAcademicSessionDAO studentAcademicSessionStudentsDAO = new StudentAcademicSessionDAO();
		String academicSessionTextId = (studentAcademicSessionStudentsDAO
				.findByUserIdAndAcademicSessionId(userId, academicSessionId).getStudentAcademicSessionId());
		if (academicSessionTextId == null || academicSessionTextId.trim().isEmpty()
				|| Integer.parseInt(academicSessionTextId) <= 0) {
			return "0";
		} else {
			return academicSessionTextId;
		}

	}

	public AcademicSessionResponse saveStudentAcademicSession(String[] userIdArray, int loggedInUserId)
			throws Exception {
		StudentAcademicSessionDAO studentAcademicSessionDAO = new StudentAcademicSessionDAO();
		List<StudentAcademicSessionDTO> studentAcademicSessionDTOList = new ArrayList<StudentAcademicSessionDTO>();
		AcademicSessionResponse academicSessionResponse = new AcademicSessionResponse();
		AcademicSessionService academicSessionService = new AcademicSessionService();
		for (String userId : userIdArray) {
			String userID = studentAcademicSessionDAO.findByUserIdAndAcademicSessionId(Long.parseLong(userId),
					academicSessionService.getCurrentAcademicSession().getId()).getUserId();
			if (userID != null) {
				if (Long.parseLong(userID) == Long.parseLong(userId)) {
					continue;
				}
			} else {
				StudentAcademicSessionDTO studentAcademicSessionDTO = new StudentAcademicSessionDTO();
				studentAcademicSessionDTO.setUserId(userId);
				StudentInfoService studentInfoService = new StudentInfoService();
				studentAcademicSessionDTO
						.setStandardId(studentInfoService.getStudentDetail(Integer.parseInt(userId)).getStandardId());
				studentAcademicSessionDTOList.add(studentAcademicSessionDTO);
			}
		}

		int recordSaved = studentAcademicSessionDAO.saveStudentAcademicSession(studentAcademicSessionDTOList,
				Long.valueOf(loggedInUserId), academicSessionService.getCurrentAcademicSession().getId());
		int recordDeleted = studentAcademicSessionDAO.deleteStudentAcademicSession(parseToIntArray(userIdArray),
				Long.valueOf(loggedInUserId), academicSessionService.getCurrentAcademicSession().getId());
		if ((studentAcademicSessionDTOList == null || studentAcademicSessionDTOList.isEmpty()) && recordDeleted < 1) {
			List<String> errors = new ArrayList<String>();
			final String error = "All records are already saved! Please check, uncheck the records to save or delete!";
			errors.add(error);
			academicSessionResponse.setStatus(false);
			academicSessionResponse.setErrors(errors);
		} else {
			if (recordSaved == 1 || recordDeleted > 0) {
				academicSessionResponse.setStatus(true);
			} else {
				academicSessionResponse.setStatus(false);
			}
		}
		return academicSessionResponse;
	}

	public int[] parseToIntArray(String[] array) {
		int[] integerArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			integerArray[i] = Integer.parseInt(array[i]);
		}
		return integerArray;
	}
}