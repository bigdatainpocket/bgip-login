package com.bgip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bgip.email.EmailService;
import com.bgip.model.User;
import com.bgip.service.UserService;

@RestController
@RequestMapping(value ="/bgip",produces = "application/json")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	

	
	
	    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
		public String welcomePage() {
	    	
			return "<h1><color red>Welcome to BGIP Microservice <h1>";
		}
	    
	    
	    

	    @RequestMapping(value = { "/profile/{userName}"}, method = RequestMethod.GET)
		public List<User> userProfile(@PathVariable("userName") String userName) {
	    	return userService.findByUserName(userName);
		}
    
	    
	
	
	
	
	
}