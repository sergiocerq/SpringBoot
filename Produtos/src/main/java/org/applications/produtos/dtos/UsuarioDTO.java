package org.applications.produtos.dtos;

import org.applications.produtos.entities.Role;

import java.util.List;

public record UsuarioDTO(String email, String nome, String senha, List<Role> roles) {

}
