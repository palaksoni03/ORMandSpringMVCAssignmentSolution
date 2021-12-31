package com.example.demo.studentInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentInterface extends JpaRepository<Student,Integer>{

}
