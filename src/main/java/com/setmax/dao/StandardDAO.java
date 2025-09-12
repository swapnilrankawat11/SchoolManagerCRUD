package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.StandardDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;

public class StandardDAO {
	public List<StandardDTO> getAllClasses() {
		List<StandardDTO> standardDTOList = new ArrayList<StandardDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select id,class,suffix from standard where status=?;");
			statement.setInt(1, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				StandardDTO standardDTO = new StandardDTO();
				standardDTO.setId(result.getInt(1));
				standardDTO.setStandard(result.getInt(2));
				standardDTO.setStandardSuffix(result.getString(3));
				standardDTOList.add(standardDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return standardDTOList;
	}

	public StandardDTO findById(int standardId) {
		StandardDTO standardDTO = new StandardDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from standard where id=? and status = ?;");
			statement.setInt(1, standardId);
			statement.setInt(2, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				standardDTO.setId(result.getInt(1));
				standardDTO.setStandard(result.getInt(2));
				standardDTO.setStandardSuffix(result.getString(3));
				standardDTO.setClassTeacherId(String.valueOf(result.getInt(4)));
				standardDTO.setClassRoomId(String.valueOf(result.getInt(5)));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return standardDTO;
	}
}
