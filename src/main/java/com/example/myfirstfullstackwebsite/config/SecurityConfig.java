package com.example.myfirstfullstackwebsite.config;

import com.example.myfirstfullstackwebsite.jwt.JwtAuthenticationEntryPoint;
import com.example.myfirstfullstackwebsite.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final UserDetailsService jwtUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;
    final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserDetailsService jwtUserDetailsService, JwtRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors((cors) -> cors.configurationSource(
                        request -> {
                            CorsConfiguration configuration = new CorsConfiguration();
                            configuration.setAllowedOriginPatterns(List.of("*"));
                            configuration.setAllowedMethods(List.of("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH"));
                            configuration.setAllowedHeaders(List.of("*"));
                            configuration.setAllowCredentials(true);
                            return configuration;
                        }
                ))
                .authorizeHttpRequests(
                        (authorizeRequests) ->
                                authorizeRequests
                                        .requestMatchers("api/authenticate", "/api/registration", "/swagger-ui.html")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated()
                )
                .exceptionHandling((ex) ->
                        ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
