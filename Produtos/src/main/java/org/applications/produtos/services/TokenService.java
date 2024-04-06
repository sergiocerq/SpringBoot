package org.applications.produtos.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.applications.produtos.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.secret.token}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            System.out.println(usuario.getUsername());
            return JWT.create()
                      .withIssuer("api-login")
                      .withSubject(usuario.getUsername())
                      .withExpiresAt(gerarTempoExpiracaoToken())
                      .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    public Instant gerarTempoExpiracaoToken() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validarToken(String token) {
        System.out.println("Token no validarTOken: " + token);
        try {
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                      .withIssuer("api-login")
                      .build()
                      .verify(token)
                      .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro na verificação do token", exception);
        }
    }
}
