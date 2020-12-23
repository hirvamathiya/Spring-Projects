package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao
{
 
	private HibernateTemplate hibernateTemplate;
	
	//save student
    @Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
    
    //get the single data
    public Student getStudent(int studentId)
    {
         Student student=this.hibernateTemplate.get(Student.class, studentId);
         return student;	
    }
    
    //get all students
    public List<Student> getAllStudents()
    {
        List<Student> list=	this.hibernateTemplate.loadAll(Student.class);
        return list;
    }
    
    //delete the student data
    @Transactional
    public void deleteStudent(int studentId)
    {
    	
         Student student=this.hibernateTemplate.get(Student.class, studentId);
    	 this.hibernateTemplate.delete(student);
    }
    
    //update student data
    @Transactional
    public void updateStudent(Student student)
    {
    	this.hibernateTemplate.update(student);
    	
    }
    
    

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	
}
