package com.bgip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bgip.email.EmailService;
import com.bgip.exception.BgipException;
import com.bgip.model.User;
import com.bgip.service.UserService;

@RestController
@RequestMapping(value ="/bgip",produces = "application/json")
public class UserController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	
	    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
		public String welcomePage() {
	    	
			return " Welcome to BGIP Microservice ";
		}
	    
	    
	    @RequestMapping(value = { "/profile/{userName}"}, method = RequestMethod.GET)
		public User getUserDetails(@PathVariable("userName") String userName) throws Exception {
	    	
	    	User usr = new User();
	    		try{
	    			usr = userService.getUserDetails(userName);	
	    		}catch( BgipException e){
	    			LOGGER.error("getUserDetails method call" );
	    			e.printStackTrace();
	    		throw new BgipException(e.getMessage(),e.getCode());
	    		}
			return usr;
		}
	    
	    
	
	    
	    
	    
	    
	    
	    
}