package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.TeacherInfoDTO;
import com.setmax.response.TeacherInfoResponse;
import com.setmax.service.TeacherInfoService;
import com.setmax.validator.TeacherInfoValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();

		try {
			String teacherId = request.getParameter("teacherId");
			if (!isValidTeacherUserId(teacherId)) {
				TeacherInfoDTO teacherInfoDTO = getTeacherInfoData(request);

				TeacherInfoValidator teacherInfoValidator = new TeacherInfoValidator();
				TeacherInfoResponse response = teacherInfoValidator.validateTeacherInfo(teacherInfoDTO);

				if (response.getErrors().isEmpty()) {
					TeacherInfoService teacherInfoService = new TeacherInfoService();
					long id = teacherInfoService.saveTeacherInfo(teacherInfoDTO);
					response.setId(id);
					response.setStatus(true);
				}
				out.println(writer.writeValueAsString(response));
			} else {
				TeacherInfoDTO teacherInfoDTO = getTeacherInfoData(request);
				TeacherInfoValidator teacherInfoValidator = new TeacherInfoValidator();
				TeacherInfoResponse validationResponse = teacherInfoValidator.validateEditedTeacherInfo(teacherInfoDTO);

				if (validationResponse.getErrors().isEmpty()) {
					TeacherInfoService teacherInfoService = new TeacherInfoService();
					TeacherInfoResponse teacherInfoUpdateResponse = teacherInfoService
							.updateTeacherInfo(teacherInfoDTO);
					if (teacherInfoUpdateResponse.getErrors() == null
							|| teacherInfoUpdateResponse.getErrors().isEmpty()) {
						out.println(writer.writeValueAsString(teacherInfoUpdateResponse));
					} else {
						out.println(writer.writeValueAsString(teacherInfoUpdateResponse));
					}

				} else {
					validationResponse.setStatus(false);
					out.println(writer.writeValueAsString(validationResponse));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			TeacherInfoResponse response = new TeacherInfoResponse();
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			response.setErrors(errors);
			out.println(writer.writeValueAsString(response));
		}
	}

	private TeacherInfoDTO getTeacherInfoData(HttpServletRequest request) {
		String teacherId = request.getParameter("teacherId");
		String teacherUserId = request.getParameter("teacherUserId");
		String primarySub = request.getParameter("primarySubject");
		String secondarySub = request.getParameter("secondarySubject");
		String experienceInYears = request.getParameter("experienceInYears");
		String experienceInMonths = request.getParameter("experienceInMonths");
		TeacherInfoDTO teacherInfoDTO = new TeacherInfoDTO(primarySub, secondarySub, experienceInYears,
				experienceInMonths);
		if (isValidTeacherUserId(teacherUserId)) {
			teacherInfoDTO.setTeacherUserId(teacherUserId);
		}
		if (isValidTeacherUserId(teacherId)) {
			teacherInfoDTO.setId(Integer.parseInt(teacherId));
		}
		return teacherInfoDTO;
	}

	private boolean isValidTeacherUserId(String teacherUserId) {
		boolean isValid = false;
		if (teacherUserId != null && !teacherUserId.trim().isEmpty()) {
			isValid = true;
		}
		return isValid;
	}
}
