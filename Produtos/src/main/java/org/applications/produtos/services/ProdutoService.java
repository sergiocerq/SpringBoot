package org.applications.produtos.services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Lista todos os produtos cadastrados no banco de dados.")
    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoRepository.findAll()
                                .stream()
                                .map(ProdutoDTO::new)
                                .toList();
    }

    @Operation(description = "Cadastra um produto no banco de dados.")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    @Operation(description = "Realiza a atualização das informações de um produto com base em seu ID.")
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

    @Operation(description = "Faz a remoção de um produto com base em seu ID.")
    public ResponseEntity<ProdutoDTO> apagarProduto(String id) {
        var produto = produtoRepository.findById(id);
        if(produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
