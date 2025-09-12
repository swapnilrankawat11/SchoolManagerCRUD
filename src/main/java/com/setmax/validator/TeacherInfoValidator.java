package com.setmax.validator;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.TeacherInfoDTO;
import com.setmax.response.TeacherInfoResponse;

public class TeacherInfoValidator extends CommonValidator {
	private String PRIMARY_SUB_MISSING = "Primary Subject can't be empty";
	private String SECONDAY_SUB_MISSING = "Seconday Subject can't be empty";
	private String EXPERIENCE_YEAR_MISSING = "Experience in years can't be empty";
	private String EXPERIENCE_MONTH_MISSING = "Experience in months can't be empty";
	private String TEACHER_USER_ID_MISSING = "Unable to process the teacher info, Kindly contact system admin";

	public TeacherInfoResponse validateTeacherInfo(TeacherInfoDTO teacherInfo) {
		List<String> errorList = new ArrayList<String>();
		TeacherInfoResponse teacherInfoResponse = new TeacherInfoResponse();
		validateTeacherUserId(teacherInfo.getTeacherUserId(), errorList);
		validatePrimarySubject(teacherInfo.getPrimarySubjectId(), errorList);
		validateSecondarySubject(teacherInfo.getSecondarySubjectId(), errorList);
		validateExperienceInYear(teacherInfo.getExperienceInYear(), errorList);
		validateExperienceInMonth(teacherInfo.getExperienceInMonth(), errorList);
		teacherInfoResponse.setErrors(errorList);
		return teacherInfoResponse;
	}

	public TeacherInfoResponse validateEditedTeacherInfo(TeacherInfoDTO teacherInfo) {
		List<String> errorList = new ArrayList<String>();
		TeacherInfoResponse teacherInfoResponse = new TeacherInfoResponse();
		validateTeacherUserId(teacherInfo.getTeacherUserId(), errorList);
		validateSecondarySubject(teacherInfo.getSecondarySubjectId(), errorList);
		validateExperienceInYear(teacherInfo.getExperienceInYear(), errorList);
		validateExperienceInMonth(teacherInfo.getExperienceInMonth(), errorList);
		teacherInfoResponse.setErrors(errorList);
		return teacherInfoResponse;
	}

	private void validatePrimarySubject(String primarySub, List<String> errorList) {
		if (isStringEmpty(primarySub)) {
			errorList.add(PRIMARY_SUB_MISSING);
		}
	}

	private void validateSecondarySubject(String secondarySub, List<String> errorList) {
		if (isStringEmpty(secondarySub)) {
			errorList.add(SECONDAY_SUB_MISSING);
		}
	}

	private void validateExperienceInYear(String experienceInYears, List<String> errorList) {
		if (isStringEmpty(experienceInYears)) {
			errorList.add(EXPERIENCE_YEAR_MISSING);
		}
	}

	private void validateExperienceInMonth(String experienceInMonths, List<String> errorList) {
		if (isStringEmpty(experienceInMonths)) {
			errorList.add(EXPERIENCE_MONTH_MISSING);
		}
	}

	private void validateTeacherUserId(String teacherUserId, List<String> errorList) {
		if (isStringEmpty(teacherUserId)) {
			errorList.add(TEACHER_USER_ID_MISSING);
		} else if (Integer.parseInt(teacherUserId) <= 0) {
			errorList.add(TEACHER_USER_ID_MISSING);
		}
	}
}
