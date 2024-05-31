package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.model.Student;
import com.web.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("/add")
	public String showCreateForm(ModelMap model) {
		model.addAttribute("student", new Student());
		return "student/addstudent";
	}

	@PostMapping("/adddetails")
	public String createStudent(@ModelAttribute("student") Student student) {
		studentServiceImpl.addstudent(student);

		return "student/success";
	}

	@GetMapping("/studentlist")
	public String getAllStudents(ModelMap model) {
		model.addAttribute("students", studentServiceImpl.getAllStudents());
		return "student/studentlist";
	}
    
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id)
	{
		studentServiceImpl.deleteStudent(id);
		return "student/deletestu";
	}
	@GetMapping("/edit/{id}")
	public String studUpdate(@PathVariable Long id, @ModelAttribute("student") Student student, ModelMap model) {
		Student studentData = studentServiceImpl.getStudent(id);
		model.addAttribute("student", studentData);
		return "student/editstudent";
	}

	@PostMapping("/editupdated/{id}")
	public String updated(@PathVariable Long id, @ModelAttribute("student") Student student) {
		studentServiceImpl.updateStudent(id, student);
		return "student/updatesuccess";
	}
}
