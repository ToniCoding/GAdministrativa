package com.gadministrativa.security.config;

import com.gadministrativa.security.service.JwtService;
import com.gadministrativa.security.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Loads the user details like username and role if the token is valid and present.
     * @param request Request received.
     * @param response Response that will be given.
     * @param filterChain The filter chain.
     * @throws ServletException Exception for servlets.
     * @throws IOException Exception for input or output.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = extractToken(request); // Extract the token.

        if (token != null && jwtService.validateToken(token)) { // If token is not null and valid.
            String email = jwtService.extractUsername(token); // Extracts the username based on its active token.

            UserDetails userDetails = userDetailsService.loadUserByUsername(email); // Loads the email.

            // Creates an authenticated user for Spring, ID like.
            // Gets the user details, in this context, email and its roles (authorities).
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            // (Optional) Adds information to the current request like IP address and session ID.
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Allows the endpoints of the API to get the username and roles. The SecurityContextHolder is the one in charged
            // of holding the "ID" of the logged user.
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // Restarts the filter chain now the user is verified.
        filterChain.doFilter(request, response);
    }

    /**
     * Extracts the token from the headers.
     * @param request The HTTP request.
     * @return Token without the starting bearer or null if not found.
     */
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
