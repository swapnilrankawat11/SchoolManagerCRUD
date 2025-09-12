package com.setmax.dto;

public class TeacherInfoDTO {
	private String teacherUserId;
	private String primarySubjectId;
	private String primarySubjectValue;
	private String secondarySubjectId;
	private String secondarySubjectValue;
	private String experienceInYear;
	private String experienceInMonth;
	private int id;

	public TeacherInfoDTO() {
	}

	public TeacherInfoDTO(String primarySubject, String secondarySubject, String experienceInYear,
			String experienceInMonth) {
		this.primarySubjectId = primarySubject;
		this.secondarySubjectId = secondarySubject;
		this.experienceInYear = experienceInYear;
		this.experienceInMonth = experienceInMonth;
	}

	public String getTeacherUserId() {
		return teacherUserId;
	}

	public void setTeacherUserId(String teacherUserId) {
		this.teacherUserId = teacherUserId;
	}

	public String getPrimarySubjectValue() {
		return primarySubjectValue;
	}

	public void setPrimarySubjectValue(String primarySubjectValue) {
		this.primarySubjectValue = primarySubjectValue;
	}

	public void setSecondarySubjectValue(String secondarySubjectValue) {
		this.secondarySubjectValue = secondarySubjectValue;
	}

	public String getPrimarySubjectId() {
		return primarySubjectId;
	}

	public void setPrimarySubjectId(String primarySubjectId) {
		this.primarySubjectId = primarySubjectId;
	}

	public String getSecondarySubjectId() {
		return secondarySubjectId;
	}

	public void setSecondarySubjectId(String secondarySubjectId) {
		this.secondarySubjectId = secondarySubjectId;
	}

	public String getSecondarySubjectValue() {
		return secondarySubjectValue;
	}

	public String getExperienceInYear() {
		return experienceInYear;
	}

	public void setExperienceInYear(String experienceInYear) {
		this.experienceInYear = experienceInYear;
	}

	public String getExperienceInMonth() {
		return experienceInMonth;
	}

	public void setExperienceInMonth(String experienceInMonth) {
		this.experienceInMonth = experienceInMonth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TeacherInfoDTO [teacherUserId=" + teacherUserId + ", primarySubjectId=" + primarySubjectId
				+ ", primarySubjectValue=" + primarySubjectValue + ", secondarySubjectId=" + secondarySubjectId
				+ ", secondarySubjectValue=" + secondarySubjectValue + ", experienceInYear=" + experienceInYear
				+ ", experienceInMonth=" + experienceInMonth + ", id=" + id + "]";
	}

}
