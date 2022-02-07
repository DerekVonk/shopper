package com.derekvonk.productservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal1(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // for now, permit all
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET,"/products").permitAll()
                .antMatchers(HttpMethod.GET,"/products/*").permitAll()
                .antMatchers(HttpMethod.POST,"/products").permitAll()
                .antMatchers(HttpMethod.POST,"/products/searchBy").permitAll()
                .antMatchers(HttpMethod.DELETE,"/products/*").permitAll()
                .antMatchers(HttpMethod.PUT,"/products/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                .csrf()
                .disable();


    }

}
