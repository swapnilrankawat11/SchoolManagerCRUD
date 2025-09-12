package com.setmax.dto;

public class StudentInfoDTO {
	private String standardId;
	private String standardSuffix;
	private String standardValue;
	private String studentUserId;
	private String favoriteSportId;
	private String favoriteSportValue;
	private String thirdLanguageId;
	private String thirdLanguageValue;
	private String guardianTypeId;
	private String guardianTypeValue;
	private String guardianUserId;
	private String guardianUserValue;
	private String fatherName;
	private String motherName;
	private int id;

	public StudentInfoDTO() {
	}

	public StudentInfoDTO(String standardId, String favoriteSportId, String thirdLanguageId, String guardianTypeId,
			String guardianUserId, String fatherName, String motherName) {
		this.standardId = standardId;
		this.favoriteSportId = favoriteSportId;
		this.thirdLanguageId = thirdLanguageId;
		this.guardianTypeId = guardianTypeId;
		this.guardianUserId = guardianUserId;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getStudentUserId() {
		return studentUserId;
	}

	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}

	public String getFavoriteSportValue() {
		return favoriteSportValue;
	}

	public void setFavoriteSportValue(String favoriteSportValue) {
		this.favoriteSportValue = favoriteSportValue;
	}

	public String getThirdLanguageValue() {
		return thirdLanguageValue;
	}

	public void setThirdLanguageValue(String thirdLanguageValue) {
		this.thirdLanguageValue = thirdLanguageValue;
	}

	public String getGuardianTypeValue() {
		return guardianTypeValue;
	}

	public void setGuardianTypeValue(String guardianTypeValue) {
		this.guardianTypeValue = guardianTypeValue;
	}

	public String getGuardianUserValue() {
		return guardianUserValue;
	}

	public void setGuardianUserValue(String guardianUserValue) {
		this.guardianUserValue = guardianUserValue;
	}

	public String getFavoriteSportId() {
		return favoriteSportId;
	}

	public void setFavoriteSportId(String favoriteSportId) {
		this.favoriteSportId = favoriteSportId;
	}

	public String getThirdLanguageId() {
		return thirdLanguageId;
	}

	public void setThirdLanguageId(String thirdLanguageId) {
		this.thirdLanguageId = thirdLanguageId;
	}

	public String getGuardianTypeId() {
		return guardianTypeId;
	}

	public void setGuardianTypeId(String guardianTypeId) {
		this.guardianTypeId = guardianTypeId;
	}

	public String getGuardianUserId() {
		return guardianUserId;
	}

	public void setGuardianUserId(String guardianUserId) {
		this.guardianUserId = guardianUserId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStandardValue() {
		return standardValue;
	}

	public void setStandardValue(String standardValue) {
		this.standardValue = standardValue;
	}

	public String getStandardSuffix() {
		return standardSuffix;
	}

	public void setStandardSuffix(String standardSuffix) {
		this.standardSuffix = standardSuffix;
	}

	@Override
	public String toString() {
		return "StudentInfoDTO [standardId=" + standardId + ", standardSuffix=" + standardSuffix + ", standardValue="
				+ standardValue + ", studentUserId=" + studentUserId + ", favoriteSportId=" + favoriteSportId
				+ ", favoriteSportValue=" + favoriteSportValue + ", thirdLanguageId=" + thirdLanguageId
				+ ", thirdLanguageValue=" + thirdLanguageValue + ", guardianTypeId=" + guardianTypeId
				+ ", guardianTypeValue=" + guardianTypeValue + ", guardianUserId=" + guardianUserId
				+ ", guardianUserValue=" + guardianUserValue + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", id=" + id + "]";
	}

}
