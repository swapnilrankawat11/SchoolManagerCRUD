package com.setmax.response;

import java.util.List;

import com.setmax.dto.UserStudentDTO;

public class AcademicSessionStudentsResponse {
	boolean status;
	List<UserStudentDTO> students;
	List<String> errors;

	public AcademicSessionStudentsResponse() {
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<UserStudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<UserStudentDTO> students) {
		this.students = students;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
