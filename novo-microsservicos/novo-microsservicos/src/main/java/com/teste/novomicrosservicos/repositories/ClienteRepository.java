package com.teste.novomicrosservicos.repositories;

import com.teste.novomicrosservicos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
