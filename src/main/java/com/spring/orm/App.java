package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
      StudentDao dao=context.getBean("studentDao",StudentDao.class);
      
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      boolean go=true;
      while(go)
      {
      System.out.println("PRESS 1 FOR ADD NEW STUDENT");
      System.out.println("PRESS 2 FOR DISPLAY ALL STUDENTS");
      System.out.println("PRESS 3 FOR GET DETAIL OF SINGLE STUDENT");
      System.out.println("PRESS 4 FOR DELETE THE STUDENT");
      System.out.println("PRESS 5 FOR DELETE THE STUDENT");
      System.out.println("PRESS 6 FOR EXIT");
      
      try
      {
        int input=Integer.parseInt(br.readLine());
        switch(input)
        {
        case 1:
        	//add a new student
        	System.out.println("Enter Student Id:");
        	int sId=Integer.parseInt(br.readLine());
        	
        	System.out.println("Enter Student Name:");
        	String sName=br.readLine();
        	
        	System.out.println("Enter Student City:");
        	String sCity=br.readLine();
        	
        	Student s1= new Student();
        	s1.setStudentId(sId);
        	s1.setStudentName(sName);
        	s1.setStudentCity(sCity);
        	
        	int result=dao.insert(s1);
        	System.out.println( result+" " + "Student Added Successfully..."  );
        	
        	break;
        
        case 2:
        	//display all students
        	System.out.println("*************************************");
        	List<Student> allStudents=dao.getAllStudents();
        	for(Student st:allStudents)
        	{
        		System.out.println("ID : "  + st.getStudentId());
        		System.out.println("NAME :" + st.getStudentName());
        		System.out.println("CITY :" + st.getStudentCity());
        		System.out.println("___________________________________");
        	}
        	
        	System.out.println("**************************************");
        	break;
        	
        case 3:
        	//get single student data
        	System.out.println("Enter Student Id:");
        	int sId1=Integer.parseInt(br.readLine());
        	Student s2=dao.getStudent(sId1);
        	System.out.println("ID : "  + s2.getStudentId());
    		System.out.println("NAME :" + s2.getStudentName());
    		System.out.println("CITY :" + s2.getStudentCity());
    		System.out.println("___________________________________");
        	break;
       
        case 4:
        	//delete the student
        	System.out.println("Enter Student Id:");
        	int sId3=Integer.parseInt(br.readLine());
        	dao.deleteStudent(sId3);
        	System.out.println(sId3 + " "+ "STUDENT DATA DELETED SUCCESSFULLY...");
        	break;
        	
        case 5:
        	//update the student
        	System.out.println("Enter Student Id:");
        	int sId4=Integer.parseInt(br.readLine());
        	
        	System.out.println("Enter Student Name:");
        	String sName4=br.readLine();
        	
        	System.out.println("Enter Student City:");
        	String sCity4=br.readLine();
        	
        	Student s4= new Student();
        	s4.setStudentId(sId4);
        	s4.setStudentName(sName4);
        	s4.setStudentCity(sCity4);
        	dao.updateStudent(s4);
        	 System.out.println("STUDENT  DATA UPDATED SUCCESSFULLY...");
        	break;
        	
        case 6:
        	 //exit
        	go=false;
        	break;
        	
        }
        
      }
      catch(Exception e)
      {
    	  System.out.println("INVALID INPUT PLEASE TRY AGAIN!!");
    	  System.out.println(e.getMessage());
      }
    }      
     System.out.println("THANK YOU FOR USING MY APPLICATION...");
     System.out.println("SEE YOU SOON...");
      
    }
}
