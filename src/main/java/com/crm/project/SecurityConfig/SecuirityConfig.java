package com.crm.project.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuirityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/clients/**").permitAll()
                                .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
