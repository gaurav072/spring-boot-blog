package com.startwithjava.simpleblog.services.auth.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.services.auth.AuthService;

@Service
public class DaoAuthenticationProvider implements AuthenticationProvider{
	AuthService authService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken userPasswordAuthentication = (UsernamePasswordAuthenticationToken)authentication;
		User user = authService.authticate(userPasswordAuthentication.getCredentials().toString(), userPasswordAuthentication.getPrincipal().toString());
		if(user==null){
			throw new BadCredentialsException(user + " not found");
		}
		return userPasswordAuthentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	

}
