package com.bgip.controller;

import java.util.List;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgip.email.EmailService;
import com.bgip.model.Login;
import com.bgip.model.User;
import com.bgip.service.UserService;

@RestController
@RequestMapping(value ="/bgip",produces = "application/json")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
    
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public @ResponseBody User userRegistration(@RequestBody User user){
			User usr = userService.userRegister(user);
			emailService.sendMail("ursmuthahar@gmail.com", "Welcome to BGIP", "Thank you for registration");
			return usr;
			
		}
	
	    
	    @RequestMapping(value = { "/login/forgotPassword"}, method = RequestMethod.POST)
		public @ResponseBody List<User>  forgotPassword( @RequestBody Login login) {
    	
	    	userService.forgotPassword(login.getUserName(), login.getPassword(),login.getNewPassword());
    	return userService.findByUserName(login.getUserName());
		}
	    
	    
	    @RequestMapping(value = { "/login"}, method = RequestMethod.POST)
		public List<User>  login( @RequestBody Login login) {
	    	System.out.println("user : "+login.getUserName());
	    	List<User> user = userService.login(login.getUserName(), login.getPassword());
	    	System.out.println("user : "+user);
    	return user;
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	
	
}
