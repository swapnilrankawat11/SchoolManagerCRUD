package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.StudentAttendenceSearchParamsDTO;
import com.setmax.response.StudentAttendenceResponse;
import com.setmax.service.StudentAttendenceService;
import com.setmax.util.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentAttendenceRecordSearchServlet")
public class StudentAttendenceRecordSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
			if (isValidAttendenceYear(request.getParameter("attendenceYear"))
					&& isValidStandardId(request.getParameter("attendenceOfClass"))) {
				StudentAttendenceService studentAttendenceService = new StudentAttendenceService();
				studentAttendenceResponse = studentAttendenceService
						.getStudentAttendenceRecordsBySearchParams(getParameters(request));
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

	private boolean isValidStandardId(String standardId) {
		if (standardId == null || standardId.trim().isEmpty() || Integer.parseInt(standardId) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isValidAttendenceYear(String attendenceYear) {
		if (attendenceYear == null || attendenceYear.trim().isEmpty() || Integer.parseInt(attendenceYear) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private StudentAttendenceSearchParamsDTO getParameters(HttpServletRequest request) {
		StudentAttendenceSearchParamsDTO studentAttendenceSearchParamsDTO = new StudentAttendenceSearchParamsDTO();
		studentAttendenceSearchParamsDTO.setAttendenceYear(request.getParameter("attendenceYear"));
		studentAttendenceSearchParamsDTO.setAttendenceMonth(request.getParameter("attendenceMonth"));
		studentAttendenceSearchParamsDTO.setAttendenceDay(request.getParameter("attendenceDay"));
		studentAttendenceSearchParamsDTO.setAttendenceByStandardId(request.getParameter("attendenceOfClass"));
		studentAttendenceSearchParamsDTO.setStudentInfo(request.getParameter("studentInfo"));
		studentAttendenceSearchParamsDTO.setTeacherInfo(request.getParameter("teacherInfo"));
		return studentAttendenceSearchParamsDTO;
	}
}
