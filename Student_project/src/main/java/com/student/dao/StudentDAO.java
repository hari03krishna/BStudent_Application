package com.student.dao;

import java.util.List;

import com.student.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String PASSWORD);  // USED THIS TO TAKE SPECIFIC DATA FROM THE DTO CLASS.
	public List<Student> getStudent(); // USED THIS TO TAKE MULTIPLE OR ALL DATA 
	public Student getStudent(long PHONE, String MAILID);
}
