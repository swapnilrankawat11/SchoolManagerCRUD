package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.setmax.dto.StudentInfoDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;

public class StudentInfoDAO {
	public long saveStudentInfo(StudentInfoDTO student) throws Exception {
		long id = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into student_info(user_id,standard,favorite_sport,third_language,guardian_type_id,"
							+ "guardian_user_id,father_name,mother_name,status) values(?,?,?,?,?,?,?,?,?);",
					Statement.RETURN_GENERATED_KEYS);
			int userId = Integer.parseInt(student.getStudentUserId());
			statement.setInt(1, userId);
			int standard = Integer.parseInt(student.getStandardId());
			statement.setInt(2, standard);
			int favoriteSportId = Integer.parseInt(student.getFavoriteSportId());
			statement.setInt(3, favoriteSportId);
			int thirdLanguageId = Integer.parseInt(student.getThirdLanguageId());
			statement.setInt(4, thirdLanguageId);
			int guardianTypeId = Integer.parseInt(student.getGuardianTypeId());
			statement.setInt(5, guardianTypeId);
			int guardianUserId = Integer.parseInt(student.getGuardianUserId());
			statement.setInt(6, guardianUserId);
			statement.setString(7, student.getFatherName());
			statement.setString(8, student.getMotherName());
			statement.setInt(9, Constant.STATUS_ACTIVE);
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

	public int updateStudentInfo(StudentInfoDTO student) throws Exception {
		int status = Constant.STATUS_ACTIVE;
		int studentInfoUpdated = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update student_info set favorite_sport=?,guardian_type_id=?,guardian_user_id=? where user_id=? and status=?;");
			statement.setInt(1, Integer.parseInt(student.getFavoriteSportId()));
			statement.setInt(2, Integer.parseInt(student.getGuardianTypeId()));
			statement.setInt(3, Integer.parseInt(student.getGuardianUserId()));
			statement.setInt(4, Integer.parseInt(student.getStudentUserId()));
			statement.setInt(5, status);
			studentInfoUpdated = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return studentInfoUpdated;
	}

	public StudentInfoDTO findByUserId(int userId) {
		int status = Constant.STATUS_ACTIVE;
		StudentInfoDTO studentInfoDTO = new StudentInfoDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from student_info where user_id=? and status=?");
			statement.setInt(1, userId);
			statement.setInt(2, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				studentInfoDTO.setId(result.getInt(1));
				studentInfoDTO.setStudentUserId(String.valueOf(result.getInt(2)));
				studentInfoDTO.setStandardId(String.valueOf(result.getInt(3)));

				studentInfoDTO.setFavoriteSportId(String.valueOf(result.getInt(4)));
				studentInfoDTO.setFavoriteSportValue(getFavoriteSportValue(userId));
				studentInfoDTO.setThirdLanguageId(String.valueOf(result.getInt(5)));
				studentInfoDTO.setThirdLanguageValue(getThirdLanguageValue(userId));
				studentInfoDTO.setGuardianTypeId(String.valueOf(result.getInt(6)));
				studentInfoDTO.setGuardianTypeValue(getGuardianTypeValue(userId));
				studentInfoDTO.setGuardianUserId(String.valueOf(result.getInt(7)));
				studentInfoDTO.setGuardianUserValue(getGuardianUserValue(userId));
				studentInfoDTO.setFatherName(result.getString(8));
				studentInfoDTO.setMotherName(result.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentInfoDTO;
	}

	private String getFavoriteSportValue(int id) {
		int status = Constant.STATUS_ACTIVE;
		String favoriteSport = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select sports.sport_name from student_info INNER JOIN sports on "
							+ "student_info.favorite_sport=sports.id where student_info.user_id=? and "
							+ "student_info.status=? and sports.status=?;");
			statement.setInt(1, id);
			statement.setInt(2, status);
			statement.setInt(3, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				favoriteSport = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return favoriteSport;
	}

	private String getThirdLanguageValue(int id) {
		int status = Constant.STATUS_ACTIVE;
		String thirdLanguage = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select subjects.subject_name from student_info INNER JOIN subjects on "
							+ "student_info.third_language=subjects.id where student_info.user_id=? and "
							+ "student_info.status=? and subjects.status=?;");
			statement.setInt(1, id);
			statement.setInt(2, status);
			statement.setInt(3, status);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				thirdLanguage = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thirdLanguage;

	}

	private String getGuardianTypeValue(int id) {
		String guardianType = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select user_types.user_type from student_info INNER JOIN user_types on "
							+ "student_info.guardian_type_id=user_type_id where student_info.user_id=?;");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				guardianType = result.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guardianType;
	}

	private String getGuardianUserValue(int id) {
		String guardianUser = null;
		String firstName = null, middleName = null, lastName = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select users.first_name,middle_name,last_name from student_info INNER JOIN users on "
							+ "student_info.guardian_user_id=users.id where student_info.user_id=?;");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				firstName = result.getString(1);
				middleName = result.getString(2);
				lastName = result.getString(3);
			}
			guardianUser = getFullName(firstName, middleName, lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guardianUser;
	}

	private String getFullName(String firstName, String middleName, String lastName) {
		String fullName;
		if (middleName == null) {
			middleName = "";
			fullName = firstName + " " + lastName;
		} else {
			fullName = firstName + " " + middleName + " " + lastName;
		}
		return fullName;
	}
}
