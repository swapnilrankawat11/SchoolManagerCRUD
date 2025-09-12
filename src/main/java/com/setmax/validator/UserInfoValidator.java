package com.setmax.validator;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import com.setmax.dao.UserDAO;
import com.setmax.dto.UserDTO;
import com.setmax.response.UserInfoResponse;
import com.setmax.util.DateUtil;

public class UserInfoValidator extends CommonValidator {
	private String USR_TYP_MISSING = "User Type can't be empty";
	private String USR_NAME_MISSING = "Username can't be empty";
	private String USR_NAME_NOT_AVBL = "This username is not available";
	private String FIRST_NAME_MISSING = "First Name  can't be empty";
	private String LAST_NAME_MISSING = "Last Name can't be empty";
	private String DOB_MISSING = "Date of Birth can't be empty";
	private String DOB_NOT_VALID = "Enter a valid date";
	private String EMAIL_MISSING = "Email can't be empty";
	private String EMAIL_NOT_AVBL = "This email is not available";
	private String GENDER_MISSING = "Gender can't be empty";
	private String MOBILE_NUMBER_MISSING = "Mobile Number can't be empty";
	private String MBL_NUM_NOT_VALID = "Mobile Number must consist 10 digits only";
	private String ADDRESS_MISSING = "Address can't be empty";
	private String RECORD_ID_MISSING = "Record Status can't be empty";
	private String USR_NAME_LIMIT = "Username can't exceed 256 characters";
	private String FIRST_NAME_LIMIT = "First Name can't exceed 256 characters";
	private String MIDDLE_NAME_LIMIT = "Middle Name can't exceed 256 characters";
	private String LAST_NAME_LIMIT = "Last Name can't exceed 256 characters";
	private String EMAIL_LIMIT = "Email can't exceed 256 characters";
	private String ADDRESS_LIMIT = "Address can't exceed 256 characters";
	private String INVALID_USER_ID = "Unable to process your request. Kindly contact system admin";

	public UserInfoResponse validateUserInfo(UserDTO user) {
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		List<String> errorList = new ArrayList<String>();
		validateUserTypeId(user.getUserTypeId(), errorList);
		validateUsername(user.getUserName(), errorList);
		validateFirstName(user.getFirstName(), errorList);
		validateMiddleName(user.getMiddleName(), errorList);
		validateLastName(user.getLastName(), errorList);
		validatedateOfBirth(user.getDateOfBirth(), errorList);
		validateEmail(user.getEmail(), errorList);
		validateGender(user.getGender(), errorList);
		validateMobileNumber(user.getMobileNumber(), errorList);
		validateDateOfBirth(user.getDateOfBirth(), errorList);
		validateAddress(user.getAddress(), errorList);
		validateRecordStatusId(user.getRecordStatusId(), errorList);
		userInfoResponse.setErrors(errorList);
		return userInfoResponse;
	}

	public UserInfoResponse validateEditedUserInfo(UserDTO user) {
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		List<String> errorList = new ArrayList<String>();
		validateUserId(user.getId(), errorList);
		validateMobileNumber(user.getMobileNumber(), errorList);
		validateAddress(user.getAddress(), errorList);
		validateRecordStatusId(user.getRecordStatusId(), errorList);
		userInfoResponse.setErrors(errorList);
		return userInfoResponse;
	}

	private void validateUserId(int userId, List<String> errorList) {
		if (isStringEmpty(String.valueOf(userId))) {
			errorList.add(INVALID_USER_ID);
		} else if (userId <= 0) {
			errorList.add(INVALID_USER_ID);
		}
	}

	private void validateUserTypeId(String userTypeId, List<String> errorList) {
		if (isStringEmpty(userTypeId)) {
			errorList.add(USR_TYP_MISSING);
		}
	}

