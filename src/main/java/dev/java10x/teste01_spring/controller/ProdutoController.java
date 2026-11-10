package dev.java10x.teste01_spring.controller;

import dev.java10x.teste01_spring.DTO.ProdutoRequestDTO;
import dev.java10x.teste01_spring.DTO.ProdutoResponseDTO;
import dev.java10x.teste01_spring.model.ProdutoEntity;
import dev.java10x.teste01_spring.service.ProdutoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listar(){
       return ResponseEntity.ok(produtoService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(produtoService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Integer id, @RequestBody ProdutoRequestDTO produtoRequestDTO){
        ProdutoResponseDTO produtoResponseDTO = produtoService.atualizar(id,produtoRequestDTO);
        return ResponseEntity.ok(produtoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO produtoRequestDTO){
        ProdutoResponseDTO produtoResponseDTO1 = produtoService.save(produtoRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
