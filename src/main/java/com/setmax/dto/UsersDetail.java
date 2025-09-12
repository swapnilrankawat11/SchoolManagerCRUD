package com.setmax.dto;

public class UsersDetail {
	private int id;
	private String userType;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;

	public UsersDetail() {
	}

	public UsersDetail(int id, String userType, String username, String firstName, String lastName, String email,
			String dob) {
		this.id = id;
		this.userType = userType;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UsersDetail [id=" + id + ", userType=" + userType + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", dob=" + dob + "]";
	}

}