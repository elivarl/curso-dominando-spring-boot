package com.icodeap.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(
                csrf-> csrf.disable()
        ).authorizeHttpRequests(
                auth-> {
                    //auth.requestMatchers("/api/public/**").permitAll().anyRequest().authenticated();
                    auth.requestMatchers("/api/admin/**").hasRole("ADMIN").
                            requestMatchers("/api/user/**").hasRole("USER").anyRequest().permitAll();
                }
        ).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user").
                password(passwordEncoder().encode("user")).roles("USER").build();
        UserDetails admin = User.withUsername("admin").
                password(passwordEncoder().encode("admin")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user,admin);
    }




}
