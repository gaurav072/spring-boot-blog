
/*package com.startwithjava.simpleblog.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.startwithjava.simpleblog.security.AuthSuccessHandler;
import com.startwithjava.simpleblog.services.AppUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	AuthSuccessHandler authSuccessHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                    "/",
                    "/vendor/**",
                    "/dist/**",
					"/data/**",
                    "/js/**",
                    "/css/**",
                    "/img/**",
                    "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(authSuccessHandler)
                .permitAll()
                .and()
            .logout()
            .and()
    		.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
    }
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	org.springframework.security.authentication.dao.DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(appUserDetailsService);
		auth.authenticationProvider(daoAuthenticationProvider);
	}
   }*/
