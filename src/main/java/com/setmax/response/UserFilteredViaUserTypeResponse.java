package com.setmax.response;

import java.util.List;

import com.setmax.dto.UserDTO;

public class UserFilteredViaUserTypeResponse {
	List<UserDTO> users;

	public UserFilteredViaUserTypeResponse(List<UserDTO> users) {
		this.users = users;
	}

	public UserFilteredViaUserTypeResponse() {
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

}
