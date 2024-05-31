package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentrepo;

	@Override
	public Student addstudent(Student student) {
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return  studentrepo.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		
		return studentrepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		student.setId(id);
		return studentrepo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		 studentrepo.deleteById(id);
	}
	
	
}
