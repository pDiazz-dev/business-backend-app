package org.technew.linkedin2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.technew.linkedin2.config.rolesCript.jwt.JwtConverterRole;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtConverterRole jwtConverterRole;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .csrf(AbstractHttpConfigurer::disable) // active before tests
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/register").permitAll()
                        .requestMatchers("/auth/refresh").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtConverterRole.jwtAuthenticationConverter())
                        ));
        return http.build();
    }

}
