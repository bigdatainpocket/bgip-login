package com.bgip.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bgip.model.User;
import com.mongodb.client.model.FindOptions;

@Transactional
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom{


	
	public User findByEmail(String email);
    public List<User> findByUserName(String userName);
	
	
	
	
	
	
	
	
	//	 public List < User > findUserByName(String userName);
//	 
//	 @Query(value = "{User: ?0, availability : 1}")
//	 public List < User > findByUserOnlyAvailables(String sku);
//
//
//	
//	
	
	
	
}
