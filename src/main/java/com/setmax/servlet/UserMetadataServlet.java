package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.UserMetadata;
import com.setmax.service.UserMetadataService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserMetadataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserMetadataService userMetadataService = new UserMetadataService();
		UserMetadata userMetadata = userMetadataService.getMetadata();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String userMetaData = writer.writeValueAsString(userMetadata);
		out.println(userMetaData);
	}
}