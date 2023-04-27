package com.medify.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medify.entity.User;
import com.medify.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000/")
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser() {
        return userService.fetchAllUsers();
    }
    
    @GetMapping("/getUserByStoreId/{storeId}")
    public List<User> getUserByStoreId(@PathVariable String storeId) {
        return userService.fetchAllUsersByStoreId(storeId);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	System.err.println(user);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User currentUser = userService.updateUserById(null, user);
        return ResponseEntity.ok(currentUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

}
