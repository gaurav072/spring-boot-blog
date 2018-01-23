package com.startwithjava.simpleblog.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.repositories.UserRepository;
import com.startwithjava.simpleblog.security.SecurityUser;

@Service
public class AppUserDetailsService implements UserDetailsService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(final String email)
			throws UsernameNotFoundException {		
		logger.info("loadUserByUsername username="+email);
		
		User user = userRepository.findUserByEmail(email);
		
		if(user==null){
			throw new UsernameNotFoundException(email + " not found");
		}
		
		return new SecurityUser(user);
	 }
}
