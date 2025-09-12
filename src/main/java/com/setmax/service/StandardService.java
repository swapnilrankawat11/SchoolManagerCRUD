package com.setmax.service;

import java.util.List;

import com.setmax.dao.StandardDAO;
import com.setmax.dto.StandardDTO;

public class StandardService {
	public List<StandardDTO> getAllClasses() {
		StandardDAO standardDAO = new StandardDAO();
		List<StandardDTO> classes = standardDAO.getAllClasses();
		for (StandardDTO standard : classes) {
			standard.setStandardName(
					getStandardName(String.valueOf(standard.getStandard()), standard.getStandardSuffix()));
		}
		return classes;
	}

	public StandardDTO getStandardDetail(int standardId) {
		StandardDAO standardDAO = new StandardDAO();
		StandardDTO standardDTO = standardDAO.findById(standardId);
		standardDTO.setStandardName(
				getStandardName(String.valueOf(standardDTO.getStandard()), standardDTO.getStandardSuffix()));
		return standardDTO;
	}

	public String getStandardName(String standard, String standardSuffix) {
		String standardName = null;
		if (standardSuffix == null || standardSuffix.trim().isEmpty()) {
			standardName = standard;
		} else {
			standardName = standard + " " + standardSuffix;
		}
		return standardName;
	}
}
