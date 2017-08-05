package com.bgip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgip.model.Response;
import com.bgip.model.User;
import com.bgip.repository.UserRepository;
import com.bgip.repository.UserRepositoryCustom;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;


	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public User findCustomByUser(String domain) {
//		userRepository.findCustomByUser(domain);	
//		return null;
//	}
//
//	@Override
//	public List<User> findCustomByRegExDomain(String domain) {
//		userRepository.findCustomByRegExDomain(domain);
//		return null;
//	}
//	
//	@Autowired
//	UserRepositoryCustom userRepositoryCustom;
	
//	
//	@Override
//	public User login(String email, String password) {
//		
//		User user = userRepository.findOne(email);
//		if( user.getPassword() == password ){
//			return user;
//		}
//		
////		userRepository.findOne(example);
//		
//		
//		return null;
//	}
//	
//	@Override
//	public Response updatePassword( String emailId, String oldPassword, String password){
//		Response response = null;
//		User user = userRepository.findOne(emailId);
//		if( user.getPassword() == oldPassword){
//			user.setPassword(password);
//			 userRepository.save(user);
//			 response.setMessage("Success");
//		}else{
//			 response.setMessage("Invalid Password");
//		}
//		
//		return response;
//	}
//	
//	
//	
//	
//	@Override
//	public User saveUser(User user) {
//		try{
//			userRepository.save(user);
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		return user;
//		
//	}

	
	
//	@Override
//	public User getUserInfo(String email) throws Exception {
//		
//		User usr = userRepository.getObjectByField("user", "email", email, User.class);
//		
//		if( usr != null){
//			return usr;
//		}
//		
//		
//		return usr;
//	}
//
//	
	
	
	
	
	
	
	
	
	
	
}
