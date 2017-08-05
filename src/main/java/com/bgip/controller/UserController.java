package com.bgip.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bgip.email.EmailService;
import com.bgip.model.Response;
import com.bgip.model.User;
import com.bgip.repository.UserRepository;
import com.bgip.service.UserService;

@RestController
@RequestMapping(value ="/bgip",produces = "application/json")
public class UserController {
	
	
//	@Autowired
//	UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	UserRepository userRepository;

	
	
	    @RequestMapping(value = { "/home"}, method = RequestMethod.GET)
		public Object welcomePage() {
	    	Response res = null;
			res.setMessage("Welcome to Big Data in Pocket");
			return res.getMessage();
		}
	    
	    
	    @RequestMapping(value = { "byname/{name}"}, method = RequestMethod.GET)
			public Object welcomePage12(@PathVariable("name") String name) {
				return name;
			}
	    
	    
	    @RequestMapping(value = { "/{email}"}, method = RequestMethod.GET)
		public User  findByUser(@PathVariable("email") String email) {
	    	
	    	System.out.println("userRepository.findByEmail(email);"+email);
			
	    	User usr =userRepository.findByEmail(email);
	    	
	    	System.out.println("userRepository.findByEmail(email);"+usr.getEmail());
	    	return usr;
		}
	    
	    
	    
	    
	    
	    
	    
	    
//	    @RequestMapping(value = { "findByName/{userName}"}, method = RequestMethod.GET)
//		public User user(@PathVariable("userName") String userName) {
//	    	User usr = userRepository.findFirstByUser(userName);
//	    	
//			return usr;
//		}
//	    
	

	    
	    @RequestMapping(value = { "findByUserOnlyAvailables/{userName}"}, method = RequestMethod.GET)
	  		public java.util.List<User> user12(@PathVariable("userName") String userName) {
	  	    	java.util.List<User> list = userRepository.findAll();
	    	
//	    	java.util.List<User> list = userRepository.findByUserOnlyAvailables(userName);
	  	    	
	  			return list;
	  		} 
	    
	    
	    
//	    @RequestMapping(value = { "findUserByName/{userName}"}, method = RequestMethod.GET)
//	  		public java.util.List<User> findUserByName(@PathVariable("userName") String userName) {
//	    	
//	    	java.util.List<User> list = userRepository.findUserByName(userName);
//	  	    	
//	  			return list;
//	  		} 
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    @RequestMapping(value = { "/user/{email}"}, method = RequestMethod.GET)
//		public User findFirstByUser(@RequestParam ("email")String user) {
//			userService.findCustomByUser(user);
//			return null;
//		} 
//	    
	    
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
//		@RequestMapping(value="/register", method=RequestMethod.POST)
//		public @ResponseBody Object userRegistration(@RequestBody User user) throws Exception{
//			try{
//			emailService.sendMail("ursmuthahar@gmail.com", "Welcome to BGIP", "Thank you for Register BGIP");
//			userService.saveUser(user);
//			
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			
//			return 	userService.toString();
//		}
//		
//		
//		@RequestMapping(method=RequestMethod.POST, value="/login")
//		public @ResponseBody Object login(@RequestParam String email, @RequestParam String password) {
//			try {
//				
//				return userService.login(email, password);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "Error SignIn";
//		}
//		
//		
//		@RequestMapping(method=RequestMethod.GET, value="/user/{email}")
//		public @ResponseBody Object getUserInfo(@RequestParam String email, @RequestParam String password) {
//			try {
//				
//				
//				
//				return userService.getUserInfo( email);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return "Error SignIn";
//		}
//		
//		
//
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	


//	@RequestMapping(value="/register", method=RequestMethod.POST)
//	public @ResponseBody User userRegistration(@RequestBody User user){
//		emailService.sendMail("ursmuthahar@gmail.com", "Welcome to BGIP", "Thank you for registration");
//		User usr = userServiceImpl.saveUser(user);
//		
//		
//		return usr;
//		
//	}
	
	
//	
//	
//	@RequestMapping( value="/bgip/{name}", method=RequestMethod.GET)
//	public @ResponseBody User getUser(@PathVariable String name){
//		System.out.println(name);
//		return userServiceImpl.findUserByName(name);
//	}
//	
//	
	
//	@RequestMapping( value="/user/update", method=RequestMethod.PUT)
//	public @ResponseBody User getUser(@RequestBody User user){
//		
//		User user = userServiceImpl.
//		
//		return userServiceImpl.findUserByName(name);
//	}
//	
	
	
	
	
	
	
	

	@RequestMapping( value="/hello/{user}",method=RequestMethod.GET)
	public String hello(@PathVariable ("user") String user){
		return " Hello Muthahar"+user;
		
	}
	
	
//	@RequestMapping( value="/user/{email}",method=RequestMethod.GET)
//	public Object allUsers(@PathVariable("email") String email) throws Exception{
//		return userService.getUserInfo(email);
//		
//	}
//	
//	
//	
	
	
	
	
	
	
	
	
	
//	
//	
//	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
//    public List<User> listAllUsers(@PathVariable("name") String name) {
//        List<User> users = (List<User>) userServiceImpl.findUserByName(name);
//        System.out.println("Name"+ name);
//        if (users.isEmpty()) {
//            return (List<User>) new ResponseEntity(HttpStatus.NO_CONTENT);
//            // You many decide to return HttpStatus.NOT_FOUND
//        }
//        return users;
//    }
//	
//	
	
	

	
	
}