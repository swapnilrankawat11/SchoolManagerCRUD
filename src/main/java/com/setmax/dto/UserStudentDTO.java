package com.setmax.dto;

public class UserStudentDTO {
	private String userId;
	private String studentId;
	private String studentName;
	private String fatherName;
	private String studentAcademicSessionId;
	private String attendenceStatus;

	public UserStudentDTO() {
	}

	public UserStudentDTO(String userId, String studentId, String studentName, String fatherName,
			String studentAcademicSessionId) {
		this.userId = userId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.studentAcademicSessionId = studentAcademicSessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStudentAcademicSessionId() {
		return studentAcademicSessionId;
	}

	public void setStudentAcademicSessionId(String studentAcademicSessionId) {
		this.studentAcademicSessionId = studentAcademicSessionId;
	}

	public String getAttendenceStatus() {
		return attendenceStatus;
	}

	public void setAttendenceStatus(String attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}

	@Override
	public String toString() {
		return "UserStudentDTO [userId=" + userId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", fatherName=" + fatherName + ", studentAcademicSessionId=" + studentAcademicSessionId
				+ ", attendenceStatus=" + attendenceStatus + "]";
	}

}
