package com.greatLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.entity.Student;
import com.greatLearning.service.StudentService;



@RestController
@RequestMapping("/students")

public class StudentController {

	@Autowired
	StudentService studentservice;
	
	@PostMapping("/save")
	Student saveStudent(@RequestBody Student student) {
		System.out.println("I am here");
		return studentservice.createStudent(student);
	}
	
	@GetMapping("/getallstudents")
	List<Student> getStudents(){
		System.out.println("Inside get Method of Students Controller");
		return studentservice.getStudents();
	}
	
	@GetMapping("/search/name/")
	List<Student> getStudents(@RequestParam("name") String name){
		return studentservice.getStudents(name);
	}
	
	@GetMapping("/search/CountryAnddepartment/")
	List<Student> getStudents(@RequestParam("country") String country, @RequestParam("department") String department){
	return studentservice.getStudents(country, department);
	}
	
	@PutMapping("save/{id}")
	void updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
		studentservice.updateStudent(id, student);
	}
	
	@DeleteMapping("save/{id}")
	void deleteStudent(@PathVariable("id") Long id){
		studentservice.deleteStudent(id);
	}
}
