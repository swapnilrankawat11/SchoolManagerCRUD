package com.setmax.service;

import java.util.List;

import com.setmax.dto.StandardDTO;
import com.setmax.dto.RecordStatusDTO;
import com.setmax.dto.SportDTO;
import com.setmax.dto.SubjectDTO;
import com.setmax.dto.UserTypeDTO;
import com.setmax.response.UserMetadata;

public class UserMetadataService {
	public UserMetadata getMetadata() {
		UserTypeService userTypeService = new UserTypeService();
		RecordStatusService recordStatusService = new RecordStatusService();
		SubjectService subjectService = new SubjectService();
		SportService sportService = new SportService();
		StandardService classService = new StandardService();
		UserMetadata userMetadata = new UserMetadata();

		List<UserTypeDTO> userTypeDTOList = userTypeService.getUserTypes();
		List<RecordStatusDTO> recordStatusDTOList = recordStatusService.getRecordStatus();
		List<SubjectDTO> subjectDTOList = subjectService.getSubjects();
		List<SportDTO> sportDTOList = sportService.getSports();
		List<StandardDTO> classDTOList = classService.getAllClasses();

		userMetadata.setUserTypes(userTypeDTOList);
		userMetadata.setRecordStatus(recordStatusDTOList);
		userMetadata.setSubjects(subjectDTOList);
		userMetadata.setSports(sportDTOList);
		userMetadata.setClasses(classDTOList);

		return userMetadata;
	}
}