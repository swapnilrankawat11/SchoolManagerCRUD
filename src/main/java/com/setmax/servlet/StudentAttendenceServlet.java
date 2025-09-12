package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.LoginUserDTO;
import com.setmax.dto.StudentAttendenceDTO;
import com.setmax.response.StudentAttendenceResponse;
import com.setmax.service.StudentAttendenceService;
import com.setmax.service.UserService;
import com.setmax.util.Constant;
import com.setmax.util.DateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/StudentAttendenceServlet", "/saveStudentAttendence" })
public class StudentAttendenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		StudentAttendenceResponse studentAttendenceResponse = new StudentAttendenceResponse();
		try {
			if (validateStudentAttendenceParams(request)) {
				StudentAttendenceService studentAttendenceService = new StudentAttendenceService();
				if (studentAttendenceService.getStudentAttendenceRecordsByStandardAndAttendenceDate(
						Integer.parseInt(request.getParameter("standardId")), request.getParameter("attendenceDate"))
						.size() > 0) {
					studentAttendenceResponse = studentAttendenceService
							.updateStudentAttendence(getParameters(request));
					out.println(writer.writeValueAsString(studentAttendenceResponse));
				} else {
					studentAttendenceResponse = studentAttendenceService.saveStudentAttendence(getParameters(request));
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
			studentAttendenceResponse.setStatus(false);
			studentAttendenceResponse.setErrors(errors);
			out.println(writer.writeValueAsString(studentAttendenceResponse));
		}
	}

	private List<StudentAttendenceDTO> getParameters(HttpServletRequest req) {
		UserService userService = new UserService();
		LoginUserDTO loggedInUser = (LoginUserDTO) req.getSession().getAttribute("loggedInUser");
		List<StudentAttendenceDTO> studentAttendenceDTOList = new ArrayList<StudentAttendenceDTO>();
		for (int i = 0; i < userService
				.getAcademicSessionStudentsDataByStandardId(Integer.parseInt(req.getParameter("standardId")))
				.size(); i++) {
			StudentAttendenceDTO studentAttendenceData = new StudentAttendenceDTO();
			studentAttendenceData.setStandardId(req.getParameter("standardId"));
			studentAttendenceData
					.setAttendenceDate(DateUtil.parseToSqlDate(req.getParameter("attendenceDate")).toString());
			studentAttendenceData.setStudentUserId(req.getParameter("studentAttendence[" + i + "][userId]"));
			studentAttendenceData
					.setAttendenceStatus(req.getParameter("studentAttendence[" + i + "][attendenceStatus]"));
			studentAttendenceData.setAttendenceByUserId(String.valueOf(loggedInUser.getId()));
			studentAttendenceDTOList.add(studentAttendenceData);
		}
		return studentAttendenceDTOList;
	}

	private boolean validateStudentAttendenceParams(HttpServletRequest req) {
		boolean areValidSearchParams = true;
		try {
			String standardId = req.getParameter("standardId");
			String attendenceDate = req.getParameter("attendenceDate");
			if ((standardId == null || standardId.trim().isEmpty() || Integer.parseInt(standardId) < 1)
					|| (attendenceDate == null || attendenceDate.trim().isEmpty())) {
				areValidSearchParams = false;
			} else {
				UserService userService = new UserService();
				for (int i = 0; i < userService
						.getAcademicSessionStudentsDataByStandardId(Integer.parseInt(req.getParameter("standardId")))
						.size(); i++) {
					String userId = req.getParameter("studentAttendence[" + i + "][userId]");
					String attendenceStatus = req.getParameter("studentAttendence[" + i + "][attendenceStatus]");
					if ((userId == null || userId.trim().isEmpty() || Integer.parseInt(userId) < 1)
							|| (attendenceStatus == null || attendenceStatus.trim().isEmpty())) {
						areValidSearchParams = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			areValidSearchParams = false;
		}
		return areValidSearchParams;
	}
}
