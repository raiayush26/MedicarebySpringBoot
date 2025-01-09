package com.raiayush.Medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raiayush.Medicare.model.User;
import com.raiayush.Medicare.service.UserServices;

@RestController
public class UserController {
	@Autowired
	private UserServices service;
	
	@PostMapping("register")
	 public  User register(@RequestBody User user) {
		 return service.saveUser(user);
	 }
	 @PostMapping("login")
	 public String login(@RequestBody User user) {
		 return "login";
		//Authentication authentication = authenticationManager
				//.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		 //if(authentication.isAuthenticated()) 
			// return jwtService.generateToken(user.getUsername());
		// else 
			// return "Login Failed";
		 
	 }
}
