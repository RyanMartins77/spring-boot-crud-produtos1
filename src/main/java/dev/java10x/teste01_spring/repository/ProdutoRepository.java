package dev.java10x.teste01_spring.repository;

import dev.java10x.teste01_spring.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer>{

}
