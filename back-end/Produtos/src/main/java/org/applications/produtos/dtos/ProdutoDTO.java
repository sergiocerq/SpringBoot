package org.applications.produtos.dtos;

import org.applications.produtos.entities.Produto;

import java.util.Optional;

public record ProdutoDTO(String id, String nome, Double preco, Integer quantidade) {
    public ProdutoDTO(Produto p) {
        this(p.getId(), p.getNome(), p.getPreco(), p.getQuantidade());
    }

}
