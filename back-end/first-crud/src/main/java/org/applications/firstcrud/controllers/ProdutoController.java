package org.applications.firstcrud.controllers;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.applications.firstcrud.dtos.ProdutoDTO;
import org.applications.firstcrud.entities.Produtos;
import org.applications.firstcrud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> getProdutos() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        return produtoService.cadastrarProduto(produtoDTO, uriBuilder);
    }

}
