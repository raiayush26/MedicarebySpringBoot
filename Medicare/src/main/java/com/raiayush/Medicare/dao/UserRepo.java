package com.raiayush.Medicare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raiayush.Medicare.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
