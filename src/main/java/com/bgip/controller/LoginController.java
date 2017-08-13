package com.bgip.controller;

import java.util.List;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgip.constants.StatusCodes;
import com.bgip.email.EmailService;
import com.bgip.exception.BgipException;
import com.bgip.model.Login;
import com.bgip.model.User;
import com.bgip.service.UserService;

@RestController
@RequestMapping(value = "/bgip", produces = "application/json")
public class LoginController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User userRegistration(@RequestBody User user) throws Exception {
		User usr = null;
		try {
			usr = userService.userRegister(user);
			emailService.sendMail("ursmuthahar@gmail.com", "Welcome to BGIP", "Thank you for registration");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("User Registartiong Error");
			throw new BgipException(StatusCodes.USER_ID_NOTEXIST, "User Registartiong Error");
		}

		return usr;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public Object login(@RequestBody Login login) throws Exception {
		Object user = null;
		try{
			 user = userService.login(login.getUserName(), login.getPassword());
		}catch( Exception e){
			LOGGER.error("UserId doesn't exist");
			e.printStackTrace();
			throw new BgipException(StatusCodes.USER_ID_NOTEXIST, "UserId doesn't exist");
		}
		return user;
	}

	@RequestMapping(value = { "/login/resetpassword" }, method = RequestMethod.POST)
	public @ResponseBody List<User> resetpassword(@RequestBody Login login) throws Exception {

		try{
			userService.forgotPassword(login.getUserName(), login.getPassword(), login.getNewPassword());
		}catch( Exception e){
			LOGGER.error("invalid password please try again");
			e.printStackTrace();
			throw new BgipException(StatusCodes.USER_ID_NOTEXIST, " invalid password please try again");
		}
		
		return userService.findByUserName(login.getUserName());
	}

}
