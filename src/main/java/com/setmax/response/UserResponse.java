package com.setmax.response;

import com.setmax.dto.StudentInfoDTO;
import com.setmax.dto.TeacherInfoDTO;
import com.setmax.dto.UserDTO;

public class UserResponse {
	private boolean status;
	private UserDTO userInfo;
	private StudentInfoDTO studentInfo;
	private TeacherInfoDTO teacherInfo;

	public UserResponse() {
	}

	public UserResponse(UserDTO userInfo, StudentInfoDTO studentInfo, TeacherInfoDTO teacherInfo) {
		this.userInfo = userInfo;
		this.studentInfo = studentInfo;
		this.teacherInfo = teacherInfo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserDTO userInfo) {
		this.userInfo = userInfo;
	}

	public StudentInfoDTO getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfoDTO studentInfo) {
		this.studentInfo = studentInfo;
	}

	public TeacherInfoDTO getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TeacherInfoDTO teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	@Override
	public String toString() {
		return "UserResponse [userInfo=" + userInfo + ", studentInfo=" + studentInfo + ", teacherInfo=" + teacherInfo
				+ "]";
	}

}
