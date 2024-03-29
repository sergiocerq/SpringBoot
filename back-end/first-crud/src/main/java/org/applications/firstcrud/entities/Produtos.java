package org.applications.firstcrud.entities;

import jakarta.persistence.*;
import org.applications.firstcrud.dtos.ProdutoDTO;

@Entity(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Double preco;
    private String tipo;

    public Produtos(Integer id, String nome, Double preco, String tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public Produtos(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.nome();
        this.preco = produtoDTO.preco();
        this.tipo = produtoDTO.tipo();
    }

    public Produtos() {

    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void changeName(String nome) {
        this.nome = nome;
    }

    public void changePrice(Double price) {
        this.preco = price;
    }

    public void changeTypeProduct(String type) {
        this.tipo = type;
    }
}
