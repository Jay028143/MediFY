package com.medify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	  Optional<User> findByUserName(String userName);

	  Boolean existsByUserName(String userName);

	  Boolean existsByEmail(String email);
	  
	  List<User> findByStoreId(String storeId);

}
