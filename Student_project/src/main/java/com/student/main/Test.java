package com.student.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

public class Test {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
	    Student s= new Student();
		StudentDAO sdao=new StudentDAOImp();
	
		// collecting the data from the user
		 System.out.println("enter the student name ");
	     String NAME = sc.next(); 
	     // to set the values collected from the user to the POJO class object using setter
	     s.setNAME(NAME);
	     
	     System.out.println("enter the student phone number");
	     long PHONENUMBER=sc.nextLong();    // s.setPHONENUMBER(sc.nextLong());
	     s.setPHONE(PHONENUMBER);
	     
	     System.out.println("enter the mail id");
	     String MAILID=sc.next();
	     s.setMAILID(MAILID);
	     
	     System.out.println("enter the branch");
	     String BRANCH=sc.next();
	     s.setBRANCH(BRANCH);
	     
	     System.out.println("enter the location");
	     String LOCATION=sc.next();
	     s.setLOCATION(LOCATION);
	     
	     System.out.println("set a password");
	     String PASS=sc.next();
	     
	     System.out.println("confirm the password");
	     String confirmPassword=sc.next();
	   
	     if(PASS.equals(confirmPassword))
	     {
	    	 s.setPASSWORD(PASS);
	    	 boolean result=sdao.insertStudent(s);
	    	 if(result)
	    	 {
	    		 System.out.println("data added sucessfully");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("data not added");
	    	 }
	     }
	     // deleting the data
	     System.out.println("Enter the student id to be deleted");
	     int ID=sc.nextInt();
	     s.setID(ID);
		if(ID == (ID))
		{
		s.setID(ID);	
		boolean result=sdao.deleteStudent(s);
		if(result)
		{
			System.out.println(" id deleted sucessfully");
		}
		else
		{
			System.out.println(" id not deleted");
		}
		}
		
		
		// retrieving the data
		
		List<Student> studentsList=sdao.getStudent();
		Iterator<Student> it = studentsList.iterator();
		while(it.hasNext())
		{
			Student s1=it.next();
			System.out.println(s1);
		}
		
		
		
		System.out.println("enter the mail id");
		String mailid=sc.next();
		System.out.println("enter the password");
		String password=sc.next();
		Student s1=sdao.getStudent(mailid, password);
		if(s1!=null)
		{
			System.out.println(s1);
		}
		else
		{
			System.out.println("invalid mailid or password ");
		}
	}

}
