package com.setmax.service;

import com.setmax.dao.UserDetailDAO;
import com.setmax.response.UserListResponse;

public class ServeUserDetail {
	public UserListResponse getListOfUsers() {
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserListResponse list = userDetailDAO.showListOfUsers();
		return list;
	}
}