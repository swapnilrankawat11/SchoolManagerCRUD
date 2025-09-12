package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.AcademicSessionMetadata;
import com.setmax.service.AcademicSessionMetadataService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/AcademicSessionMetadataServlet", "/academicSessionMetadata" })
public class AcademicSessionMetadataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		AcademicSessionMetadataService academicSessionMetadataService = new AcademicSessionMetadataService();
		AcademicSessionMetadata academicSessionMetadata = academicSessionMetadataService.getAcademicSessionMetadata();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String academicSessionMetaData = writer.writeValueAsString(academicSessionMetadata);
		out.println(academicSessionMetaData);
	}

}
