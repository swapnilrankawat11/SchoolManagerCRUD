package com.setmax.response;

import java.util.List;

public class AcademicSessionResponse {
	boolean status;
	List<String> errors;

	public AcademicSessionResponse() {
	}

	public AcademicSessionResponse(boolean status, List<String> errors) {
		this.status = status;
		this.errors = errors;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "AcademicSessionResponse [status=" + status + ", errors=" + errors + "]";
	}

}
