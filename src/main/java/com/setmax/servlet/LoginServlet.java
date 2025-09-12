package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.setmax.dto.LoginDetails;
import com.setmax.dto.LoginUserDTO;
import com.setmax.response.LoginJsonResponse;
import com.setmax.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDetails loginDetails = new LoginDetails(username, password);
		LoginService login = new LoginService();

		LoginJsonResponse loginResult = login.isValidated(loginDetails);
		LoginUserDTO user = login.getLoggedInUserData();

		request.getSession().setAttribute("loggedInUser", user);
		PrintWriter out = response.getWriter();
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String loginVerify = writer.writeValueAsString(loginResult);
		out.println(loginVerify);
	}
}