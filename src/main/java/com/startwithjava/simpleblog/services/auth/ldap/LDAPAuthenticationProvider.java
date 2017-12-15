package com.startwithjava.simpleblog.services.auth.ldap;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class LDAPAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		 if ( authentication.isAssignableFrom( LDAPAuthorizationToken.class ) ) {
	            return true;
	        }
	        return false;
	}

}
