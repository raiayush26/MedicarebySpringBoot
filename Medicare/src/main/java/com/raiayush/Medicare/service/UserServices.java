package com.raiayush.Medicare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raiayush.Medicare.dao.UserRepo;
import com.raiayush.Medicare.model.User;

@Service
public class UserServices {
	@Autowired
	private UserRepo repo;
	public  User saveUser(User user) {
		return repo.save(user);
	}
}
