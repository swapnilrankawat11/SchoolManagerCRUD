package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.UserDTO;
import com.setmax.response.UserInfoResponse;
import com.setmax.response.UserResponse;
import com.setmax.service.UserService;
import com.setmax.validator.UserInfoValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String userId = request.getParameter("userId");
			if (!isValidUserId(userId)) {
				UserDTO userDTO = getUserInfoData(request);
				UserInfoValidator userInfoValidator = new UserInfoValidator();
				UserInfoResponse response = userInfoValidator.validateUserInfo(userDTO);

				if (response.getErrors().isEmpty()) {
					UserService userService = new UserService();
					long id = userService.saveUserInfo(userDTO);
					response.setId(id);
					response.setStatus(true);
				}
				out.println(writer.writeValueAsString(response));

			} else {
				UserDTO userDTO = getUserInfoData(request);
				UserInfoValidator userInfoValidator = new UserInfoValidator();
				UserInfoResponse validationResponse = userInfoValidator.validateEditedUserInfo(userDTO);

				if (validationResponse.getErrors().isEmpty()) {
					UserService userService = new UserService();
					UserInfoResponse userInfoUpdateResponse = userService.saveEditedUserInfo(userDTO);
					if (userInfoUpdateResponse.getErrors() == null || userInfoUpdateResponse.getErrors().isEmpty()) {
						out.println(writer.writeValueAsString(userInfoUpdateResponse));
					} else {
						out.println(writer.writeValueAsString(userInfoUpdateResponse));
					}

				} else {
					validationResponse.setStatus(false);
					out.println(writer.writeValueAsString(validationResponse));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			UserInfoResponse response = new UserInfoResponse();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
			out.println(writer.writeValueAsString(response));

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		String userId = req.getParameter("userId");
		UserInfoValidator userInfoValidator = new UserInfoValidator();
		UserInfoResponse response = userInfoValidator.validateUserId(userId);

		if (response.getErrors().isEmpty()) {
			UserService userService = new UserService();
			UserResponse userResponse = userService.getAllEditUserDetails(userId);
			out.println(writer.writeValueAsString(userResponse));
		} else {
			response.setId(Integer.parseInt(userId));
			response.setStatus(false);
			out.println(writer.writeValueAsString(response));
		}
	}

	private UserDTO getUserInfoData(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userTypeId = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String mobileNumber = request.getParameter("mobileNumber");
		String address = request.getParameter("address");
		String recordStatusId = request.getParameter("recordStatus");
		UserDTO userDTO = new UserDTO(userTypeId, userName, firstName, middleName, lastName, dateOfBirth, email, gender,
				mobileNumber, address, recordStatusId);
		if (isValidUserId(userId)) {
			userDTO.setId(Integer.parseInt(userId));
		}
		return userDTO;
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String userId = req.getParameter("userId");
			UserInfoValidator userInfoValidator = new UserInfoValidator();
			UserInfoResponse validationResponse = userInfoValidator.validateUserId(userId);
			if (validationResponse.getErrors().isEmpty()) {
				UserService userService = new UserService();
				UserInfoResponse userInfoDeleteResponse = userService.deleteUser(userId);
				if (userInfoDeleteResponse.getErrors() == null || userInfoDeleteResponse.getErrors().isEmpty()) {
					out.println(writer.writeValueAsString(userInfoDeleteResponse));
				} else {
					out.println(writer.writeValueAsString(userInfoDeleteResponse));
				}
			} else {
				validationResponse.setStatus(false);
				out.println(writer.writeValueAsString(validationResponse));
			}
		} catch (Exception e) {
			UserInfoResponse response = new UserInfoResponse();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
			out.println(writer.writeValueAsString(response));
		}
	}

	private boolean isValidUserId(String userId) {
		boolean isValid = false;
		if (userId != null && !userId.trim().isEmpty()) {
			isValid = true;
		}
		return isValid;
	}
}