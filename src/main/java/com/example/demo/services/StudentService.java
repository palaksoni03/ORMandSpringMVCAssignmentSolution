package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	
	public List<Student> getAllStudent();
	
	public Student findbyID(int id);
	
	public Student save(Student student);
	
	public void deleteById(int theId);
	
	public void updateCustomer(Student student);
}
