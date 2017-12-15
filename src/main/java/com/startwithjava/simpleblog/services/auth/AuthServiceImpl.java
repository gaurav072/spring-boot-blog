package com.startwithjava.simpleblog.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.repositories.UserRepository;

public class AuthServiceImpl implements AuthService {
	@Autowired
	UserRepository userRepository;
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
}
