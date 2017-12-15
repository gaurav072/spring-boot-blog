package com.startwithjava.simpleblog.services;

import java.util.List;

import com.startwithjava.simpleblog.entities.User;

public interface UserService {
	public User authenticateUser(String username,String password);
	public User findUserById(long userId);
	public List<User> findAllUsers();
}
