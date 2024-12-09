package com.students.servlets;

import java.io.IOException;

import com.student.dao.StudentDAOImp;
import com.student.dao.StudentDAO;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Update")
public class Update extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String mailid=req.getParameter("mail");
		String branch=req.getParameter("branch");
		String locaton=req.getParameter("location");
		
		StudentDAO sdao=new StudentDAOImp();
		Student s=(Student)session.getAttribute("student");
		if(s!=null)
		{
			s.setNAME(name);
			s.setPHONE(phone);
			s.setMAILID(mailid);
			s.setBRANCH(branch);
			s.setLOCATION(locaton);
			boolean res1=sdao.updateStudent(s);
			if(res1)
			{
				req.setAttribute("success", "update Successful");
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("failure", "update failed");
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp);
			}
		}
		
		
		
		
	}
}