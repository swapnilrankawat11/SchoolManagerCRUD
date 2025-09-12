package com.setmax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.StudentDetails;
import com.setmax.util.DBConnection;

public class StudentDAO {
	public int saveData(StudentDetails student) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(
					"insert into student_details(Full_Name,Mother_Name,Father_Name,Standard,Fees,Contact_Number) values (?,?,?,?,?,?);");

			statement.setString(1, student.getFullName());
			statement.setString(2, student.getMotherName());
			statement.setString(3, student.getFatherName());
			statement.setString(4, student.getStandard());
			statement.setString(5, student.getFees());
			statement.setString(6, student.getContactNumber());
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deleteData(int serial_no) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from student_details where Serial_No=?;");
			statement.setInt(1, serial_no);
			status = statement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateData(StudentDetails student) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update student_details SET Full_Name=?,Mother_Name=?,Father_Name=?,Standard=?,Fees=?,Contact_Number=? where Serial_No=?;");

			statement.setString(1, student.getFullName());
			statement.setString(2, student.getMotherName());
			statement.setString(3, student.getFatherName());
			statement.setString(4, student.getStandard());
			statement.setString(5, student.getFees());
			statement.setString(6, student.getContactNumber());
			statement.setInt(7, student.getSerialNo());
			status = statement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<StudentDetails> showListOfStudents() {
		List<StudentDetails> list = new ArrayList<StudentDetails>();

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from student_details;");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				StudentDetails student = new StudentDetails();
				student.setSerialNo(result.getInt(1));
				student.setFullName(result.getString(2));
				student.setMotherName(result.getString(3));
				student.setFatherName(result.getString(4));
				student.setStandard(result.getString(5));
				student.setFees(result.getString(6));
				student.setContactNumber(result.getString(7));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public StudentDetails getStudentDetails(int serial_no) {
		StudentDetails student = new StudentDetails();

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select * from student_details where Serial_No=?;");
			statement.setInt(1, serial_no);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				student.setSerialNo(result.getInt(1));
				student.setFullName(result.getString(2));
				student.setMotherName(result.getString(3));
				student.setFatherName(result.getString(4));
				student.setStandard(result.getString(5));
				student.setFees(result.getString(6));
				student.setContactNumber(result.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;
	}
}