package com.setmax.service;

import com.setmax.dao.LoginDAO;
import com.setmax.dto.LoginDetails;
import com.setmax.dto.LoginUserDTO;
import com.setmax.response.LoginJsonResponse;

public class LoginService {
	LoginDAO loginDAO = new LoginDAO();
	public LoginJsonResponse isValidated(LoginDetails loginDetails) {
		LoginJsonResponse loginResult = loginDAO.verify(loginDetails);
		return loginResult;
	}

	public LoginUserDTO getLoggedInUserData() {
		LoginUserDTO user = loginDAO.getLoggedInUser();
		return user;
	}
}