package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.StudentAttendenceSearchParamsDTO;
import com.setmax.dto.UserDTO;
import com.setmax.dto.UserStudentAttendenceDTO;
import com.setmax.dto.UserStudentDTO;
import com.setmax.util.Constant;
import com.setmax.util.DBConnection;
import com.setmax.util.DateUtil;

public class UserDAO {
	public long saveUserInfo(UserDTO user) throws Exception {
		long id = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into users(username,user_type_id,first_name,middle_name,last_name,gender,email,mobile_number"
							+ ",dob,address,record_status_id) values(?,?,?,?,?,?,?,?,?,?,?);",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, user.getUserName());
			int userTypeId = Integer.parseInt(user.getUserTypeId());
			statement.setInt(2, userTypeId);
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getMiddleName());
			statement.setString(5, user.getLastName());
			statement.setString(6, user.getGender());
			statement.setString(7, user.getEmail());
			statement.setString(8, user.getMobileNumber());
			String dob = user.getDateOfBirth();
			java.util.Date date = DateUtil.parseToDate(dob);
			java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
			statement.setDate(9, dateOfBirth);
			statement.setString(10, user.getAddress());
			int recordStatusId = Integer.parseInt(user.getRecordStatusId());
			statement.setInt(11, recordStatusId);

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

	public int updateUserInfo(UserDTO user) throws Exception {
		int userInfoUpdated = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update users set mobile_number=?,address=?,record_status_id=? where id=?;");
			statement.setString(1, user.getMobileNumber());
			statement.setString(2, user.getAddress());
			statement.setInt(3, Integer.parseInt(user.getRecordStatusId()));
			statement.setInt(4, user.getId());
			userInfoUpdated = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return userInfoUpdated;
	}

