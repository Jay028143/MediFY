package com.medify.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medify.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	  Optional<User> findByUserName(String userName);

	  Boolean existsByUserName(String userName);

	  Boolean existsByEmail(String email);
	  
	  List<User> findByStoreId(String storeId);
	  
	  @Modifying
	  @Transactional
	  @Query(value= "update users set password=:pass where username= :userName",nativeQuery = true )
	  void updatePassword(@Param("userName")String username, @Param("pass")String password);

}
