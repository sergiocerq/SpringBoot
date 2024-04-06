package org.applications.aprendendoautenticacao.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.applications.aprendendoautenticacao.entities.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                      .withIssuer("api-login")
                      .withSubject(user.getEmail())
                      .withExpiresAt(generateExpirationTime())
                      .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating the token.");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                      .withIssuer("api-login")
                      .build()
                      .verify(token)
                      .getSubject();
        } catch (JWTVerificationException jwtVerificationException) {
            return null;
        }
    }

    private Instant generateExpirationTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
