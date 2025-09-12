package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.StudentAttendenceDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;
import com.setmax.util.DateUtil;

public class StudentAttendenceDAO {
	public StudentAttendenceDTO getStudentAttendenceRecordByStudentUserId(long studentUserId, int standardId,
			java.sql.Date attendenceDate) {
		StudentAttendenceDTO studentAttendenceDTO = new StudentAttendenceDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select * from student_attendence sa where student_user_id = ? and standard = ? and "
							+ "date(attendence_date) = ?;");
			statement.setLong(1, studentUserId);
			statement.setInt(2, standardId);
			statement.setDate(3, attendenceDate);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				studentAttendenceDTO.setId(result.getInt(1));
				studentAttendenceDTO.setStudentUserId(String.valueOf(result.getInt("student_user_id")));
				studentAttendenceDTO.setAttendenceStatus(result.getString("attendence_status"));
				studentAttendenceDTO.setStandardId(String.valueOf(result.getInt("standard")));
				studentAttendenceDTO.setAttendenceDate(DateUtil.formatSqlDate(result.getDate("attendence_date")));
				studentAttendenceDTO.setAttendenceByUserId(String.valueOf(result.getInt("attendence_by")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentAttendenceDTO;
	}

	public List<StudentAttendenceDTO> getStudentAttendenceRecordByStandardAndAttendenceDate(int standardId,
			java.sql.Date attendenceDate) {
		List<StudentAttendenceDTO> studentAttendenceDTOList = new ArrayList<StudentAttendenceDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select * from student_attendence where standard = ? and attendence_date = ? and record_status =?;");
			statement.setInt(1, standardId);
			statement.setDate(2, attendenceDate);
			statement.setInt(3, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				StudentAttendenceDTO studentAttendenceDTO = new StudentAttendenceDTO();
				studentAttendenceDTO.setId(result.getInt(1));
				studentAttendenceDTO.setStudentUserId(String.valueOf(result.getInt("student_user_id")));
				studentAttendenceDTO.setAttendenceStatus(result.getString("attendence_status"));
				studentAttendenceDTO.setStandardId(String.valueOf(result.getInt("standard")));
				studentAttendenceDTO.setAttendenceDate(DateUtil.formatSqlDate(result.getDate("attendence_date")));
				studentAttendenceDTO.setAttendenceByUserId(String.valueOf(result.getInt("attendence_by")));
				studentAttendenceDTOList.add(studentAttendenceDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentAttendenceDTOList;
	}

	public int saveStudentAttendence(List<StudentAttendenceDTO> studentAttendenceDTOList) {
		int querySucceed = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into student_attendence (student_user_id,attendence_status,standard,attendence_date,"
							+ "attendence_by,record_status,created_by,created_date) values(?,?,?,?,?,?,?,?)");
			for (StudentAttendenceDTO studentAttendence : studentAttendenceDTOList) {
				statement.setInt(1, Integer.parseInt(studentAttendence.getStudentUserId()));
				statement.setString(2, studentAttendence.getAttendenceStatus());
				statement.setInt(3, Integer.parseInt(studentAttendence.getStandardId()));
				statement.setString(4, studentAttendence.getAttendenceDate());
				statement.setLong(5, Long.valueOf(studentAttendence.getAttendenceByUserId()));
				statement.setInt(6, Constant.STATUS_ACTIVE);
				statement.setLong(7, Long.valueOf(studentAttendence.getAttendenceByUserId()));
				statement.setString(8, DateUtil.getCurrentDateTime());
				querySucceed = statement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return querySucceed;
	}

	public void updateStudentAttendence(List<StudentAttendenceDTO> studentAttendenceDTOList) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("update student_attendence "
					+ "set attendence_status = ?, attendence_by = ? ,modified_by = ?, modified_date = ? where attendence_date = ? and student_user_id = ? and standard = ? "
					+ "and record_status = ?;");
			for (StudentAttendenceDTO studentAttendence : studentAttendenceDTOList) {
				statement.setString(1, studentAttendence.getAttendenceStatus());
				statement.setLong(2, Long.valueOf(studentAttendence.getAttendenceByUserId()));
				statement.setLong(3, Long.valueOf(studentAttendence.getAttendenceByUserId()));
				statement.setString(4, DateUtil.getCurrentDateTime());
				statement.setString(5, studentAttendence.getAttendenceDate());
				statement.setInt(6, Integer.parseInt(studentAttendence.getStudentUserId()));
				statement.setInt(7, Integer.parseInt(studentAttendence.getStandardId()));
				statement.setInt(8, Constant.STATUS_ACTIVE);
				statement.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
