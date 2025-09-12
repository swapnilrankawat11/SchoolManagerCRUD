package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.response.UserListResponse;
import com.setmax.service.ServeUserDetail;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ServeUserDetail user = new ServeUserDetail();
		
		UserListResponse list = user.getListOfUsers();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String users = writer.writeValueAsString(list);
		out.println(users);
	}
}