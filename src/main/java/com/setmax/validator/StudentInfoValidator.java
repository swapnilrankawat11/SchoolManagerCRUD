package com.setmax.validator;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dto.StudentInfoDTO;
import com.setmax.response.StudentInfoResponse;

public class StudentInfoValidator extends CommonValidator {
	private String STANDARD_MISSING = "Class can't be empty";
	private String FAV_SPORT_MISSING = "Favorite Sport can't be empty";
	private String THIRD_LANG_MISSING = "Third Language can't be empty";
	private String GUARDIAN_TYPE_MISSING = "Guardian Type can't be empty";
	private String GUARDIAN_USER_MISSING = "Guardian User can't be empty";
	private String FATHER_NAME_MISSING = "Father Name can't be empty";
	private String MOTHER_NAME_MISSING = "Mother Name can't be empty";
	private String FATHER_NAME_LIMIT = "Father Name can't exceed 256 characters";
	private String MOTHER_NAME_LIMIT = "Mother Name can't exceed 256 characters";
	private String STUDENT_USER_ID_MISSING = "Unable to process the student info, Kindly contact system admin";

	public StudentInfoResponse validateStudentInfo(StudentInfoDTO studentInfo) {
		List<String> errorList = new ArrayList<String>();
		StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
		validateStudentUserId(studentInfo.getStudentUserId(), errorList);
		validateStandardId(studentInfo.getStandardId(), errorList);
		validateFavSport(studentInfo.getFavoriteSportId(), errorList);
		validateThirdLanguage(studentInfo.getThirdLanguageId(), errorList);
		validateGuardianType(studentInfo.getGuardianTypeId(), errorList);
		validateGuardianUser(studentInfo.getGuardianUserId(), errorList);
		validateFatherName(studentInfo.getFatherName(), errorList);
		validateMotherName(studentInfo.getMotherName(), errorList);
		studentInfoResponse.setErrors(errorList);
		return studentInfoResponse;
	}

	public StudentInfoResponse validateEditedStudentInfo(StudentInfoDTO studentInfo) {
		List<String> errorList = new ArrayList<String>();
		StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
		validateStudentUserId(studentInfo.getStudentUserId(), errorList);
		validateFavSport(studentInfo.getFavoriteSportId(), errorList);
		validateGuardianType(studentInfo.getGuardianTypeId(), errorList);
		validateGuardianUser(studentInfo.getGuardianUserId(), errorList);
		studentInfoResponse.setErrors(errorList);
		return studentInfoResponse;
	}

	private void validateStandardId(String standardId, List<String> errorList) {
		if (isStringEmpty(standardId)) {
			errorList.add(STANDARD_MISSING);
		}
	}

	private void validateFavSport(String favSport, List<String> errorList) {
		if (isStringEmpty(favSport)) {
			errorList.add(FAV_SPORT_MISSING);
		}
	}

	private void validateThirdLanguage(String thirdLang, List<String> errorList) {
		if (isStringEmpty(thirdLang)) {
			errorList.add(THIRD_LANG_MISSING);
		}
	}

	private void validateGuardianType(String guardianType, List<String> errorList) {
		if (isStringEmpty(guardianType)) {
			errorList.add(GUARDIAN_TYPE_MISSING);
		}
	}

	private void validateGuardianUser(String guardianUser, List<String> errorList) {
		if (isStringEmpty(guardianUser)) {
			errorList.add(GUARDIAN_USER_MISSING);
		}
	}

	private void validateFatherName(String fatherName, List<String> errorList) {
		if (isStringEmpty(fatherName)) {
			errorList.add(FATHER_NAME_MISSING);
		} else if (isStringValid(fatherName)) {
			errorList.add(FATHER_NAME_LIMIT);
		}
	}

	private void validateMotherName(String motherName, List<String> errorList) {
		if (isStringEmpty(motherName)) {
			errorList.add(MOTHER_NAME_MISSING);
		} else if (isStringValid(motherName)) {
			errorList.add(MOTHER_NAME_LIMIT);
		}
	}

	private void validateStudentUserId(String studentUserId, List<String> errorList) {
		if (isStringEmpty(studentUserId)) {
			errorList.add(STUDENT_USER_ID_MISSING);
		} else if (Integer.parseInt(studentUserId) <= 0) {
			errorList.add(STUDENT_USER_ID_MISSING);
		}
	}
}