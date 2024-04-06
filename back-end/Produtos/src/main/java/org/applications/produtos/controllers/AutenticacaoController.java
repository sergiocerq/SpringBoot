package org.applications.produtos.controllers;

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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        return autenticacaoService.login(loginDTO);

        //var authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.senha());
        //var authentication = authenticationManager.authenticate(authenticationToken);
        //System.out.println(loginDTO.email());
        //var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        //return ResponseEntity.ok(new ResponseDTO(token));

    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody LoginDTO loginDTO) {
        //var authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.senha());
        //var authentication = authenticationManager.authenticate(authenticationToken);
       // var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());
       // return ResponseEntity.ok(new ResponseDTO(token));
        return null;
    }
}
