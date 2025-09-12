package com.setmax.dto;

public class LoginUserDTO {
	private int id;
	private String username;
	private String password;
	private int userTypeID;
	private String first_name;
	private String last_name;
	private String email;
	private String dob;

	public LoginUserDTO(int id, String username, int userTypeID, String first_name, String last_name, String email,
			String dob) {
		this.id = id;
		this.username = username;
		this.userTypeID = userTypeID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.dob = dob;
	}

	public LoginUserDTO() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}
}