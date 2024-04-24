package com.teste.novomicrosservicos.services;

import com.teste.novomicrosservicos.dtos.ClienteDTO;
import com.teste.novomicrosservicos.entities.Cliente;
import com.teste.novomicrosservicos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream().map(ClienteDTO::new).toList();
    }

    public ResponseEntity createCliente(ClienteDTO novoCliente) {
        Cliente c = new Cliente(novoCliente);
        clienteRepository.save(c);
        return ResponseEntity.ok(new ClienteDTO(c));
    }

    public ResponseEntity atualizarCliente(ClienteDTO clienteAntigo) {
        var c = clienteRepository.findById(clienteAntigo.id());
        if(c.isPresent()) {
            Cliente novo = c.get();
            novo.setEmail(clienteAntigo.email());
            novo.setNome(clienteAntigo.nome());
            clienteRepository.save(novo);

            return ResponseEntity.ok(new ClienteDTO(novo));
        }

        return ResponseEntity.notFound().build();
    }

}
