package com.bgip.service;

import com.bgip.model.User;

public interface UserService {
	public User findUserByName(String name);
	public User saveUser(User user);
}
