package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.setmax.dto.TeacherInfoDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;

public class TeacherInfoDAO {
	public long saveTeacherInfo(TeacherInfoDTO teacher) throws Exception {
		long id = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(
							"insert into teacher_info(user_id,primary_subject,secondary_subject,experience_in_years,"
									+ "experience_in_months,status) values(?,?,?,?,?,?);",
							Statement.RETURN_GENERATED_KEYS);
			int userId = Integer.parseInt(teacher.getTeacherUserId());
			statement.setInt(1, userId);
			statement.setString(2, teacher.getPrimarySubjectId());
			statement.setString(3, teacher.getSecondarySubjectId());
			int experienceInMonth = Integer.parseInt(teacher.getExperienceInMonth());
			statement.setInt(4, experienceInMonth);
			int experienceInYear = Integer.parseInt(teacher.getExperienceInYear());
			statement.setInt(5, experienceInYear);
			statement.setInt(6, Constant.STATUS_ACTIVE);
			int affectedRows = statement.executeUpdate();
			if (affectedRows != 0) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				id = getRecordInsertedAt(affectedRows, generatedKeys);
			}
			connection.close();
		} catch (Exception e) {
			throw e;
		}
		return id;
	}

	public long getRecordInsertedAt(int affectedRows, ResultSet generatedKeys) throws Exception {
		long id = 0;
		try {
			if (generatedKeys.next()) {
				id = generatedKeys.getLong(1);
			}
		} catch (Exception e) {
			throw e;
		}
		return id;
	}

	public int updateTeacherInfo(TeacherInfoDTO teacher) throws Exception {
		int status = Constant.STATUS_ACTIVE;
		int teacherInfoUpdated = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update teacher_info set secondary_subject=?,experience_in_years=?,experience_in_months=? "
							+ "where user_id=? and status=?;");
			statement.setInt(1, Integer.parseInt(teacher.getSecondarySubjectId()));
			statement.setInt(2, Integer.parseInt(teacher.getExperienceInYear()));
			statement.setInt(3, Integer.parseInt(teacher.getExperienceInMonth()));
			statement.setInt(4, Integer.parseInt(teacher.getTeacherUserId()));
			statement.setInt(5, status);
			teacherInfoUpdated = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return teacherInfoUpdated;
	}

	public TeacherInfoDTO findByUserId(int userId) {
		int status = Constant.STATUS_ACTIVE;
		TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from teacher_info where user_id=? and status=?");
			statement.setInt(1, userId);
			statement.setInt(2, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				teacherInfoDTO.setId(result.getInt(1));
				teacherInfoDTO.setTeacherUserId(String.valueOf(result.getInt(2)));
				teacherInfoDTO.setPrimarySubjectId(String.valueOf(result.getInt(3)));
				teacherInfoDTO.setPrimarySubjectValue(getPrimarySubjectValue(userId));
				teacherInfoDTO.setSecondarySubjectId(String.valueOf(result.getInt(4)));
				teacherInfoDTO.setSecondarySubjectValue(getSecondarySubjectValue(userId));
				teacherInfoDTO.setExperienceInYear(String.valueOf(result.getInt(5)));
				teacherInfoDTO.setExperienceInMonth(String.valueOf(result.getInt(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherInfoDTO;
	}

	private String getPrimarySubjectValue(int id) {
		int status = Constant.STATUS_ACTIVE;
		String primarySubject = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select subjects.subject_name from teacher_info INNER JOIN subjects on "
							+ "teacher_info.primary_subject=subjects.id where teacher_info.user_id=? and "
							+ "teacher_info.status=? and subjects.status=?;");
			statement.setInt(1, id);
			statement.setInt(2, status);
			statement.setInt(3, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				primarySubject = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return primarySubject;
	}

	private String getSecondarySubjectValue(int id) {
		int status = Constant.STATUS_ACTIVE;
		String secondarySubject = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select subjects.subject_name from teacher_info INNER JOIN subjects on "
							+ "teacher_info.secondary_subject=subjects.id where teacher_info.user_id=? and "
							+ "teacher_info.status=? and subjects.status=?;");
			statement.setInt(1, id);
			statement.setInt(2, status);
			statement.setInt(3, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				secondarySubject = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secondarySubject;
	}
}
