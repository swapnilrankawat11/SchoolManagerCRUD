package com.setmax.response;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.UsersDetail;

public class JSONUsersObject {
	private List<UsersDetail> userDetailList = new ArrayList<UsersDetail>();

	public List<UsersDetail> getUserDetailList() {
		return userDetailList;
	}

	public JSONUsersObject() {
	}

	public JSONUsersObject(List<UsersDetail> userDetailList) {
		this.userDetailList = userDetailList;
	}

	public void setUserDetailList(List<UsersDetail> userDetailList) {
		this.userDetailList = userDetailList;
	}
}