package com.startwithjava.simpleblog.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.startwithjava.simpleblog.config.SecurityUser;
import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.repositories.UserRepository;

public class AppUserDetailsServiceDAO implements UserDetailsService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {		
		logger.info("loadUserByUsername username="+username);
		
		User user=null;
		//User user = userRepository.findUserByEmail(username);
		
		/*if(user!=null){
			throw new UsernameNotFoundException(username + " not found");
		}
		*/
		return new SecurityUser(user);
	 }
}
