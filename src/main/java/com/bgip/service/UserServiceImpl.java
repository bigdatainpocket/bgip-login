package com.bgip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bgip.model.User;
import com.bgip.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	 UserRepository userRepository;
	
	
	
	@Override
	public User findUserByName(String name) {
		User user = userRepository.findOne(name);
		
		return user;
	}

	@Override
	public User saveUser(User user) {
		try{
			userRepository.save(user);
		}catch(Exception e){
			System.out.println(e);
		}
		return user;
		
	}

}
