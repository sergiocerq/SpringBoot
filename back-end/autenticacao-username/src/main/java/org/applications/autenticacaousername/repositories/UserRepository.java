package org.applications.autenticacaousername.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.applications.autenticacaousername.entities.*;

public interface UserRepository extends JpaRepository<User, String> {
}
