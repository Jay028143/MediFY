package com.medify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medify.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
