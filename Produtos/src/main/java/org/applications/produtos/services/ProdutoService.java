package org.applications.produtos.services;

import org.applications.produtos.ProdutosApplication;
import org.applications.produtos.dtos.ProdutoDTO;
import org.applications.produtos.entities.Produto;
import org.applications.produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoRepository.findAll()
                                .stream()
                                .map(ProdutoDTO::new)
                                .toList();
    }

    public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> atualizarProduto(ProdutoDTO p, String id) {
        var produto = produtoRepository.findById(id);
        if(produto.isPresent()) {
            Produto produtoAtualizado = produto.get();
            produtoAtualizado.setNome(p.nome());
            produtoAtualizado.setPreco(p.preco());
            produtoAtualizado.setQuantidade(p.quantidade());
            produtoRepository.save(produtoAtualizado);

            return ResponseEntity.ok(new ProdutoDTO(produtoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProdutoDTO> apagarProduto(String id) {
        var produto = produtoRepository.findById(id);
        if(produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
