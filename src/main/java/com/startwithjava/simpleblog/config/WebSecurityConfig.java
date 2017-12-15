package com.startwithjava.simpleblog.config;
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
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	  // configure filters
        http.addFilterBefore( new LDAPAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore( new OTPAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore( new DBAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        // configure authentication providers
        http.authenticationProvider( new LDAPAuthenticationProvider());
        http.authenticationProvider( new OTPAuthenticationProvider());
        http.authenticationProvider( new DaoAuthenticationProvider());
        
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
                .permitAll();
        http.csrf().disable();
    }
   }
