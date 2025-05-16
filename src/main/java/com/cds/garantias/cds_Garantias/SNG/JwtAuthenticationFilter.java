package com.cds.garantias.cds_Garantias.SNG;

import java.io.IOException;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.public.key}")
    private RSAPublicKey publicKey;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            var jwtDecoder = NimbusJwtDecoder.withPublicKey(publicKey).build();
            var jwt = jwtDecoder.decode(token);

            long codUser = jwt.getClaim("codUser");
            String local = jwt.getClaim("local");

            // Use codUser to avoid unused variable warning
            // System.out.println("codUser: " + codUser);

            // if ("POST".equalsIgnoreCase(request.getMethod())) {
            // if (codUser != 8L || !Objects.equals(local, "external")){
            // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            // response.getWriter().write("Unauthorized!");
            // return;
            // }
            // }

        }

        filterChain.doFilter(request, response);
    }
}
