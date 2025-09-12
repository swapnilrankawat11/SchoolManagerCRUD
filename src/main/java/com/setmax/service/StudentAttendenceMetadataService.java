package com.setmax.service;

import com.setmax.dto.AcademicSessionDTO;
import com.setmax.response.StudentAttendenceMetadata;
import com.setmax.util.DateUtil;

public class StudentAttendenceMetadataService {
	public StudentAttendenceMetadata getStudentAttendenceMetadata() {
		StandardService classService = new StandardService();
		AcademicSessionService academicSessionService = new AcademicSessionService();
		AcademicSessionDTO academicSessionDTO = academicSessionService.getCurrentAcademicSession();
		String[] currentAcademicSessionYears = new String[2];
		currentAcademicSessionYears[0] = String
				.valueOf(DateUtil.getYearFromDate(DateUtil.parseToDate(academicSessionDTO.getSessionStart())));
		currentAcademicSessionYears[1] = String
				.valueOf(DateUtil.getYearFromDate(DateUtil.parseToDate(academicSessionDTO.getSessionEnd())));
		StudentAttendenceMetadata studentAttendenceMetadata = new StudentAttendenceMetadata(
				classService.getAllClasses(), currentAcademicSessionYears);
		return studentAttendenceMetadata;
	}
}
