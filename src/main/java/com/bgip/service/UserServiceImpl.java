package com.bgip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bgip.model.Response;
import com.bgip.model.User;
import com.bgip.repository.UserRepository;
import com.bgip.repository.UserRepositoryCustom;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	
	
	@Override
	public User userRegister(User user) {
		try{
			User usr = userRepository.save(user);
			return usr;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
		
	}
	
	@Override
	public List<User> login(String userName, String password) {
		List<User> usrs1 = new ArrayList<User>();
    	List<User> users = userRepository.findByUserName(userName);
    	System.out.println(" Users : "+users);
    	
    	for( User usr : users){
    		if( usr.getPassword().equals(password)){
    			usr.setPassword(null);
    			usrs1.add(usr);
    		}
    	}
    	
    	
    	
//    	for( User user : users){
//    		
//    		
//    		
//    			if( user.getPassword() == password){
//    				System.out.println(" user.getPassword() == password :: "+user.getPassword() == password);
//    				user.setPassword(null);
//    				usrs.addAll(user);
//    		}
//    	}
//    	
    	return usrs1;
		}
	
	
	@Override
	public Object forgotPassword(String userName, String oldPassword, String newPassword) {
		List<User> users = userRepository.findByUserName(userName);
		for( User user : users){
    		if( user != null){
    			if( user.getPassword() == oldPassword){
    				user.setPassword(newPassword);
    				 userRepository.save(user);
    				return users;
    			}
    		}
    	}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<User> findByUserName(String userName) {
		List<User> users = userRepository.findByUserName(userName);
    	for( User user : users){
    		user.setPassword(null);
    	}
		
		return users;
	}


	@Override
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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



	
	
	
	
	
}
