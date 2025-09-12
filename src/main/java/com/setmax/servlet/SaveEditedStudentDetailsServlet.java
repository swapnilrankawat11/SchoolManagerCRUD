package com.setmax.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.setmax.dto.StudentDetails;
import com.setmax.service.StudentDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveEditedStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sno = request.getParameter("serialNo");
		int serialNo = Integer.parseInt(sno);

		String fullname, mothername, fathername, phoneno, fees, standard;

		fullname = request.getParameter("fullName");
		mothername = request.getParameter("motherName");
		fathername = request.getParameter("fatherName");
		phoneno = request.getParameter("contactNumber");
		fees = request.getParameter("fees");
		standard = request.getParameter("standard");
		StudentDetails student = new StudentDetails(serialNo, fullname, mothername, fathername, standard, fees,
				phoneno);
		PrintWriter writer = response.getWriter();
		StudentDetailService studentDetailService = new StudentDetailService();
		int status = studentDetailService.update(student);

		if (status > 0) {
			response.sendRedirect("viewServlet");
		} else {
			writer.println("Unable to save record in database!");
		}
	}
}