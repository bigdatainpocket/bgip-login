package com.bgip.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import com.bgip.model.User;
import com.mongodb.WriteResult;

public class UserRepositoryImpl {

	//Impl postfix of the name on it compared to the core repository interface
	public class DomainRepositoryImpl implements UserRepositoryCustom {

		@Autowired 
		private MongoTemplate mongoTemplate;

		

		public <T> T getObjectByField(String collectionName, String fieldName, Object fieldValue, Class<T> className) 
				throws Exception {
			T object = null;
			Query query = new Query(Criteria.where(fieldName).is(fieldValue));
			object = mongoTemplate.findOne(query, className, collectionName);
			return object;
		}
		
		
		public <T> List<T> getAllObjects(String collectionName, Class<T> className) throws Exception {
			List<T> objectList = null;
			objectList = mongoTemplate.findAll(className, collectionName);
			return objectList;
		}
		
		
		public <T> List<T> getObjectsByFieldIn(String collectionName, String fieldName, String fieldValue, Class<T> className) throws Exception {
			List<T> objectList = null;
			Query query = new Query(Criteria.where(fieldName).in(fieldValue));
			objectList = mongoTemplate.find(query, className, collectionName);
			return objectList;
		}
		
		public <T> T getObjectByField(String collectionName, String fieldName, String fieldValue, Class<T> className) throws Exception {
			T object = null;
			Query query = new Query(Criteria.where(fieldName).is(fieldValue));
			object = mongoTemplate.findOne(query, className, collectionName);
			return object;
		}
		
		public <T> WriteResult updateByObjectId(String collectionName,
				String fieldName, ObjectId objectId, String key, String keyvalue)
				throws Exception {
			WriteResult object = null;
			Query query = new Query(Criteria.where(fieldName).is(objectId));
			Update update = new Update();
			update.set(key, keyvalue);
			object = mongoTemplate.updateFirst(query, update,
					collectionName);
			return object;
		}
		
		
		
		public void deleteByField(String collectionName, String fieldName, String fieldValue) throws Exception {
			
			try {
				Query query = new Query(Criteria.where(fieldName).is(fieldValue));
				mongoTemplate.remove(query, collectionName);
				
			} catch (Exception e) {
				throw new Exception(e);
			}
			
		}


	
	}
}
