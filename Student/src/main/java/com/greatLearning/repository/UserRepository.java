package com.greatLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{
	
	AppUser findByUserName(String name);

}
