package com.setmax.service;

import java.util.List;

import com.setmax.dao.UserTypeDAO;
import com.setmax.dto.UserTypeDTO;

public class UserTypeService {
	public List<UserTypeDTO> getUserTypes() {
		UserTypeDAO userTypeDAO = new UserTypeDAO();
		List<UserTypeDTO> userTypesList = userTypeDAO.getUserTypes();
		return userTypesList;
	}
}
