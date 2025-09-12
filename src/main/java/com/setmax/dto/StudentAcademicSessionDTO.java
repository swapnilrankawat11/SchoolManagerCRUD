package com.setmax.dto;

public class StudentAcademicSessionDTO {
	private int id;
	private String userId;
	private String standardId;
	private String studentAcademicSessionId;

	public StudentAcademicSessionDTO() {

	}

	public StudentAcademicSessionDTO(String userId, String studentAcademicSessionId) {
		this.userId = userId;
		this.studentAcademicSessionId = studentAcademicSessionId;
	}

	public String getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentAcademicSessionId() {
		return studentAcademicSessionId;
	}

	public void setStudentAcademicSessionId(String studentAcademicSessionId) {
		this.studentAcademicSessionId = studentAcademicSessionId;
	}

	@Override
	public String toString() {
		return "StudentAcademicSessionDTO [id=" + id + ", userId=" + userId + ", standardId=" + standardId
				+ ", studentAcademicSessionId=" + studentAcademicSessionId + "]";
	}

}