package com.student.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.connector.ConnectionFactory;
import com.student.dto.Student;

public class StudentDAOImp implements StudentDAO
{

	private Connection con;     //DOUBT
	
	
	public StudentDAOImp() 
	{
	this.con = ConnectionFactory.requestConnection();    // used this to connection object to connect  globally 
	} 

	
	// insert student
	
	@Override
	public boolean insertStudent(Student s) {
		// JDBC logics for insert operation
		String query="INSERT INTO STUDENT VALUES (0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps=null;
		int res=0;
		try 
		{
			ps=con.prepareStatement(query);
			ps.setString(1,s.getNAME());
			ps.setLong(2,s.getPHONE());
			ps.setString(3, s.getMAILID());
			ps.setString(4, s.getBRANCH());
			ps.setString(5, s.getLOCATION());
			ps.setString(6, s.getPASSWORD());
			res=ps.executeUpdate();// result stores value whether the data inserted or not
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(res>0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
// update student
		
		@Override
			public boolean updateStudent(Student s) {
				String query = "UPDATE STUDENT SET NAME=?,PHONE=?,MAILID=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?";
				PreparedStatement ps = null;
				int res = 0;
				try {
					ps = con.prepareStatement(query);
					ps.setString(1, s.getNAME());
					ps.setLong(2, s.getPHONE());
					ps.setString(3, s.getMAILID());
					ps.setString(4, s.getBRANCH());
					ps.setString(5, s.getLOCATION());
					ps.setString(6, s.getPASSWORD());
					ps.setInt(7, s.getID());

					res = ps.executeUpdate();

				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				if (res > 0) {
					return true;
				} else {
					return false;
				}
			}
	

	// delete student 
	@Override
	public boolean deleteStudent(Student s) {
		// JDBC logics for delete operation
				String query="DELETE FROM STUDENT WHERE ID = ?";
     			PreparedStatement ps=null;
				int res=0;
				try 
				{
					ps=con.prepareStatement(query);
					ps.setInt(1,s.getID());
					res=ps.executeUpdate(); // result stores value whether the data deleted or not
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				if(res>0)
				{
					return true;
				}
				else
				{
				return false;
				}
			}

	// login valid or not
	@Override
	public Student getStudent(String MAILID, String PASS)
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE MAILID=? AND PASSWORD=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,MAILID);
			ps.setString(2, PASS);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setID(rs.getInt("id"));
				s.setNAME(rs.getString("name"));
				s.setPHONE(rs.getLong("phone"));
				s.setMAILID(rs.getString("mailid"));
				s.setBRANCH(rs.getString("branch"));
				s.setLOCATION(rs.getString("location"));
				s.setPASSWORD(rs.getString("password"));
				s.setDATE(rs.getString("date"));			
			}
		    } 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return s;
	}

	
	// to reterieve the data
	@Override
	public List<Student> getStudent()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		Student s=null;
		String query="SELECT * FROM STUDENT";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				//String name=rs.getString("name");
				//s.setName(name);
				s.setID(rs.getInt("id"));
				s.setNAME(rs.getString("name"));
				s.setPHONE(rs.getLong("phone"));
				s.setMAILID(rs.getString("mailid"));
				s.setBRANCH(rs.getString("branch"));
				s.setLOCATION(rs.getString("location"));
				s.setPASSWORD(rs.getString("password"));
				s.setDATE(rs.getString("date"));
				students.add(s);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return students;
	}


	@Override
	public Student getStudent(long PHONE, String MAILID) 
	{
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAILID=?";
		Student s=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, PHONE);
			ps.setString(2, MAILID);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				 //String name=rs.getString("name");
				 //s.setName(name);
				 s.setID(rs.getInt("id"));
				 s.setNAME(rs.getString("name"));
				 s.setPHONE(rs.getLong("phone"));
				 s.setMAILID(rs.getString("mailid"));
				 s.setBRANCH(rs.getString("branch"));
				 s.setLOCATION(rs.getString("location"));
				 s.setPASSWORD(rs.getString("password"));
				 s.setDATE(rs.getString("date"));
				 }
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		
		
		
		
		return s;
	}

}
