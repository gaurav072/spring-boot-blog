package com.startwithjava.simpleblog.services.auth.otp;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class OTPAuthorizationToken extends UsernamePasswordAuthenticationToken {
    private String otp;

    public OTPAuthorizationToken( String username, String password, String otp ) {
        super( username, password );
        this.otp = otp;
    }

    public String getOTP() {
        return otp;
    }
}