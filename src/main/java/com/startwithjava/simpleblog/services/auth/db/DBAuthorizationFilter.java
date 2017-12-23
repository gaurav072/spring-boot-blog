package com.startwithjava.simpleblog.services.auth.db;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.startwithjava.simpleblog.services.auth.AuthService;
@Service
public class DBAuthorizationFilter extends AbstractAuthenticationProcessingFilter {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    
	@Autowired
	AuthService authService;
	
    @Autowired
    private DaoAuthenticationProvider authenticationManager;
	protected DBAuthorizationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}
	public DBAuthorizationFilter() {
		// TODO Auto-generated constructor stub
		 super( "/dblogin" );
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
	   String username = getUsername(request);
       String password = getPassword(request);
       authService.authticate(null,null);
       Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
       return authenticationManager.authenticate(authentication);
	}
    public String getUsername(HttpServletRequest request){
        return request.getParameter(USERNAME);
    }
    public String getPassword(HttpServletRequest request){
        return request.getParameter(PASSWORD);
    }
  /*  @Autowired
    public void setAuthenticationManager(AuthenticationManagerBuilder authenticationManager) {
    	this.authenticationManager = authenticationManager;
    }*/

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
