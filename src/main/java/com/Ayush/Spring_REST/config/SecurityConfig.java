// package com.Ayush.Spring_REST.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.Ayush.Spring_REST.jwt.AuthEntryPointJwt;
// import com.Ayush.Spring_REST.jwt.AuthTokenFilter;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// public class SecurityConfig {

//     AuthEntryPointJwt unauthorizedHandler;

//     public SecurityConfig(AuthEntryPointJwt unauthorizedHandler) {
//         this.unauthorizedHandler = unauthorizedHandler;
//     }

//     @Bean
//     AuthTokenFilter authenticationTokenJwtFilter() {
//         return new AuthTokenFilter();
//     }
    
//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//         return 
//         httpSecurity
//         .csrf(csrf -> csrf.disable())
//         .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//         .httpBasic(Customizer.withDefaults())
//         .build();
//     }

//     @Bean
//     PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//         return builder.getAuthenticationManager(); 
//     }

// }
