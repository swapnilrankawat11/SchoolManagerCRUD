package com.setmax.service;

import java.util.List;

import com.setmax.dao.AcademicSessionDAO;
import com.setmax.dto.AcademicSessionDTO;

public class AcademicSessionService {
	public AcademicSessionDTO getCurrentAcademicSession() {
		AcademicSessionDAO academicSessionDAO = new AcademicSessionDAO();
		return academicSessionDAO.getCurrentAcademicSession();
	}

	public List<AcademicSessionDTO> getAllAcademicSessions() {
		AcademicSessionDAO academicSessionDAO = new AcademicSessionDAO();
		return academicSessionDAO.getAllAcademicSession();
	}

}