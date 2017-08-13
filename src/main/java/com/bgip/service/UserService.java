package com.bgip.service;

import java.util.List;

import com.bgip.model.User;

public interface UserService {

	public  Object login(String userName, String password) throws Exception;
	public Object forgotPassword( String userName, String oldPassword, String newPassword) throws Exception;
	public User userRegister(User user) throws Exception;
	
	public List<User> findAll() throws Exception;
//	public User findByEmail(String email);
    public List<User> findByUserName(String userName) throws Exception;
    public void validateUser(String userName) throws Exception;
    public User getUserDetails( String user) throws Exception ;
	
	
	
}
