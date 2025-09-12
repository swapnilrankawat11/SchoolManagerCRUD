package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.StudentInfoDTO;
import com.setmax.response.StudentInfoResponse;
import com.setmax.service.StudentInfoService;
import com.setmax.validator.StudentInfoValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			String studentId = request.getParameter("studentId");
			if (!isValidStudentUserId(studentId)) {
				StudentInfoDTO studentInfoDTO = getStudentInfoData(request);

				StudentInfoValidator studentInfoValidator = new StudentInfoValidator();
				StudentInfoResponse response = studentInfoValidator.validateStudentInfo(studentInfoDTO);

				if (response.getErrors().isEmpty()) {
					StudentInfoService studentInfoService = new StudentInfoService();
					long id = studentInfoService.saveStudentInfo(studentInfoDTO);
					response.setId(id);
					response.setStatus(true);
				}
				out.println(writer.writeValueAsString(response));
			} else {
				StudentInfoDTO studentInfoDTO = getStudentInfoData(request);
				StudentInfoValidator studentInfoValidator = new StudentInfoValidator();
				StudentInfoResponse validationResponse = studentInfoValidator.validateEditedStudentInfo(studentInfoDTO);

				if (validationResponse.getErrors().isEmpty()) {
					StudentInfoService studentInfoService = new StudentInfoService();
					StudentInfoResponse studentInfoUpdateResponse = studentInfoService
							.updateStudentInfo(studentInfoDTO);
					if (studentInfoUpdateResponse.getErrors() == null
							|| studentInfoUpdateResponse.getErrors().isEmpty()) {
						out.println(writer.writeValueAsString(studentInfoUpdateResponse));
					} else {
						out.println(writer.writeValueAsString(studentInfoUpdateResponse));
					}

				} else {
					validationResponse.setStatus(false);
					out.println(writer.writeValueAsString(validationResponse));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			StudentInfoResponse response = new StudentInfoResponse();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
			out.println(writer.writeValueAsString(response));
		}
	}

	private StudentInfoDTO getStudentInfoData(HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		String standard = request.getParameter("standard");
		String studentUserId = request.getParameter("studentUserId");
		String favoriteSportId = request.getParameter("favoriteSport");
		String thirdLanguageId = request.getParameter("thirdLanguage");
		String guardianTypeId = request.getParameter("guardianType");
		String guardianUserId = request.getParameter("guardianUser");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		StudentInfoDTO studentInfoDTO = new StudentInfoDTO(standard, favoriteSportId, thirdLanguageId, guardianTypeId,
				guardianUserId, fatherName, motherName);
		if (isValidStudentUserId(studentUserId)) {
			studentInfoDTO.setStudentUserId(studentUserId);
		}
		if (isValidStudentUserId(studentId)) {
			studentInfoDTO.setId(Integer.parseInt(studentId));
		}
		return studentInfoDTO;
	}

	private boolean isValidStudentUserId(String studentUserId) {
		boolean isValid = false;
		if (studentUserId != null && !studentUserId.trim().isEmpty()) {
			isValid = true;
		}
		return isValid;
	}
}
