package org.applications.firstcrud.repostitories;

import org.applications.firstcrud.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {
}
