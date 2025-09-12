package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.LoginUserDTO;
import com.setmax.response.AcademicSessionResponse;
import com.setmax.response.AcademicSessionStudentsResponse;
import com.setmax.service.StudentAcademicSessionService;
import com.setmax.util.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/StudentAcademicSessionServlet", "/AcademicSessionStudentsResponse" })
public class StudentAcademicSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String[] userIdArray = req.getParameterValues("userIdArray[]");
			AcademicSessionResponse academicSessionResponse = new AcademicSessionResponse();
			if (isValidUserIdArray(userIdArray)) {
				StudentAcademicSessionService studentAcademicSessionService = new StudentAcademicSessionService();
				LoginUserDTO loggedInUser = (LoginUserDTO) req.getSession().getAttribute("loggedInUser");
				academicSessionResponse = studentAcademicSessionService.saveStudentAcademicSession(userIdArray,
						loggedInUser.getId());
				if (academicSessionResponse.getStatus() && (academicSessionResponse.getErrors() == null
						|| academicSessionResponse.getErrors().isEmpty())) {
					out.println(writer.writeValueAsString(academicSessionResponse));
				} else {
					out.println(writer.writeValueAsString(academicSessionResponse));
				}
			} else {
				final String error = "Please check, uncheck a record to save or delete!";
				List<String> errors = new ArrayList<String>();
				errors.add(error);
				academicSessionResponse.setStatus(false);
				academicSessionResponse.setErrors(errors);
				out.println(writer.writeValueAsString(academicSessionResponse));
			}
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			out.println(writer.writeValueAsString(errors));
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String standardId = request.getParameter("standardId");
			String academicSessionId = request.getParameter("academicSessionId");
			AcademicSessionStudentsResponse academicSessionStudentsResponse = new AcademicSessionStudentsResponse();
			if (isValidStandardId(standardId) && isValidAcademicSessionId(academicSessionId)) {
				StudentAcademicSessionService academicSessionStudentsService = new StudentAcademicSessionService();
				academicSessionStudentsResponse = academicSessionStudentsService.getAcademicSessionStudents(
						Integer.parseInt(standardId), Integer.parseInt(academicSessionId));
				if (academicSessionStudentsResponse.getStatus()) {
					String academicSessionStudentsMetaData = writer.writeValueAsString(academicSessionStudentsResponse);
					out.println(academicSessionStudentsMetaData);
				} else {
					List<String> errors = new ArrayList<String>();
					errors.add(Constant.PROCESSING_ERROR);
					academicSessionStudentsResponse.setErrors(errors);
					String academicSessionStudentsMetaData = writer.writeValueAsString(academicSessionStudentsResponse);
					out.println(academicSessionStudentsMetaData);
				}
			} else {
				List<String> errors = new ArrayList<String>();
				errors.add(Constant.PROCESSING_ERROR);
				academicSessionStudentsResponse.setStatus(false);
				academicSessionStudentsResponse.setErrors(errors);
				String errorText = writer.writeValueAsString(errors);
				out.println(errorText);
			}

		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			out.println(writer.writeValueAsString(errors));
		}
	}

	private boolean isValidStandardId(String standardId) {
		if (standardId == null || standardId.trim().isEmpty() || Integer.parseInt(standardId) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isValidAcademicSessionId(String academicSessionId) {
		if (academicSessionId == null || academicSessionId.trim().isEmpty()
				|| Integer.parseInt(academicSessionId) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isValidUserIdArray(String[] userIdArray) {
		boolean isUserIdValid = false;
		if (userIdArray == null || userIdArray.length < 0) {
			isUserIdValid = false;
		} else {
			for (String userId : userIdArray) {
				if (userId == null || userId.trim().isEmpty()) {
					isUserIdValid = false;
				} else {
					isUserIdValid = true;
				}
			}
		}
		return isUserIdValid;
	}
}
