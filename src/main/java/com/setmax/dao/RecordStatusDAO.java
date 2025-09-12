package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.RecordStatusDTO;
import com.setmax.util.DBConnection;

public class RecordStatusDAO {
	public List<RecordStatusDTO> getRecordStatus() {
		List<RecordStatusDTO> recordStatusDTOList = new ArrayList<RecordStatusDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from record_status;");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				RecordStatusDTO recordStatus = new RecordStatusDTO();
				recordStatus.setId(result.getInt(1));
				recordStatus.setName(result.getString(2));
				recordStatusDTOList.add(recordStatus);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordStatusDTOList;
	}
}
