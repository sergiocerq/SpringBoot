package org.applications.aprendendoautenticacao.controllers;

import lombok.RequiredArgsConstructor;
import org.applications.aprendendoautenticacao.config.security.TokenService;
import org.applications.aprendendoautenticacao.dtos.RequestDTO;
import org.applications.aprendendoautenticacao.dtos.ResponseDTO;
import org.applications.aprendendoautenticacao.dtos.UserDTO;
import org.applications.aprendendoautenticacao.entities.User;
import org.applications.aprendendoautenticacao.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
//É tipo um gerenciador de @Autowired, do lombok.
@RequiredArgsConstructor
public class AuthController {

    //@Autowired aqui em tudo também iria servir
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO userDTO) {
        User user = this.userRepository
                .findByEmail(userDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(passwordEncoder.matches(userDTO.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RequestDTO requestDTO) {
        Optional<User> user = this.userRepository.findByEmail(requestDTO.email());
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(requestDTO.email());
            newUser.setPassword(passwordEncoder.encode(requestDTO.password()));
            newUser.setUsername(requestDTO.username());
            userRepository.save(newUser);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getEmail(), token));
        }

        return ResponseEntity.badRequest().build();
    }
}
