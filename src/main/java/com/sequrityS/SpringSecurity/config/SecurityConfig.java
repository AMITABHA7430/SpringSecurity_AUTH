package com.sequrityS.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.UserDetailsServiceFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(request ->
                request.anyRequest().authenticated());

        http.formLogin(Customizer.withDefaults());

        http.httpBasic(Customizer.withDefaults());

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1= User
                .withDefaultPasswordEncoder().
                username("bedanta")
                .password("dutta")
                .roles("USER")
                .build();
        UserDetails user2= User
                .withDefaultPasswordEncoder().
                username("soumyadeep")
                .password("basak")
                .roles("USER")
                .build();
        UserDetails user3= User
                .withDefaultPasswordEncoder().
                username("Amitabha")
                .password("Ghosh")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

}