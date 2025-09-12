package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.StudentAttendenceResponse;
import com.setmax.service.StudentAttendenceService;
import com.setmax.util.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/StudentAttendenceSearchServlet", "/searchStudentsForAttendence" })
public class StudentAttendenceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
			String standardId = request.getParameter("standardId");
			String attendenceDate = request.getParameter("attendenceDate");
			if (validateStandardId(standardId) && validateAttendenceDate(attendenceDate)) {
				StudentAttendenceService studentAttendenceService = new StudentAttendenceService();
				studentAttendenceResponse = studentAttendenceService
						.getStudentAttendenceRecordsByStandardAndDate(standardId, attendenceDate);
				if (studentAttendenceResponse.isStatus() && (studentAttendenceResponse.getErrors() == null
						|| studentAttendenceResponse.getErrors().isEmpty())) {
					out.println(writer.writeValueAsString(studentAttendenceResponse));
				} else {
					out.println(writer.writeValueAsString(studentAttendenceResponse));
				}
			} else {
				List<String> errors = new ArrayList<String>();
				errors.add(Constant.PROCESSING_ERROR);
				studentAttendenceResponse.setStatus(false);
				studentAttendenceResponse.setErrors(errors);
				out.println(writer.writeValueAsString(studentAttendenceResponse));
			}
		} catch (Exception e) {
			e.printStackTrace();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			out.println(writer.writeValueAsString(errors));
		}
	}

	private boolean validateStandardId(String standardId) {
		if (standardId == null || standardId.trim().isEmpty() || Integer.parseInt(standardId) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean validateAttendenceDate(String attendenceDate) {
		if (attendenceDate == null || attendenceDate.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
