package com.startwithjava.simpleblog.services.auth.otp;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.startwithjava.simpleblog.services.auth.AuthServiceImpl;
@Component(value="otpAuthenticationProvider")
public class OTPAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthServiceImpl authService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        OTPAuthorizationToken auth = (OTPAuthorizationToken)authentication;
        String error="";
      //  String error = authService.loginWithOTP( auth.getPrincipal(), auth.getCredentials(), auth.getOTP() );
        if ( error != null ) {
           // throw new LoginException( error );
        }

        auth.setAuthenticated( true );

        return auth;
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        if ( authentication.isAssignableFrom( OTPAuthorizationToken.class ) ) {
            return true;
        }
        return false;
    }
}