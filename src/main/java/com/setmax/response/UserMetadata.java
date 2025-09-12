package com.setmax.response;

import java.util.List;

import com.setmax.dto.StandardDTO;
import com.setmax.dto.RecordStatusDTO;
import com.setmax.dto.SportDTO;
import com.setmax.dto.SubjectDTO;
import com.setmax.dto.UserTypeDTO;

public class UserMetadata {
	private List<UserTypeDTO> userTypes;
	private List<RecordStatusDTO> recordStatus;
	private List<SubjectDTO> subjects;
	private List<SportDTO> sports;
	private List<StandardDTO> classes;

	public UserMetadata() {
	}

	public UserMetadata(List<UserTypeDTO> userTypes, List<SubjectDTO> subjects, List<SportDTO> sports,
			List<StandardDTO> classes) {
		this.userTypes = userTypes;
		this.subjects = subjects;
		this.sports = sports;
		this.classes = classes;
	}

	public List<UserTypeDTO> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserTypeDTO> userTypes) {
		this.userTypes = userTypes;
	}

	public List<RecordStatusDTO> getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(List<RecordStatusDTO> recordStatus) {
		this.recordStatus = recordStatus;
	}

	public List<SubjectDTO> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}

	public List<SportDTO> getSports() {
		return sports;
	}

	public void setSports(List<SportDTO> sports) {
		this.sports = sports;
	}

	public List<StandardDTO> getClasses() {
		return classes;
	}

	public void setClasses(List<StandardDTO> classes) {
		this.classes = classes;
	}

}