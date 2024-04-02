package org.applications.autenticacaousername.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.applications.autenticacaousername.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                      .withIssuer("api-login-with-username")
                      .withSubject(user.getUsername())
                      .withExpiresAt(generateExpirationTime())
                      .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error on creating the token.");
        }
    }

    public Instant generateExpirationTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                  .withIssuer("api-login-with-username")
                  .build()
                  .verify(token)
                  .getSubject();
    }

}
