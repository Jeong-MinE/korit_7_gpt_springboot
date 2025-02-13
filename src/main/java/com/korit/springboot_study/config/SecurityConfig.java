package com.korit.springboot_study.config;

import com.korit.springboot_study.security.exception.CustomAuthenticationEntryPoint;
import com.korit.springboot_study.security.exception.filter.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    private CustomAuthenticationFilter customAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.formLogin().disable();
        http.addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers(
                        "/api/post/**",
                        "api/user/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint);
    }
}
