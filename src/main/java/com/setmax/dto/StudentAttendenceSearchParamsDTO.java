package com.setmax.dto;

public class StudentAttendenceSearchParamsDTO {
	private String attendenceYear;
	private String attendenceMonth;
	private String attendenceDay;
	private String attendenceByStandardId;
	private String studentInfo;
	private String teacherInfo;

	public StudentAttendenceSearchParamsDTO() {
	}

	public StudentAttendenceSearchParamsDTO(String attendenceYear, String attendenceMonth, String attendenceDay,
			String attendenceByStandardId, String studentInfo, String teacherInfo) {
		this.attendenceYear = attendenceYear;
		this.attendenceMonth = attendenceMonth;
		this.attendenceDay = attendenceDay;
		this.attendenceByStandardId = attendenceByStandardId;
		this.studentInfo = studentInfo;
		this.teacherInfo = teacherInfo;
	}

	public String getAttendenceYear() {
		return attendenceYear;
	}

	public void setAttendenceYear(String attendenceYear) {
		this.attendenceYear = attendenceYear;
	}

	public String getAttendenceMonth() {
		return attendenceMonth;
	}

	public void setAttendenceMonth(String attendenceMonth) {
		this.attendenceMonth = attendenceMonth;
	}

	public String getAttendenceDay() {
		return attendenceDay;
	}

	public void setAttendenceDay(String attendenceDay) {
		this.attendenceDay = attendenceDay;
	}

	public String getAttendenceByStandardId() {
		return attendenceByStandardId;
	}

	public void setAttendenceByStandardId(String attendenceByStandardId) {
		this.attendenceByStandardId = attendenceByStandardId;
	}

	public String getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(String studentInfo) {
		this.studentInfo = studentInfo;
	}

	public String getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(String teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	@Override
	public String toString() {
		return "StudentAttendenceSearchParamsDTO [attendenceYear=" + attendenceYear + ", attendenceMonth="
				+ attendenceMonth + ", attendenceDay=" + attendenceDay + ", attendenceByStandardId="
				+ attendenceByStandardId + ", studentInfo=" + studentInfo + ", teacherInfo=" + teacherInfo + "]";
	}

}
