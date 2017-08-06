package com.bgip.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bgip.model.User;
import com.mongodb.client.model.FindOptions;

@Transactional
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom{


	public List<User> findAll();
	public User findByEmail(String email);
    public List<User> findByUserName(String userName);
	

}
