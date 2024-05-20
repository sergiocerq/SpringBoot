package org.applications.produtos.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Lista todos os produtos cadastrados no banco de dados")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os produtos."),
            @ApiResponse(responseCode = "403", description = "Necessário fazer o Login para listar todos os produtos")
    })
    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @Operation(description = "Cadastra um produto no banco de dados")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto cadastrado."),
            @ApiResponse(responseCode = "403", description = "Necessário fazer o Login para cadastrar um produto!")
    })
    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }

    @Operation(description = "Faz a atualização dos dados de um produto com base no ID do produto.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Atualização dos dados do produto com sucesso."),
            @ApiResponse(responseCode = "400", description = "Produto não encontrado."),
            @ApiResponse(responseCode = "403", description = "Necessário realizar o login para fazer a requisição."),
    })
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable String id) {
        return produtoService.atualizarProduto(produtoDTO, id);
    }

    @Operation(description = "Faz a deleção dos dados de um produto com base no ID de um produto.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Exclusão dos dados do produto feita com sucesso."),
            @ApiResponse(responseCode = "400", description = "Produto não encontrado."),
            @ApiResponse(responseCode = "403", description = "Necessário realizar o login para fazer a requisição."),
            @ApiResponse(responseCode = "403", description = "Usuário sem permissão para fazer a requisição."),
    })
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<ProdutoDTO> apagarProduto(@PathVariable String id) {
        return produtoService.apagarProduto(id);
    }

}
