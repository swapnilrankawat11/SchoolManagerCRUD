package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.AcademicSessionDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;
import com.setmax.util.DateUtil;

public class AcademicSessionDAO {
	public AcademicSessionDTO getCurrentAcademicSession() {
		AcademicSessionDTO currentAcademicSession = new AcademicSessionDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select id,session_start,session_end from academic_session where is_current_session=? and status=?;");
			statement.setBoolean(1, true);
			statement.setInt(2, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				currentAcademicSession.setId(result.getInt("id"));
				currentAcademicSession.setSessionStart(DateUtil.formatSqlDate(result.getDate("session_start")));
				currentAcademicSession.setSessionEnd(DateUtil.formatSqlDate(result.getDate("session_end")));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentAcademicSession;
	}

	public List<AcademicSessionDTO> getAllAcademicSession() {
		List<AcademicSessionDTO> academicSessions = new ArrayList<AcademicSessionDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from academic_session where status=?;");
			statement.setInt(1, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				AcademicSessionDTO academicSessionDTO = new AcademicSessionDTO();
				academicSessionDTO.setId(result.getInt("id"));
				academicSessionDTO.setSessionStart(DateUtil.formatSqlDate(result.getDate("session_start")));
				academicSessionDTO.setSessionEnd(DateUtil.formatSqlDate(result.getDate("session_end")));
				academicSessionDTO.setIsCurrentSession(result.getBoolean("is_current_session"));
				academicSessions.add(academicSessionDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return academicSessions;
	}

}
