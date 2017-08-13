package com.bgip.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UserRepositoryImpl implements UserRepositoryCustom{

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public void validateUser(String user){
		
	}
	
	
	public <T> T findBy2FieldsIn(String collectionName, String fieldName1, String fieldValue1, String fieldName2, String fieldValue2,
			Class<T> className)  {
		T object = null;
		try {
			Query query = new Query(Criteria.where(fieldName1).is(fieldValue1) .and(fieldName2).in(fieldValue2));
			object = mongoTemplate.findOne(query, className, collectionName);
			
				} catch (Exception e) {
			}
		return object;
	}
	
	public <T> T findByField(String collectionName, String fieldName1, String fieldValue1, Class<T> className){
			
		T object = null;
		try {
			Query query = new Query(Criteria.where(fieldName1).is(fieldValue1));
			object = mongoTemplate.findOne(query, className, collectionName);
			
				} catch (Exception e) {
			}
		return object;
	}


	
	
	
	
	
}
