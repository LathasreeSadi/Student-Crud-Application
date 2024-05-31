package com.web.service;

import java.util.List;

import com.web.model.Student;

public interface StudentService 
{  
	//add student details
	public Student addstudent(Student student);
	  
	//get all student details
	public List<Student> getAllStudents();
	
	//get one record
	public Student getStudent(Long id);
	
	//Update Student one record
	public Student updateStudent(Long id, Student student);
	
	//delete Student one record
	public void deleteStudent(Long id);
}
