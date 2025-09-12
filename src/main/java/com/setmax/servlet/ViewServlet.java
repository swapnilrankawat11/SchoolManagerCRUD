package com.setmax.servlet;

import java.io.IOException;
import java.util.List;

import com.setmax.dto.StudentDetails;
import com.setmax.service.StudentDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDetailService service = new StudentDetailService();
		List<StudentDetails> list = service.showList();
		HttpSession session = request.getSession();
		session.setAttribute("savedStudentData", list);
		response.sendRedirect("ViewAllRecords.jsp");
	}
}