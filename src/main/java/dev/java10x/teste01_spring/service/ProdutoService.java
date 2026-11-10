package dev.java10x.teste01_spring.service;

import dev.java10x.teste01_spring.DTO.ProdutoRequestDTO;
import dev.java10x.teste01_spring.DTO.ProdutoResponseDTO;
import dev.java10x.teste01_spring.exception.RecursoNaoEncontrado;
import dev.java10x.teste01_spring.model.ProdutoEntity;
import dev.java10x.teste01_spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponseDTO save(ProdutoRequestDTO produtoRequestDTO ){
        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());
        ProdutoEntity save = produtoRepository.save(produto);
        return new ProdutoResponseDTO(save.getId(), save.getNome(), save.getPreco());
    }
    public List<ProdutoEntity> listar(){
        return produtoRepository.findAll();
    }
    public ProdutoResponseDTO buscar(Integer id){
        ProdutoEntity produto = produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado());
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }
    public ProdutoResponseDTO atualizar(Integer id, ProdutoRequestDTO produtoResponseDTO){
        ProdutoEntity p = produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado());
        p.setNome(produtoResponseDTO.getNome());
        p.setPreco(produtoResponseDTO.getPreco());
        ProdutoEntity atualizado = produtoRepository.save(p);
        return new ProdutoResponseDTO(atualizado.getId(), atualizado.getNome(), atualizado.getPreco());

    }
    public void deletar(Integer id){
        ProdutoEntity p = produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado());
        produtoRepository.delete(p);
    }

}
