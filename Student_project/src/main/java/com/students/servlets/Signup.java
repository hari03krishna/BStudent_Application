package com.students.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAOImp;
import com.student.dao.StudentDAO;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/applicationform")
public class Signup extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		

		//collecting the data from user
		String name = req.getParameter("name");
		String phonenumber = req.getParameter("phone");
		String mail = req.getParameter("email");
		String branch = req.getParameter("branch");
		String location = req.getParameter("location");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirm_password");

		//converting String to long
		long phone = Long.parseLong(phonenumber);
		//PrintWriter out = resp.getWriter();

		//JDBC Implementation 
		Student s = new Student();
		StudentDAO sdao = new StudentDAOImp();
		if (password.equals(confirmpassword)) {
			s.setNAME(name);
			s.setPHONE(phone);
			s.setMAILID(mail);
			s.setBRANCH(branch);
			s.setLOCATION(location);
			s.setPASSWORD(password);

			boolean res = sdao.insertStudent(s);
			s=sdao.getStudent(mail, password);
			if (res == true) {
				
				//out.println("<h1>data added successfully your Student Id is:"+s.getId()+"</h1>");
				req.setAttribute("success", "signup successful");
				RequestDispatcher rd=req.getRequestDispatcher("applicationform.jsp");
				rd.forward(req, resp);
			} else {
				//out.println("<h1>failed to add</h1>");
				req.setAttribute("failure", "signup failed");
				RequestDispatcher rd=req.getRequestDispatcher("applicationform.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
