package com.startwithjava.simpleblog.services.auth.otp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.AuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class OTPAuthorizationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    public OTPAuthorizationFilter() {
        super( "/otp_login" ); // allow any request to contain an authorization header
    }

    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException
    {

       /* if ( request.getHeader( "Authorization" ) == null ) {
            return null; // no header found, continue on to other security filters
        }*/

        // return a new authentication token to be processed by the authentication provider
       // return new LDAPAuthorizationToken( request.getHeader( "Authorization" ) );
    	return null;
    }
}