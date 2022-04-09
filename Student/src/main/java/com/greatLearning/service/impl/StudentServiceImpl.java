package com.greatLearning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.entity.Student;
import com.greatLearning.repository.*;
import com.greatLearning.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(long id) {
		Optional<Student> optionalStudent=studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		return null;
	}
	
	@Override
	public List<Student> getStudents(String name) {
		// TODO Auto-generated method stub
		System.out.println("I am in implementation");
		return studentRepository.findByName(name);
	}
	@Override
	public List<Student> getStudents(String country, String department) {
		// TODO Auto-generated method stub
		return studentRepository.findByCountryAndDepartment(country, department);
	}

	@Override
	public void updateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		Optional<Student> optionalStudent=studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			studentRepository.save(student);
		}
		
	}

	@Override
	public void deleteStudent(long id) {
		Optional<Student> optionalStudent=studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			studentRepository.delete(optionalStudent.get());
		}
		
	}



}