	private void validateUsername(String username, List<String> errorList) {
		if (isStringEmpty(username)) {
			errorList.add(USR_NAME_MISSING);
		} else {
			if (isStringValid(username)) {
				errorList.add(USR_NAME_LIMIT);
			} else {
				UserDAO userDAO = new UserDAO();
				boolean isNotValidUserName = userDAO.getAllUsername(username);
				if (isNotValidUserName) {
					errorList.add(USR_NAME_NOT_AVBL);
				}
			}
		}
	}

	private void validateFirstName(String firstName, List<String> errorList) {
		if (isStringEmpty(firstName)) {
			errorList.add(FIRST_NAME_MISSING);
		} else if (isStringValid(firstName)) {
			errorList.add(FIRST_NAME_LIMIT);
		}
	}

	private void validateMiddleName(String middleName, List<String> errorList) {
		if (isStringEmpty(middleName)) {
			if (isStringValid(middleName)) {
				errorList.add(MIDDLE_NAME_LIMIT);
			}
		}
	}

	private void validateLastName(String lastName, List<String> errorList) {
		if (isStringEmpty(lastName)) {
			errorList.add(LAST_NAME_MISSING);
		} else if (isStringValid(lastName)) {
			errorList.add(LAST_NAME_LIMIT);
		}
	}

	private void validatedateOfBirth(String dob, List<String> errorList) {
		if (isStringEmpty(dob)) {
			errorList.add(DOB_MISSING);
		}
	}

	private void validateEmail(String email, List<String> errorList) {
		if (isStringEmpty(email)) {
			errorList.add(EMAIL_MISSING);
		} else {
			if (isStringValid(email)) {
				errorList.add(EMAIL_LIMIT);
			} else {
				UserDAO userDAO = new UserDAO();
				boolean isNotValidEmail = userDAO.getAllEmail(email);
				if (isNotValidEmail) {
					errorList.add(EMAIL_NOT_AVBL);
				}
			}
		}
	}

	private void validateGender(String gender, List<String> errorList) {
		if (isStringEmpty(gender)) {
			errorList.add(GENDER_MISSING);
		}
	}

	private void validateMobileNumber(String mobileNumber, List<String> errorList) {
		if (isStringEmpty(mobileNumber)) {
			errorList.add(MOBILE_NUMBER_MISSING);
		} else {
			if (mobileNumber.length() != 10) {
				errorList.add((MBL_NUM_NOT_VALID));
			}
		}
	}

	private void validateAddress(String address, List<String> errorList) {
		if (isStringEmpty(address)) {
			errorList.add(ADDRESS_MISSING);
		} else if (isStringValid(address)) {
			errorList.add(ADDRESS_LIMIT);
		}
	}

	private void validateDateOfBirth(String dob, List<String> errorList) {
		if (isStringEmpty(dob)) {
			errorList.add(DOB_MISSING);
		} else {
			Date date = DateUtil.parseToDate(dob);
			if (date == null) {
				errorList.add(DOB_NOT_VALID);
			} else {
				Date currentDate = new Date();
				long dobTimeMilli = date.getTime();
				long currentTimeMilli = currentDate.getTime();
				if (dobTimeMilli < 0) {
					errorList.add(DOB_NOT_VALID);
				} else {
					if (dobTimeMilli > currentTimeMilli) {
						errorList.add(DOB_NOT_VALID);
					}
				}
			}
		}
	}

	private void validateRecordStatusId(String recordStatusId, List<String> errorList) {
		if (isStringEmpty(recordStatusId)) {
			errorList.add(RECORD_ID_MISSING);
		}
	}

	public UserInfoResponse validateUserId(String id) {
		List<String> errorList = new ArrayList<String>();
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		if (isStringEmpty(id)) {
			errorList.add(INVALID_USER_ID);
		} else if (Integer.parseInt(id) <= 0) {
			errorList.add(INVALID_USER_ID);
		}
		userInfoResponse.setErrors(errorList);
		return userInfoResponse;
	}
}