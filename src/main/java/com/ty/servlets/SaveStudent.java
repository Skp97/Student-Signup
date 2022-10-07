package com.ty.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.StudentDAO;
import com.ty.dto.Student;
@WebServlet("/save")
public class SaveStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String address=req.getParameter("address");
		long phoneno=Long.parseLong(req.getParameter("phoneno"));
		String email=req.getParameter("email");
		
		Student student=new Student();
		student.setName(name);
		student.setAge(age);
		student.setAddress(address);
		student.setPhoneno(phoneno);
		student.setEmail(email);
		
		StudentDAO dao=new StudentDAO();
		dao.saveStudents(student);
		
		req.setAttribute("message", "sucessfully saved");
		RequestDispatcher dispatcher=req.getRequestDispatcher("/display");
		dispatcher.forward(req, resp);
		
	}
}