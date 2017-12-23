package com.startwithjava.simpleblog.services.auth.ldap;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
@Component(value="ldapAuthenticationProvider")
public class LDAPAuthenticationProvider implements AuthenticationProvider{
	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
	   if ( authentication.isAssignableFrom( LDAPAuthorizationToken.class ) ) {
	        return true;
	    }
	    return false;
	}

}
