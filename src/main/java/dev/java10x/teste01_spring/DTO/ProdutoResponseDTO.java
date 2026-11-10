package dev.java10x.teste01_spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class ProdutoResponseDTO { // recebe

    private Integer id;
    private String nome;
    private double preco;
}
