package com.greatLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatLearning.entity.Student;


@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByName(String name);

	List<Student> findByCountryAndDepartment(String country, String department);


}
