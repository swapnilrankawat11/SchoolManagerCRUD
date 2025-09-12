package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.setmax.dto.LoginDetails;
import com.setmax.dto.LoginUserDTO;
import com.setmax.response.LoginJsonResponse;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;

public class LoginDAO {
	private String username;
	private String password;

	LoginJsonResponse loginResult = new LoginJsonResponse();

	public LoginJsonResponse verify(LoginDetails loginDetails) {
		String authenticated = "AUTHENTICATED";
		String missingInput = "MISSING_INPUT";
		String wrongPassword = "WRONG_PASSWORD";
		boolean status = false;
		username = loginDetails.getUsername();
		password = loginDetails.getPassword();

		if (username.isBlank() || password.isBlank()) {
			loginResult.setLoginStatus(missingInput);
		}

		else {
			try {
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"select * from users where username=? and password=? and record_status_id <> ?;");
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setInt(3, Constant.STATUS_DELETED);
				ResultSet result = statement.executeQuery();
				status = result.next();
				if (status) {
					loginResult.setLoginStatus(authenticated);
				} else {
					loginResult.setLoginStatus(wrongPassword);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginResult;
	}

	public LoginUserDTO getLoggedInUser() {
		LoginUserDTO loggedInUser = new LoginUserDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from users where username=? and password=? and record_status_id <> ?;");
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setInt(3, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				loggedInUser.setId(result.getInt(1));
				loggedInUser.setFirst_name(result.getString(5));
				loggedInUser.setLast_name(result.getString(6));
				loggedInUser.setUserTypeID(result.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedInUser;
	}
}