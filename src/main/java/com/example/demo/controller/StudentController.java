package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {

	
	private StudentService service;

	@Autowired
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/customer")
	public  String studentDetail(Model mnodel ) {
		
      List<Student> studentList = service.getAllStudent();
		
		mnodel.addAttribute("students", studentList);
		
		
		return "list-employees";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student student = new Student();
		
		theModel.addAttribute("students", student);
		
		return "employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("student") int theId,
									Model model) {
		Student student = service.findbyID(theId); 
			
			model.addAttribute("students", student);
		return "CustomerUpdate";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("student") Student student) {
		
		service.save(student);
		
		return "redirect:/showFormForAdd";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentID") int theId) {
		
		service.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/customer";
		
	}
	
	
	@PostMapping("/updateVal")
	public String updateValue(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName, @RequestParam("email") String emil, 
			 @RequestParam("id")int id) {
		
		Student student = new Student(firstName, lastName, emil);
		student.setId(id);
		
		
		service.updateCustomer(student);
		
		return "redirect:/customer";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
