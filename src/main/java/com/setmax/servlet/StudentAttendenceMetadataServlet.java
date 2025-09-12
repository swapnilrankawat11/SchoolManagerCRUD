package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.StudentAttendenceMetadata;
import com.setmax.service.StudentAttendenceMetadataService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/StudentAttendenceMetadataServlet", "/StudentAttendenceMetadata" })
public class StudentAttendenceMetadataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		StudentAttendenceMetadataService studentAttendenceMetadataService = new StudentAttendenceMetadataService();
		StudentAttendenceMetadata studentAttendenceMetadata = studentAttendenceMetadataService
				.getStudentAttendenceMetadata();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		out.println(writer.writeValueAsString(studentAttendenceMetadata));
	}

}
