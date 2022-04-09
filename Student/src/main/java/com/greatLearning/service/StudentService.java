package com.greatLearning.service;

import java.util.List;
import com.greatLearning.entity.Student;

public interface StudentService {
	Student createStudent(Student student);
	List<Student> getStudents();
	Student getStudent(long id);
	List<Student> getStudents(String name);
	List<Student> getStudents(String country, String department);
	void updateStudent(long id, Student student);
	void deleteStudent (long id);
}
