package com.pets.cadillac.config;

import com.pets.cadillac.CadillacProfiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    @Profile(CadillacProfiles.DEVELOPMENT)
    WebSecurityConfigurerAdapter noAuthorization() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().anyRequest().permitAll();
            }
        };
    }

    @Bean
    @Profile(CadillacProfiles.PRODUCTION)
    WebSecurityConfigurerAdapter basicAuthorization() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests()
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .httpBasic();
            }

            @Override
            public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                        .inMemoryAuthentication()
                        .withUser("user").password("password").roles("USER");
            }
        };
    }
}