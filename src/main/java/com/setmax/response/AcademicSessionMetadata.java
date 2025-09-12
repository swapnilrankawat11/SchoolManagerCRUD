package com.setmax.response;

import java.util.List;

import com.setmax.dto.AcademicSessionDTO;
import com.setmax.dto.StandardDTO;

public class AcademicSessionMetadata {
	private List<AcademicSessionDTO> academicSessions;
	private List<StandardDTO> classes;

	public AcademicSessionMetadata() {

	}

	public AcademicSessionMetadata(List<AcademicSessionDTO> academicSessions, List<StandardDTO> classes) {
		this.academicSessions = academicSessions;
		this.classes = classes;
	}

	public List<AcademicSessionDTO> getAcademicSessions() {
		return academicSessions;
	}

	public void setAcademicSessions(List<AcademicSessionDTO> academicSessions) {
		this.academicSessions = academicSessions;
	}

	public List<StandardDTO> getClasses() {
		return classes;
	}

	public void setClasses(List<StandardDTO> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "AcademicSessionMetadata [academicSessions=" + academicSessions + ", classes=" + classes + "]";
	}

}
