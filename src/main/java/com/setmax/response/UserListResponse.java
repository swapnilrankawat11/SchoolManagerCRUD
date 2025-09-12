package com.setmax.response;

import java.util.List;

import com.setmax.dto.UsersDetail;

public class UserListResponse {
	private List<UsersDetail> userDetailList;

	public List<UsersDetail> getUserDetailList() {
		return userDetailList;
	}

	public UserListResponse() {
	}

	public UserListResponse(List<UsersDetail> userDetailList) {
		this.userDetailList = userDetailList;
	}

	public void setUserDetailList(List<UsersDetail> userDetailList) {
		this.userDetailList = userDetailList;
	}
}