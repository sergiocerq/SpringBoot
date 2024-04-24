package com.teste.novomicrosservicos.dtos;

import com.teste.novomicrosservicos.entities.Cliente;

public record ClienteDTO(String id, String nome, String email) {

    public ClienteDTO(Cliente c) {
        this(c.getId(), c.getNome(), c.getEmail());
    }

}
