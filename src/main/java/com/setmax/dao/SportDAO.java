package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.SportDTO;
import com.setmax.util.DBConnection;

public class SportDAO {
	public List<SportDTO> getSports() {
		List<SportDTO> sportDTOList = new ArrayList<SportDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from sports;");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				SportDTO sport = new SportDTO();
				sport.setId(result.getInt(1));
				sport.setName(result.getString(2));
				sportDTOList.add(sport);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sportDTOList;
	}
}