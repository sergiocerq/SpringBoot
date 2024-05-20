package org.applications.produtos.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.applications.produtos.dtos.LoginDTO;
import org.applications.produtos.dtos.ResponseDTO;
import org.applications.produtos.entities.Usuario;
import org.applications.produtos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Operation(description = "Busca as credenciais com base no login recebido")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username);
    }

    @Operation(description = "Faz a validação do login e, em caso de sucesso, retorna o token")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso. Retorna o token JWT."),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
    })
    public ResponseEntity login(LoginDTO loginDTO) {
        System.out.println(loginDTO.email());
        System.out.println(loginDTO.senha());
        Usuario user = (Usuario) usuarioRepository.findByEmail(loginDTO.email());
        if(passwordEncoder.matches(loginDTO.senha(), user.getPassword())) {
            String token = tokenService.gerarToken(user);
            return ResponseEntity.ok(new ResponseDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }


}
