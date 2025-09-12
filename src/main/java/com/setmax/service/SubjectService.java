package com.setmax.service;

import java.util.List;

import com.setmax.dao.SubjectDAO;
import com.setmax.dto.SubjectDTO;

public class SubjectService {
	public List<SubjectDTO> getSubjects() {
		SubjectDAO subjectDAO = new SubjectDAO();
		List<SubjectDTO> subjectsList = subjectDAO.getSubjects();
		return subjectsList;
	}
}