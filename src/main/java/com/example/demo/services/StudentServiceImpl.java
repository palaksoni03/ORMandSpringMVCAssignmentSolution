package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.Query;

import com.example.demo.entity.Student;
import com.example.demo.studentInterface.StudentInterface;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentInterface studentInterface;
	
	private EntityManager entityManager;

	@Autowired
	public StudentServiceImpl(StudentInterface studentInterface , EntityManager entityManager) {
		super();
		this.studentInterface = studentInterface;
		this.entityManager = entityManager;
	}




	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentInterface.findAll();
	}




	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentInterface.save(student);
	}




	@Override
	public void deleteById(int theId) {
			
		studentInterface.deleteById(theId);
	}




	@Override
	public Student findbyID(int id) {
		// TODO Auto-generated method stub
		return studentInterface.getById(id);
	}




	@Override
	public void updateCustomer(Student student) {

		studentInterface.save(student);	
		
	}
}
