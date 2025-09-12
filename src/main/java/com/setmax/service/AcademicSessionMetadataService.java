package com.setmax.service;

import com.setmax.response.AcademicSessionMetadata;

public class AcademicSessionMetadataService {
	public AcademicSessionMetadata getAcademicSessionMetadata() {
		AcademicSessionMetadata academicSessionMetadata = new AcademicSessionMetadata();
		AcademicSessionService academicSessionService = new AcademicSessionService();
		StandardService classService = new StandardService();
		academicSessionMetadata.setAcademicSessions(academicSessionService.getAllAcademicSessions());
		academicSessionMetadata.setClasses(classService.getAllClasses());
		return academicSessionMetadata;
	}
}
