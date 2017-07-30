package com.bgip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bgip.model.User;

@Transactional
public interface UserRepository extends MongoRepository<User, String> {
	
	
}
