package com.startwithjava.simpleblog.security.config;
import com.startwithjava.simpleblog.security.AuthSuccessHandler;
import com.startwithjava.simpleblog.security.config.entrypoint.ApiAuthenticationEntryPoint;
import com.startwithjava.simpleblog.security.LoggingAccessDeniedHandler;
import com.startwithjava.simpleblog.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String REALM_NAME = "startwithjava.com";
    @Configuration
    @Order(1)
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        LoggingAccessDeniedHandler accessDeniedHandler;

        @Autowired
        AuthSuccessHandler authSuccessHandler;

        @Autowired
        AppUserDetailsService appUserDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(
                            "/",
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webjars/**").permitAll()
                    .antMatchers("/user/**").hasRole("USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .successHandler(authSuccessHandler)
                    .permitAll()
                    .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(appUserDetailsService);
            auth.authenticationProvider(daoAuthenticationProvider);
        }
    }
    @Configuration
    @Order(2)
    public static class ApiTokenSecurityConfig extends WebSecurityConfigurerAdapter{
        @Autowired
        AppUserDetailsService appUserDetailsService;
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf()
                       .disable()
                    .authorizeRequests()
                    .antMatchers("/api/**")
                    .hasRole("ADMIN")
                    .and()
                    .httpBasic()
                        .realmName(REALM_NAME)
                        .authenticationEntryPoint(new ApiAuthenticationEntryPoint())
                        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(appUserDetailsService);
            auth.authenticationProvider(daoAuthenticationProvider);
        }

    }

}