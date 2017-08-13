package com.bgip.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bgip.constants.StatusCodes;
import com.bgip.exception.BgipException;
import com.bgip.model.Response;
import com.bgip.model.User;
import com.bgip.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final String collectionName = "user";

	@Autowired
	UserRepository userRepository;

	// Validate User
	public void validateUser(String userName) throws Exception {
		User userBeanFromDB = userRepository.findByField(collectionName, "userName", userName, User.class);
		if (userBeanFromDB == null) {
			LOGGER.info("Invalid UserName Please Register");
			throw new Exception( " Invalid UserName Please Register ");
		}
	}

	public User getUserDetails(String user) throws Exception {
		validateUser(user);
		User userBeanFromDB = null;
		try{
			if(user != null){
				userBeanFromDB = userRepository.findByField(collectionName, "userName", user, User.class);	
			}
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error("Error in getUserDetails method"+e);
		}
		userBeanFromDB.setPassword(null);
		return userBeanFromDB;
	}

	@Override
	public User userRegister(User user)throws Exception {
		try {
			 userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in userRegister method"+e);
		}
		return  userRepository.findByField(collectionName, "userName", user.getUserName(), User.class);	

	}

	@Override
	public Object login(String userName, String password)throws Exception {
		User usr = userRepository.findByField("user", "userName", userName, User.class);	
		Response res = new Response();
		if( usr != null){
			if(usr.getPassword().equals(password)){
				usr.setPassword(null);
				
			}else{
				LOGGER.info("worng password, please provide valid password");
				throw new BgipException(StatusCodes.USER_DOES_NOTEXIST,
						"worng password, please provide valid password");
//				res.setMessage("worng password, please provide valid password");
			}
		}else{
			LOGGER.info("invalid User name please Register Bgip");
			throw new BgipException(StatusCodes.USER_DOES_NOTEXIST,
					"worng password, please provide valid password");
			
		}
	
		return usr;
	}

	@Override
	public Object forgotPassword(String userName, String oldPassword, String newPassword)throws Exception {
		List<User> users = userRepository.findByUserName(userName);
	
		for (User user : users) {
			if (user != null) {
				if (user.getPassword() == oldPassword) {
					user.setPassword(newPassword);
					userRepository.save(user);
					return users;
				}
			}
		}

		return null;
	}

	@Override
	public List<User> findByUserName(String userName) throws Exception{
		List<User> users = null;
		try {
			users = userRepository.findByUserName(userName);
			for (User user : users) {
				user.setPassword(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in findByUserName method"+e);
		}
		
		return users;
	}

	@Override
	public List<User> findAll() throws Exception{
		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in findAll method"+e);
		}
	
		return users;
	}

	
	
	
	
	
	
}
