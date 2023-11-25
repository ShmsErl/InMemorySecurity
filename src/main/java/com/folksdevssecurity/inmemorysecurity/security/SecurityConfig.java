package com.folksdevssecurity.inmemorysecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("shms")
                .password(bCryptPasswordEncoder().encode("12"))
                .roles("USER").build();

        UserDetails admin = User.builder()
                .username("shms123")
                .password(bCryptPasswordEncoder().encode("admin"))
                .roles("ADMIN").build();


        return new InMemoryUserDetailsManager(user1, admin);


    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .headers(x -> x.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(x -> x.requestMatchers("/public/**").permitAll())
                .authorizeHttpRequests(x -> x.requestMatchers("/login/user/**").hasRole("USER"))
                    .authorizeHttpRequests(x -> x.requestMatchers("/login/admin/**").hasRole("ADMIN"))
                .authorizeHttpRequests(x -> x.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }




















}
