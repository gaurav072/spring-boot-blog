package com.startwithjava.simpleblog.services.auth.ldap;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class LDAPAuthorizationToken extends AbstractAuthenticationToken {

	public LDAPAuthorizationToken(Collection<? extends GrantedAuthority> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
