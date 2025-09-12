package com.setmax.service;

import java.util.List;

import com.setmax.dao.SportDAO;
import com.setmax.dto.SportDTO;

public class SportService {
	public List<SportDTO> getSports() {
		SportDAO sportDAO = new SportDAO();
		List<SportDTO> sportsList = sportDAO.getSports();
		return sportsList;
	}
}