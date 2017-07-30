package com.bgip.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgip.model.User;
import com.bgip.service.UserServiceImpl;

@RestController
@RequestMapping("/bgip")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	UserServiceImpl userServiceImpl;
	


	@RequestMapping(value="/register", method=RequestMethod.POST)
	public @ResponseBody User userRegistration(@RequestBody User user){
		logger.info("User Registration : {}",user);
		
		User usr = userServiceImpl.saveUser(user);
		return usr;
		
	}
	
	
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public List<User> listAllUsers(@PathVariable("name") String name) {
        List<User> users = (List<User>) userServiceImpl.findUserByName(name);
        System.out.println("Name"+ name);
        if (users.isEmpty()) {
            return (List<User>) new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return users;
    }
	
	
	
	

	
	
}