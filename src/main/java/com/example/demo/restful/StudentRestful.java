package com.example.demo.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentRestful {

	private StudentService studentService;

	@Autowired
	public StudentRestful(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	
	@GetMapping("/AllStudent")
	public List<Student> getAllStudent(){
	
		return studentService.getAllStudent();
		
	}
	
}
