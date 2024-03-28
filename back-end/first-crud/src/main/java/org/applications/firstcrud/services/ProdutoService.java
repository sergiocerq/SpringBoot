package org.applications.firstcrud.services;

import org.applications.firstcrud.dtos.ProdutoDTO;
import org.applications.firstcrud.entities.Produtos;
import org.applications.firstcrud.repostitories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public List<ProdutoDTO> listarProdutos() {
        return produtoRepository.findAll()
                                .stream()
                                .map(ProdutoDTO::new)
                                .collect(Collectors.toList());
    }

    public ResponseEntity cadastrarProduto(ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        Produtos produto = new Produtos(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.created(uriBuilder.path("/produtos/{id}")
                             .buildAndExpand(produto.getId()).toUri()).body(new ProdutoDTO(produto));
    }

}
