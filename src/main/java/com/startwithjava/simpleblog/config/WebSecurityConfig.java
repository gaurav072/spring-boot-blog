package com.startwithjava.simpleblog.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.startwithjava.simpleblog.services.auth.db.DBAuthorizationFilter;
import com.startwithjava.simpleblog.services.auth.db.DaoAuthenticationProvider;
import com.startwithjava.simpleblog.services.auth.ldap.LDAPAuthenticationProvider;
import com.startwithjava.simpleblog.services.auth.ldap.LDAPAuthorizationFilter;
import com.startwithjava.simpleblog.services.auth.otp.OTPAuthenticationProvider;
import com.startwithjava.simpleblog.services.auth.otp.OTPAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private LDAPAuthenticationProvider ldapAuthenticationProvider;
	@Autowired
	private OTPAuthenticationProvider otpAuthenticationProvider;
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;
	@Autowired
	private DBAuthorizationFilter dbAuthorizationFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//configure filters
        //http.addFilterBefore( ldapAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        //http.addFilterBefore( otpAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    	http.authenticationProvider(daoAuthenticationProvider);
    	http.addFilterBefore( dbAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    	
        //configure authentication providers
        //http.authenticationProvider(ldapAuthenticationProvider);
        //http.authenticationProvider(otpAuthenticationProvider);
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/web-jars/*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
            .and()
    		.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
        
    }
   }
