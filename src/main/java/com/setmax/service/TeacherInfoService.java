package com.setmax.service;

import com.setmax.dao.TeacherInfoDAO;
import com.setmax.dto.TeacherInfoDTO;
import com.setmax.response.TeacherInfoResponse;

public class TeacherInfoService {
	public long saveTeacherInfo(TeacherInfoDTO teacher) throws Exception {
		TeacherInfoDAO teacherInfoDAO = new TeacherInfoDAO();
		long id = teacherInfoDAO.saveTeacherInfo(teacher);
		return id;
	}

	public TeacherInfoResponse updateTeacherInfo(TeacherInfoDTO teacher) throws Exception {
		TeacherInfoDAO teacherInfoDAO = new TeacherInfoDAO();
		TeacherInfoResponse teacherInfoResponse = new TeacherInfoResponse();
		teacherInfoResponse.setId(teacher.getId());
		int recordDeleted = teacherInfoDAO.updateTeacherInfo(teacher);
		if (recordDeleted == 1) {
			teacherInfoResponse.setStatus(true);
		} else {
			teacherInfoResponse.setStatus(false);
		}
		return teacherInfoResponse;
	}

	public TeacherInfoDTO getTeacherDetail(int userId) {
		TeacherInfoDAO teacherInfoDAO = new TeacherInfoDAO();
		TeacherInfoDTO teacherInfo = teacherInfoDAO.findByUserId(userId);
		return teacherInfo;
	}
}
