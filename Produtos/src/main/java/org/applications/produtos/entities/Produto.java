package org.applications.produtos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.applications.produtos.dtos.ProdutoDTO;

@Entity(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    public Produto(ProdutoDTO p) {
        this.id = p.id();
        this.nome = p.nome();
        this.preco = p.preco();
        this.quantidade = p.quantidade();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull(message = "O nome não pode ser nulo!")
    private String nome;
    @DecimalMin("0")
    private Double preco;
    @NotNull(message = "A quantidade não pode ser nula ou menor que 0!")
    @DecimalMin("0")
    private Integer quantidade;

}
