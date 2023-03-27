package com.medify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medify.entity.User;
import com.medify.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> fetchAllUsers() {	
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}

	@Override
	public User updateUserById(Integer id, User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}

}
