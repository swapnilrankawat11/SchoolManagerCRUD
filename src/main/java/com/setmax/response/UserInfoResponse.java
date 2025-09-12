package com.setmax.response;

import java.util.List;

public class UserInfoResponse {
	private long id;
	private boolean status;
	private List<String> errors;

	public UserInfoResponse() {
	}

	public UserInfoResponse(long id, boolean status, List<String> errors) {
		this.id = id;
		this.status = status;
		this.errors = errors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isStatus() {
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

}
