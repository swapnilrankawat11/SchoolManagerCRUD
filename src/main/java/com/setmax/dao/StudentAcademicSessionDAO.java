package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.setmax.dto.StudentAcademicSessionDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;
import com.setmax.util.DateUtil;

public class StudentAcademicSessionDAO {
	public int saveStudentAcademicSession(List<StudentAcademicSessionDTO> studentAcademicSessionList,
			long loggedInUserId, int academicSessionId) throws Exception {
		int querySucceed = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into student_academic_session (user_id,academic_session_id,standard,status,created_by,"
							+ "created_date) values(?,?,?,?,?,?);");
			for (StudentAcademicSessionDTO student : studentAcademicSessionList) {
				statement.setLong(1, Long.parseLong(student.getUserId()));
				statement.setInt(2, academicSessionId);
				statement.setInt(3, Integer.parseInt(student.getStandardId()));
				statement.setInt(4, Constant.STATUS_ACTIVE);
				statement.setLong(5, loggedInUserId);
				statement.setString(6, DateUtil.getCurrentDateTime());
				querySucceed = statement.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		}
		return querySucceed;
	}

	public int deleteStudentAcademicSession(int[] userIdArray, long loggedInUserId, int academicSessionId)
			throws Exception {
		int querySucceed = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(createQuery(userIdArray, loggedInUserId, academicSessionId));
			querySucceed = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return querySucceed;
	}

	public StudentAcademicSessionDTO findByUserIdAndAcademicSessionId(long userId, int academicSessionId) {
		StudentAcademicSessionDTO studentAcademicSessionDTO = new StudentAcademicSessionDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select * from student_academic_session where user_id=? and academic_session_id = ? and  status = ?;");
			statement.setLong(1, userId);
			statement.setInt(2, academicSessionId);
			statement.setInt(3, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				studentAcademicSessionDTO.setUserId(String.valueOf(result.getInt("user_id")));
				studentAcademicSessionDTO
						.setStudentAcademicSessionId(String.valueOf(result.getInt("academic_session_id")));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentAcademicSessionDTO;
	}

	private static String createQuery(int[] userIdArray, long loggedInUserId, int academicSessionId) {
		String query = "update student_academic_session set status = " + Constant.STATUS_DELETED + ", modified_by = "
				+ loggedInUserId + ", modified_date = '" + DateUtil.getCurrentDateTime() + "' where user_id != ";
		for (int i = 0; i < userIdArray.length; i++) {
			query += String.valueOf(userIdArray[i]);
			if (i != userIdArray.length - 1)
				query += " and user_id != ";
		}
		query += " and academic_session_id = " + academicSessionId + " and status= " + Constant.STATUS_ACTIVE + ";";
		return query;
	}
}
