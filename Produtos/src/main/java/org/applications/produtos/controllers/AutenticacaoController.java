package org.applications.produtos.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.applications.produtos.dtos.LoginDTO;
import org.applications.produtos.dtos.ResponseDTO;
import org.applications.produtos.entities.Usuario;
import org.applications.produtos.services.AutenticacaoService;
import org.applications.produtos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AutenticacaoService autenticacaoService;

    @Operation(description = "Faz a validação do login e, em caso de sucesso, retorna o token")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso. Retorna o token JWT."),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
    })
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        return autenticacaoService.login(loginDTO);
    }

}
