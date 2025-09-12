package com.setmax.dto;

public class UserDTO {
	private String userTypeId;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String gender;
	private String mobileNumber;
	private String address;
	private String recordStatusId;
	private int id;
	private String fullName;
	private String userTypeValue;
	private String recordStatusValue;

	public UserDTO() {
	}

	public UserDTO(String userTypeId, String userName, String firstName, String middleName, String lastName,
			String dateOfBirth, String email, String gender, String mobileNumber, String address,
			String recordStatusId) {
		this.userTypeId = userTypeId;
		this.userName = userName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.recordStatusId = recordStatusId;
	}

	public UserDTO(int id, String firstName, String middleName, String lastName) {
		this.id = id;
		String fullName = firstName + middleName + lastName;
		this.fullName = fullName;
	}

	public String getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRecordStatusId() {
		return recordStatusId;
	}

	public void setRecordStatusId(String recordStatusId) {
		this.recordStatusId = recordStatusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserTypeValue() {
		return userTypeValue;
	}

	public void setUserTypeValue(String userTypeValue) {
		this.userTypeValue = userTypeValue;
	}

	public String getRecordStatusValue() {
		return recordStatusValue;
	}

	public void setRecordStatusValue(String recordStatusValue) {
		this.recordStatusValue = recordStatusValue;
	}

	@Override
	public String toString() {
		return "UserDTO [userTypeId=" + userTypeId + ", userName=" + userName + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", recordStatusId=" + recordStatusId + ", id=" + id + ", fullName=" + fullName + ", userTypeValue="
				+ userTypeValue + ", recordStatusValue=" + recordStatusValue + "]";
	}

}
