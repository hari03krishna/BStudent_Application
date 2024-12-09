package com.students.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dto.Student;
import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session=req.getSession();
		String mail=req.getParameter("email");
		String phonenumber=req.getParameter("phone");
		String new_pass=req.getParameter("new_password");
		String con_pass=req.getParameter("confirm_password");
		
		long phone=Long.parseLong(phonenumber);
		
		
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp();
		s=(Student)session.getAttribute("student");
		if(s!=null&&mail.equals(s.getMAILID())&&phone==s.getPHONE()&&new_pass.equals(con_pass))
		{
			s.setPASSWORD(new_pass);
			boolean res1=sdao.updateStudent(s);
			if(res1)
			{
				req.setAttribute("success", "Pin updated Successful");
				RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("failure", "Pin update Failed");
				RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, resp);
			}
		}
	}
}

