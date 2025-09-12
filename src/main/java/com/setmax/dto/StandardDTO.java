package com.setmax.dto;

public class StandardDTO {
	private int id;
	private int standard;
	private String standardSuffix;
	private String standardName;
	private String classTeacherId;
	private String classTeacherValue;
	private String classRoomId;

	public StandardDTO() {

	}

	public StandardDTO(int id, int standard, String standardSuffix, String standardName, String classTeacherId,
			String classTeacherValue, String classRoomId) {
		this.id = id;
		this.standard = standard;
		this.standardSuffix = standardSuffix;
		this.standardName = standardName;
		this.classTeacherId = classTeacherId;
		this.classTeacherValue = classTeacherValue;
		this.classRoomId = classRoomId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getStandardSuffix() {
		return standardSuffix;
	}

	public void setStandardSuffix(String standardSuffix) {
		this.standardSuffix = standardSuffix;
	}

	public String getClassTeacherId() {
		return classTeacherId;
	}

	public void setClassTeacherId(String classTeacherId) {
		this.classTeacherId = classTeacherId;
	}

	public String getClassTeacherValue() {
		return classTeacherValue;
	}

	public void setClassTeacherValue(String classTeacherValue) {
		this.classTeacherValue = classTeacherValue;
	}

	public String getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(String classRoomId) {
		this.classRoomId = classRoomId;
	}

	@Override
	public String toString() {
		return "StandardDTO [id=" + id + ", standard=" + standard + ", standardSuffix=" + standardSuffix
				+ ", standardName=" + standardName + ", classTeacherId=" + classTeacherId + ", classTeacherValue="
				+ classTeacherValue + ", classRoomId=" + classRoomId + "]";
	}

}
