package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.setmax.service.StudentDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sno = request.getParameter("serialNo");
		int serialNo = Integer.parseInt(sno);
		StudentDetailService studentDetailService = new StudentDetailService();
		int status = studentDetailService.delete(serialNo);

		PrintWriter writer = response.getWriter();
		if (status > 0) {
			response.sendRedirect("viewServlet");
		} else {
			writer.println("Sorry! Unable to delete record from database!");
		}
	}
}