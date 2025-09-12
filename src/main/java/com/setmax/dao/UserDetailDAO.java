package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.UsersDetail;
import com.setmax.response.UserListResponse;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;

public class UserDetailDAO {
	public UserListResponse showListOfUsers() {
		List<UsersDetail> tempList = new ArrayList<UsersDetail>();
		UserListResponse list = new UserListResponse();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from users where record_status_id <> ?;");
			statement.setInt(1, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UsersDetail user = new UsersDetail();
				user.setId(result.getInt(1));
				int userTypeId = result.getInt(4);
				user.setUserType(getUserTypeDesc(userTypeId));
				user.setUsername(result.getString(2));
				user.setFirstName(result.getString(5));
				user.setLastName(result.getString(7));
				user.setEmail(result.getString(9));
				user.setDob(result.getString(11));
				tempList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.setUserDetailList(tempList);
		return list;
	}

	public String getUserTypeDesc(int id) {
		String userType = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select user_type from user_types where user_type_id=?;");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userType = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userType;
	}
}