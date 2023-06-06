package com.example.MongoProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/lines").hasRole("GET_LINES")
                .antMatchers("/lines/add").hasRole("ADD_LINE")
                .antMatchers("/lines/delete").hasRole("DELETE_LINE")
                .antMatchers("/lines/update").hasRole("UPDATE_LINE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("GET_LINES")
                .and()
                .withUser("admin")
                .password("{noop}password")
                .roles("GET_LINES", "ADD_LINE", "DELETE_LINE", "UPDATE_LINE")
                .and()
                .withUser("kent")
                .password("{noop}password")
                .roles("GET_LINES", "ADD_LINE");
    }
}
