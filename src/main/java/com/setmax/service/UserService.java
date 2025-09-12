package com.setmax.service;

import java.util.List;

import com.setmax.dao.UserDAO;
import com.setmax.dto.StudentAttendenceSearchParamsDTO;
import com.setmax.dto.StudentInfoDTO;
import com.setmax.dto.TeacherInfoDTO;
import com.setmax.dto.UserDTO;
import com.setmax.dto.UserStudentAttendenceDTO;
import com.setmax.dto.UserStudentDTO;
import com.setmax.response.UserFilteredViaUserTypeResponse;
import com.setmax.response.UserInfoResponse;
import com.setmax.response.UserResponse;
import com.setmax.util.Constant;

public class UserService {

	public long saveUserInfo(UserDTO user) throws Exception {
		UserDAO userDAO = new UserDAO();
		return userDAO.saveUserInfo(user);
	}

	public UserFilteredViaUserTypeResponse getUsersName(String guardianTypeID) {
		int guardianTypeId = Integer.parseInt(guardianTypeID);
		UserDAO userDAO = new UserDAO();
		List<UserDTO> usersNameList = userDAO.getUsersName(guardianTypeId);
		for (UserDTO user : usersNameList) {
			user.setFullName(getFullName(user.getFirstName(), user.getMiddleName(), user.getLastName()));
		}
		UserFilteredViaUserTypeResponse userFilteredViaUserTypeResponse = new UserFilteredViaUserTypeResponse(
				usersNameList);
		return userFilteredViaUserTypeResponse;
	}

	public UserResponse getAllEditUserDetails(String userId) {
		UserResponse editUserModalResponse = new UserResponse();
		int id = Integer.parseInt(userId);
		UserDAO userDAO = new UserDAO();
		UserDTO userInfo = userDAO.getUserDetail(id);
		userInfo.setFullName(getFullName(userInfo.getFirstName(), userInfo.getMiddleName(), userInfo.getLastName()));
		if (userInfo == null || userInfo.getId() <= 0) {
			editUserModalResponse.setStatus(false);
		} else {
			editUserModalResponse.setStatus(true);
			editUserModalResponse.setUserInfo(userInfo);
		}
		int userTypeId = userDAO.getUserTypeId(id);

		if (userTypeId == Constant.USR_TYP_STUDENT) {
			StudentInfoService studentInfoService = new StudentInfoService();
			StudentInfoDTO studentInfo = studentInfoService.getStudentDetail(id);
			editUserModalResponse.setStudentInfo(studentInfo);
		} else if (userTypeId == Constant.USR_TYP_TEACHER) {
			TeacherInfoService teacherInfoService = new TeacherInfoService();
			TeacherInfoDTO teacherInfo = teacherInfoService.getTeacherDetail(id);
			editUserModalResponse.setTeacherInfo(teacherInfo);
		}
		return editUserModalResponse;
	}

	public UserInfoResponse saveEditedUserInfo(UserDTO user) throws Exception {
		UserDAO userDAO = new UserDAO();
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		userInfoResponse.setId(user.getId());
		int recordDeleted = userDAO.updateUserInfo(user);
		if (recordDeleted == 1) {
			userInfoResponse.setStatus(true);
		} else {
			userInfoResponse.setStatus(false);
		}
		return userInfoResponse;
	}

	public UserInfoResponse deleteUser(String userId) throws Exception {
		int id = Integer.parseInt(userId);
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		userInfoResponse.setId(id);
		UserDAO userDAO = new UserDAO();
		int recordDeleted = userDAO.deleteUserByUserId(id);
		if (recordDeleted == 1) {
			userInfoResponse.setStatus(true);
		} else {
			userInfoResponse.setStatus(false);
		}
		return userInfoResponse;
	}

	public String getFullName(int userId) {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.findById(userId);
		return getFullName(userDTO.getFirstName(), userDTO.getMiddleName(), userDTO.getLastName());
	}

	public String getFullName(String firstName, String middleName, String lastName) {
		String fullName;
		if (middleName == null || middleName.trim().isEmpty()) {
			middleName = "";
			fullName = firstName + " " + lastName;
		} else {
			fullName = firstName + " " + middleName + " " + lastName;
		}
		return fullName;
	}

	public UserDTO getUserDetailByUserId(int userId) {
		UserDAO userDAO = new UserDAO();
		return userDAO.getUserDetail(userId);
	}

	public List<UserStudentDTO> getAcademicSessionStudentsDataByStandardId(int standardId) {
		UserDAO userDAO = new UserDAO();
		return userDAO.getAcademicSessionStudentsDataByStandardId(standardId);
	}

	public List<UserStudentDTO> getAcademicSessionStudentsDataByStandardIdAndAcademicSessionId(int standardId,
			int academicSessionId) {
		UserDAO userDAO = new UserDAO();
		return userDAO.getAcademicSessionStudentsDataByStandardIdAndAcademicSession(standardId, academicSessionId);
	}

	public List<UserStudentAttendenceDTO> getStudentAttendenceRecordsBySearchParams(
			StudentAttendenceSearchParamsDTO searchParams) {
		UserDAO userDAO = new UserDAO();
		return userDAO.getStudentAttendenceRecordsBySearchParams(searchParams);
	}
}