	public UserDTO getUserDetail(int userId) {
		UserDTO userInfoDTO = new UserDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from users where id=? and record_status_id <> ?;");
			statement.setInt(1, userId);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userInfoDTO.setId(result.getInt(1));
				userInfoDTO.setUserName(result.getString(2));
				userInfoDTO.setUserTypeId(String.valueOf(result.getInt(4)));
				userInfoDTO.setUserTypeValue(getUserTypeValue(userId));
				userInfoDTO.setFirstName(result.getString(5));
				userInfoDTO.setMiddleName(result.getString(6));
				userInfoDTO.setLastName(result.getString(7));
				userInfoDTO.setGender(result.getString(8));
				userInfoDTO.setEmail(result.getString(9));
				userInfoDTO.setMobileNumber(result.getString(10));

				java.sql.Date sqlDob = result.getDate(11);
				java.util.Date utilDob = new java.util.Date(sqlDob.getTime());
				String dateOfBirth = DateUtil.formatDate(utilDob);
				userInfoDTO.setDateOfBirth(dateOfBirth);

				userInfoDTO.setAddress(result.getString(12));
				userInfoDTO.setRecordStatusId(String.valueOf(result.getInt(13)));
				userInfoDTO.setRecordStatusValue(getRecordStatusValue(userId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	public boolean getAllUsername(String username) {
		boolean isNotValidUserName = false;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from users where username=? and record_status_id <> ?;");
			statement.setString(1, username);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (username.equals(result.getString(2))) {
					isNotValidUserName = true;
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isNotValidUserName;
	}

	public boolean getAllEmail(String email) {
		boolean isNotValidEmail = false;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from users where email=? and record_status_id <> ?;");
			statement.setString(1, email);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				if (email.equals(result.getString(9))) {
					isNotValidEmail = true;
				}
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isNotValidEmail;
	}

	public List<UserDTO> getUsersName(int guardianTypeId) {
		List<UserDTO> usersName = new ArrayList<UserDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select id,first_name,middle_name,last_name from users where user_type_id=? and "
							+ "record_status_id <> ?;");
			statement.setInt(1, guardianTypeId);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserDTO usersDetail = new UserDTO();
				usersDetail.setId(result.getInt(1));
				usersName.add(usersDetail);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersName;
	}

	public int deleteUserByUserId(int userId) throws Exception {
		int recordDeleted = 0;
		int recordStatusId = Constant.STATUS_DELETED;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update users set record_status_id = ? where id = ? ;");
			statement.setInt(1, recordStatusId);
			statement.setInt(2, userId);
			recordDeleted = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return recordDeleted;
	}

	public UserDTO findById(int userId) {
		UserDTO userDTO = new UserDTO();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select first_name,middle_name,last_name from users where id=? and record_status_id <> ?;");
			statement.setInt(1, userId);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userDTO.setFirstName(result.getString(1));
				userDTO.setMiddleName(result.getString(2));
				userDTO.setLastName(result.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	public int getUserTypeId(int id) {
		int userTypeId = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select user_type_id from users where id=? and record_status_id <> ?;");
			statement.setInt(1, id);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userTypeId = result.getInt(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTypeId;
	}

	private String getUserTypeValue(int id) {
		String userTypeValue = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select ut.user_type from users u INNER JOIN user_types ut on u.user_type_id=ut.user_type_id "
							+ "where u.id=? and u.record_status_id <> ?;");
			statement.setInt(1, id);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userTypeValue = result.getString(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTypeValue;
	}

	private String getRecordStatusValue(int id) {
		String recordStatusValue = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select rs.status from users u INNER JOIN record_status rs on u.record_status_id=rs.id "
							+ "where u.id=? and u.record_status_id <> ?;");
			statement.setInt(1, id);
			statement.setInt(2, Constant.STATUS_DELETED);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				recordStatusValue = result.getString(1);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordStatusValue;
	}

	public List<UserStudentDTO> getAcademicSessionStudentsDataByStandardId(int standardId) {
		List<UserStudentDTO> userStudentDTOList = new ArrayList<UserStudentDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select u.id,s.id,s.father_name from users u INNER JOIN "
							+ "student_info s on u.id=s.user_id where s.standard=? and u.record_status_id = ?;");
			statement.setInt(1, standardId);
			statement.setInt(2, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserStudentDTO userStudentDTO = new UserStudentDTO();
				userStudentDTO.setUserId(String.valueOf(result.getInt(1)));
				userStudentDTO.setStudentId(String.valueOf(result.getInt(2)));
				userStudentDTO.setFatherName(result.getString(3));
				userStudentDTOList.add(userStudentDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userStudentDTOList;
	}

	public List<UserStudentDTO> getAcademicSessionStudentsDataByStandardIdAndAcademicSession(int standardId,
			int academicSessionId) {
		List<UserStudentDTO> userStudentDTOList = new ArrayList<UserStudentDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"select u.id,s.id,s.father_name,sas.academic_session_id  from users u INNER JOIN student_info s on "
							+ "u.id=s.user_id inner join student_academic_session sas on s.user_id = sas.user_id "
							+ "where s.standard=? and sas.academic_session_id = ? and u.record_status_id = ?");
			statement.setInt(1, standardId);
			statement.setInt(2, academicSessionId);
			statement.setInt(3, Constant.STATUS_ACTIVE);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserStudentDTO userStudentDTO = new UserStudentDTO();
				userStudentDTO.setUserId(String.valueOf(result.getInt(1)));
				userStudentDTO.setStudentId(String.valueOf(result.getInt(2)));
				userStudentDTO.setFatherName(result.getString("father_name"));
				userStudentDTO.setStudentAcademicSessionId(String.valueOf(result.getInt("academic_session_id")));
				userStudentDTOList.add(userStudentDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userStudentDTOList;
	}

	public List<UserStudentAttendenceDTO> getStudentAttendenceRecordsBySearchParams(
			StudentAttendenceSearchParamsDTO searchParams) {
		List<UserStudentAttendenceDTO> userStudentAttendenceDTOList = new ArrayList<UserStudentAttendenceDTO>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement(getQueryForStudentAttendenceRecords(searchParams));
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserStudentAttendenceDTO userStudentAttendenceDTO = new UserStudentAttendenceDTO();
				userStudentAttendenceDTO.setUserId(String.valueOf(result.getInt(1)));
				userStudentAttendenceDTO.setStudentAttendenceRecordId(result.getInt(2));
				userStudentAttendenceDTO.setStudentId(String.valueOf(result.getInt(3)));
				userStudentAttendenceDTO.setStandardId(String.valueOf(result.getInt("standard")));
				userStudentAttendenceDTO.setAttendenceStatus(result.getString("attendence_status"));
				userStudentAttendenceDTO.setAttendenceDate(DateUtil.formatSqlDate(result.getDate("attendence_date")));
				userStudentAttendenceDTO.setAttendenceByUserId(String.valueOf(result.getInt("attendence_by")));
				userStudentAttendenceDTOList.add(userStudentAttendenceDTO);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userStudentAttendenceDTOList;
	}

	private String getQueryForStudentAttendenceRecords(StudentAttendenceSearchParamsDTO searchParams) {
		String query = "select u.id,sa.id,si.id,si.standard ,sa.attendence_status,sa.attendence_date,sa.attendence_by from users u"
				+ " inner join student_info si on u.id = si.user_id"
				+ " inner join student_attendence sa  on u.id = sa.student_user_id where ";
		query += "u.record_status_id = " + Constant.STATUS_ACTIVE + " ";
		query = appendYearInQuery(query, searchParams.getAttendenceYear());
		query = appendMonthInQuery(query, searchParams.getAttendenceMonth());
		query = appendDayInQuery(query, searchParams.getAttendenceDay());
		query = appendStandardIdInQuery(query, searchParams.getAttendenceByStandardId());
		query = appendStudentInfoInQuery(query, searchParams.getStudentInfo());
		query += " ;";
		return query;
	}

	private String appendYearInQuery(String query, String year) {
		if (year == null || year.isEmpty()) {
			return query;
		} else {
			query += "and year(sa.attendence_date) = " + year + " ";
			return query;
		}
	}

	private String appendMonthInQuery(String query, String month) {
		if (month == null || month.isEmpty()) {
			return query;
		} else {
			query += "and month(sa.attendence_date) = " + month + " ";
			return query;
		}
	}

	private String appendDayInQuery(String query, String day) {
		if (day == null || day.isEmpty()) {
			return query;
		} else {
			query += "and day(sa.attendence_date) = " + day + " ";
			return query;
		}
	}

	private String appendStandardIdInQuery(String query, String standardId) {
		if (standardId == null || standardId.isEmpty()) {
			return query;
		} else {
			query += "and sa.standard = " + standardId + " ";
			return query;
		}
	}

	private String appendStudentInfoInQuery(String query, String studentInfo) {
		if (studentInfo == null || studentInfo.isEmpty()) {
			return query;
		} else {
			query += "and (u.first_name like '%" + studentInfo + "%' or u.middle_name like '%" + studentInfo
					+ "%' or u.last_name like '%" + studentInfo + "%' or u.email like '%" + studentInfo
					+ "%' or si.id like '%" + studentInfo + "%' or si.father_name like '%" + studentInfo + "%')";
			return query;
		}
	}

}