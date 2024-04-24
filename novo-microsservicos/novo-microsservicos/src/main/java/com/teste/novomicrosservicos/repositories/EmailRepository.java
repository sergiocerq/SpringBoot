package com.teste.novomicrosservicos.repositories;

import com.teste.novomicrosservicos.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {

}
