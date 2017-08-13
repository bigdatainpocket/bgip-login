package com.bgip.repository;

public interface UserRepositoryCustom {

//	 public List < User > findByUserOnlyAvailablesCustom(String userName);

	public <T> T findBy2FieldsIn(String collectionName, String fieldName1, String fieldValue1, String fieldName2, String fieldValue2,
			Class<T> className);
	
	public <T> T findByField(String collectionName, String fieldName1, String fieldValue1, Class<T> className);

}
