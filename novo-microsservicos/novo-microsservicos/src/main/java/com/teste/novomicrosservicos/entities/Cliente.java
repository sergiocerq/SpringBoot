package com.teste.novomicrosservicos.entities;

import com.teste.novomicrosservicos.dtos.ClienteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;

    public Cliente(ClienteDTO clienteDTO) {
        this.email = clienteDTO.email();
        this.nome = clienteDTO.nome();
        this.id = clienteDTO.id();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
