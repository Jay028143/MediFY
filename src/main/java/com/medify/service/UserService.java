package com.medify.service;


import java.util.List;

import com.medify.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> fetchAllUsers();
	
	User getUserById(Integer id);
	
	User updateUserById(Integer id,User user);
	
	void deleteUserById(Integer id);
}
