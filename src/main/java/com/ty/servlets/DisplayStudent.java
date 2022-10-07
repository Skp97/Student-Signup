package com.ty.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;

@WebServlet("/display")
public class DisplayStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<Student> list_student = dao.getAllStudents();
		req.setAttribute("list", list_student);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Display.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}