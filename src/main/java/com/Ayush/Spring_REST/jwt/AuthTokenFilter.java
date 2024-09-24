// package com.Ayush.Spring_REST.jwt;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.Ayush.Spring_REST.service.JwtService;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class AuthTokenFilter extends OncePerRequestFilter {

//     private JwtService jwtUtils;
//     private UserDetailsService userDetailsService;
    
//     public AuthTokenFilter(JwtService jwtUtils, UserDetailsService userDetailsService) {
//         this.jwtUtils = jwtUtils;
//         this.userDetailsService = userDetailsService;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//                 try {
//                     String jwt = jwtUtils.getJwtFromHeader(request);
//                     if(jwt != null && jwtUtils.validateJwtToken(jwt)) {
//                         String username = jwtUtils.getUserNameFromJwtToken(jwt);

//                         UserDetails userDetails = userDetailsService.loadUserByUsername(username);

//                         UsernamePasswordAuthenticationToken authenticationToken = 
//                             new UsernamePasswordAuthenticationToken(null, userDetails.getAuthorities());

//                         authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        
//                         SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                     }
//                 } catch (Exception e) {
//                     System.out.println(e.getMessage());
//                 }

//                 filterChain.doFilter(request, response);
//     }
// }
