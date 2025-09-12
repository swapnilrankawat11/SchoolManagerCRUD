package com.setmax.response;

import java.util.Arrays;
import java.util.List;

import com.setmax.dto.StandardDTO;

public class StudentAttendenceMetadata {
	private List<StandardDTO> classes;
	private String[] years;

	public StudentAttendenceMetadata() {
	}

	public StudentAttendenceMetadata(List<StandardDTO> classes, String[] years) {
		this.classes = classes;
		this.years = years;
	}

	public List<StandardDTO> getClasses() {
		return classes;
	}

	public void setClasses(List<StandardDTO> classes) {
		this.classes = classes;
	}

	public String[] getYears() {
		return years;
	}

	public void setYears(String[] years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return "StudentAttendenceMetadata [classes=" + classes + ", years=" + Arrays.toString(years) + "]";
	}

}
