package com.gadministrativa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig - Defines security rules and exposes a SecurityFilterChain as a bean for Spring Security to enforce them automatically.
 */
@Configuration
public class SecurityConfig {
    /**
     * filterChain - This method configures the rules for incoming HTTP requests, allowing unauthorized access in described endpoints.
     * Method:
     *  1- Deactivates CSRF as RESTful APIs do not use cookies.
     *  2- Authorize ANY incoming request to any matching endpoints described in the requestMatchers.
     *  3- The rest of the endpoints need authentication or a 401 will be returned.
     * @param http - Spring class that allows to configure the app security.
     * @return - A new SecurityFilterChain that will be inside the SecurityFilterProxy.
     * @throws Exception - Any custom exception by Spring liked BadCredentials, InsufficientAuthenticationException, ...
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                "/api/v1/ping"
                )
            .permitAll().anyRequest()
            .authenticated()
        );

        return http.build();
    }
}
