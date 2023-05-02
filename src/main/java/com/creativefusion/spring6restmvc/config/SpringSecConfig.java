package com.creativefusion.spring6restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author sm@creativefusion.net
 */
@Profile("!test")
@Configuration
public class SpringSecConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/v3/api-docs**", "/swagger-ui/**",  "/swagger-ui.html")
                .permitAll()
                .requestMatchers("/actuator/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().oauth2ResourceServer().jwt();
        return http.build();
    }

}
