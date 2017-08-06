package com.bgip.service;

import java.util.List;

import com.bgip.model.User;

public interface UserService {

	public  List<User> login(String userName, String password);
	public Object forgotPassword( String userName, String oldPassword, String newPassword);
	public User userRegister(User user);
	
	public List<User> findAll();
//	public User findByEmail(String email);
    public List<User> findByUserName(String userName);
	
	
	
	
	
}
