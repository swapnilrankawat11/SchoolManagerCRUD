package com.setmax.dto;

public class UserStudentAttendenceDTO {
	private int studentAttendenceRecordId;
	private String userId;
	private String studentId;
	private String studentName;
	private String fatherName;
	private String standardId;
	private String standardValue;
	private String attendenceStatus;
	private String attendenceDate;
	private String attendenceByUserId;
	private String attendenceByUserFullName;

	public UserStudentAttendenceDTO() {
	}

	public int getStudentAttendenceRecordId() {
		return studentAttendenceRecordId;
	}

	public void setStudentAttendenceRecordId(int studentAttendenceRecordId) {
		this.studentAttendenceRecordId = studentAttendenceRecordId;
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

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getStandardValue() {
		return standardValue;
	}

	public void setStandardValue(String standardValue) {
		this.standardValue = standardValue;
	}

	public String getAttendenceStatus() {
		return attendenceStatus;
	}

	public void setAttendenceStatus(String attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}

	public String getAttendenceDate() {
		return attendenceDate;
	}

	public void setAttendenceDate(String attendenceDate) {
		this.attendenceDate = attendenceDate;
	}

	public String getAttendenceByUserId() {
		return attendenceByUserId;
	}

	public void setAttendenceByUserId(String attendenceByUserId) {
		this.attendenceByUserId = attendenceByUserId;
	}

	public String getAttendenceByUserFullName() {
		return attendenceByUserFullName;
	}

	public void setAttendenceByUserFullName(String attendenceByUserFullName) {
		this.attendenceByUserFullName = attendenceByUserFullName;
	}

	@Override
	public String toString() {
		return "UserStudentAttendenceDTO [studentAttendenceRecordId=" + studentAttendenceRecordId + ", userId=" + userId
				+ ", studentId=" + studentId + ", studentName=" + studentName + ", fatherName=" + fatherName
				+ ", standardId=" + standardId + ", standardValue=" + standardValue + ", attendenceStatus="
				+ attendenceStatus + ", attendenceDate=" + attendenceDate + ", attendenceByUserId=" + attendenceByUserId
				+ ", attendenceByUserFullName=" + attendenceByUserFullName + "]";
	}

}
