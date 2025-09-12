package com.setmax.dto;

public class StudentAttendenceDTO {
	private int id;
	private String studentUserId;
	private String attendenceStatus;
	private String standardId;
	private String attendenceDate;
	private String attendenceByUserId;

	public StudentAttendenceDTO() {
	}

	public StudentAttendenceDTO(int id, String studentUserId, String attendenceStatus, String standardId,
			String attendenceDate, String attendenceByUserId) {
		this.id = id;
		this.studentUserId = studentUserId;
		this.attendenceStatus = attendenceStatus;
		this.standardId = standardId;
		this.attendenceDate = attendenceDate;
		this.attendenceByUserId = attendenceByUserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getAttendenceStatus() {
		return attendenceStatus;
	}

	public void setAttendenceStatus(String attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
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

	@Override
	public String toString() {
		return "StudentAttendenceDTO [id=" + id + ", studentUserId=" + studentUserId + ", attendenceStatus="
				+ attendenceStatus + ", standardId=" + standardId + ", attendenceDate=" + attendenceDate
				+ ", attendenceByUserId=" + attendenceByUserId + "]";
	}

}
