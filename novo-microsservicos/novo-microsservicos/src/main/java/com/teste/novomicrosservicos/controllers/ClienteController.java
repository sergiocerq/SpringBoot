package com.teste.novomicrosservicos.controllers;


import com.teste.novomicrosservicos.dtos.ClienteDTO;
import com.teste.novomicrosservicos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping
    public ResponseEntity createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.createCliente(clienteDTO);
    }

    @PutMapping
    public ResponseEntity atualizaCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizarCliente(clienteDTO);
    }
}
