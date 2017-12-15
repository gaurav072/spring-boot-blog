package com.startwithjava.simpleblog.services.auth.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.repositories.UserRepository;

public class DaoAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	UserRepository userRepository;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken userPasswordAuthentication = (UsernamePasswordAuthenticationToken)authentication;
		User user = userRepository.findUserByEmail(userPasswordAuthentication.getName());
		
		if(user==null){
			throw new UsernameNotFoundException(user.getName() + " not found");
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}
