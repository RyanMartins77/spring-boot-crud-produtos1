package dev.java10x.teste01_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Entity
@Table(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true, length = 30)
    private String nome;
    private double preco;

}
