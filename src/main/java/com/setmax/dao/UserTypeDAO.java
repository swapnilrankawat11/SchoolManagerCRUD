package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.UserTypeDTO;
import com.setmax.util.DBConnection;

public class UserTypeDAO {
	public List<UserTypeDTO> getUserTypes() {
		List<UserTypeDTO> userTypeslist = new ArrayList<UserTypeDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from user_types;");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserTypeDTO userType = new UserTypeDTO();
				userType.setName(result.getString(1));
				userType.setId(result.getInt(2));
				userTypeslist.add(userType);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTypeslist;
	}
}