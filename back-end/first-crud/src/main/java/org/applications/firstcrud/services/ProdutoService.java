package org.applications.firstcrud.services;

import org.applications.firstcrud.dtos.ProdutoDTO;
import org.applications.firstcrud.entities.Produtos;
import org.applications.firstcrud.repostitories.ProdutoRepository;
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
    public List<ProdutoDTO> listarProdutos() {
        return produtoRepository.findAll()
                                .stream()
                                .map(ProdutoDTO::new)
                                .toList();
    }

    public ResponseEntity cadastrarProduto(ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        Produtos produto = new Produtos(produtoDTO);
        produtoRepository.save(produto);
        return ResponseEntity.created(uriBuilder.path("/produtos/{id}")
                             .buildAndExpand(produto.getId()).toUri())
                             .body(new ProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> atualizarProduto(Integer id, ProdutoDTO produtoDTO) {
        Optional<Produtos> op = produtoRepository.findById(id);

        if(!op.isEmpty()) {
            Produtos produto = op.get();
            produto.changeName(produtoDTO.nome());
            produto.changePrice(produtoDTO.preco());
            produto.changeTypeProduct(produtoDTO.tipo());
            return ResponseEntity.ok(new ProdutoDTO(produto));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProdutoDTO> deletaProduto(Integer id) {
        Optional<Produtos> op = produtoRepository.findById(id);
        if(!op.isEmpty()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok(new ProdutoDTO(op.get()));
        }

        return ResponseEntity.notFound().build();
    }


}
