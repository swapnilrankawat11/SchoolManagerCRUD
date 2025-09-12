package com.setmax.response;

import java.util.List;

import com.setmax.dto.UserStudentAttendenceDTO;
import com.setmax.dto.UserStudentDTO;

public class StudentAttendenceResponse {
	boolean status;
	List<UserStudentAttendenceDTO> studentAttendenceRecords;
	List<UserStudentDTO> studentsForAttendence;
	List<String> errors;

	public StudentAttendenceResponse() {
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<UserStudentAttendenceDTO> getStudentAttendenceRecords() {
		return studentAttendenceRecords;
	}

	public void setStudentAttendenceRecords(List<UserStudentAttendenceDTO> studentAttendenceRecords) {
		this.studentAttendenceRecords = studentAttendenceRecords;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<UserStudentDTO> getStudentsForAttendence() {
		return studentsForAttendence;
	}

	public void setStudentsForAttendence(List<UserStudentDTO> studentsForAttendence) {
		this.studentsForAttendence = studentsForAttendence;
	}

	@Override
	public String toString() {
		return "StudentAttendenceResponse [status=" + status + ", studentAttendenceRecords=" + studentAttendenceRecords
				+ ", studentsForAttendence=" + studentsForAttendence + ", errors=" + errors + "]";
	}

}
