package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.UserFilteredViaUserTypeResponse;
import com.setmax.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserFilteredViaUserTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String guardianTypeId = request.getParameter("guardianType");
		UserService userService = new UserService();
		UserFilteredViaUserTypeResponse usersNameList = userService.getUsersName(guardianTypeId);
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String usersName = writer.writeValueAsString(usersNameList);
		out.println(usersName);
	}
}