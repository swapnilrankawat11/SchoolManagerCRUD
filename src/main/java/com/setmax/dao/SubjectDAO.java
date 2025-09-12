package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.SubjectDTO;
import com.setmax.util.DBConnection;

public class SubjectDAO {
	public List<SubjectDTO> getSubjects() {
		List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from subjects");
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				SubjectDTO subject = new SubjectDTO();
				subject.setId(result.getInt(1));
				subject.setName(result.getString(2));
				subject.setIsLanguage(result.getBoolean(3));
				subjectDTOList.add(subject);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectDTOList;
	}
}