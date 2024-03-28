package org.applications.firstcrud.dtos;

import org.applications.firstcrud.entities.Produtos;

public record ProdutoDTO(String nome, Double preco, String tipo) {
    public ProdutoDTO(Produtos p) {
        this(p.getNome(), p.getPreco(), p.getTipo());
    }

}
