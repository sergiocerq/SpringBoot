package org.applications.produtos.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "Realiza a criação do token JWT. Utiliza a issuer 'api-login', email e possui um tempo de expiração de 3 horas.")
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
            throw new RuntimeException("Error while generating the token", exception);
        }
    }

    @Operation(description = "Faz a geração do tempo de expiração do token. No caso, são 3 Horas")
    public Instant gerarTempoExpiracaoToken() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    @Operation(description = "Faz a validação do Token com base no algoritmo, issuer e subject.")
    public String validarToken(String token) {
        try {
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
              .withIssuer("api-login")
              .build()
              .verify(token)
              .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("An error occurred verifying the token: ", exception);
        }
    }
}
