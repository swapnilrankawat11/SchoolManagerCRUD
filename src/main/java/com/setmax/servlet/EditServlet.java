package com.setmax.servlet;

import java.io.IOException;

import com.setmax.dto.StudentDetails;
import com.setmax.service.StudentDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sno = request.getParameter("serialNo");
		int serialNo = Integer.parseInt(sno);
		request.getSession().setAttribute("serialNo", sno);
		StudentDetailService studentDetailService = new StudentDetailService();
		StudentDetails existingStudent = studentDetailService.getStudentData(serialNo);
		
		request.getSession().setAttribute("existingStudentData", existingStudent);
		response.sendRedirect("EditExistingStudentForm.jsp");
	}
}