package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	boolean existsByGuid(String guid);
	
	User findByGuid(String guid);
	
	boolean deleteByGuid(String guid);

}