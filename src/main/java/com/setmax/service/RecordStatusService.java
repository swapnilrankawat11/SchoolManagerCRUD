package com.setmax.service;

import java.util.List;

import com.setmax.dao.RecordStatusDAO;
import com.setmax.dto.RecordStatusDTO;

public class RecordStatusService {
	public List<RecordStatusDTO> getRecordStatus() {
		RecordStatusDAO recordStatusDAO = new RecordStatusDAO();
		List<RecordStatusDTO> recordStatusList = recordStatusDAO.getRecordStatus();
		return recordStatusList;
	}
}
