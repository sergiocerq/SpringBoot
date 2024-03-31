package org.applications.aprendendoautenticacao.controllers;


import org.applications.aprendendoautenticacao.dtos.ResponseDTO;
import org.applications.aprendendoautenticacao.dtos.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public String getUser() {
        return "sucesso pivete!";
    }
}
