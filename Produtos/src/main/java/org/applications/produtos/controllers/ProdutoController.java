package org.applications.produtos.controllers;

import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.applications.produtos.dtos.ProdutoDTO;
import org.applications.produtos.repositories.ProdutoRepository;
import org.applications.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable String id) {
        return produtoService.atualizarProduto(produtoDTO, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ProdutoDTO> apagarProduto(@PathVariable String id) {
        return produtoService.apagarProduto(id);
    }

}
