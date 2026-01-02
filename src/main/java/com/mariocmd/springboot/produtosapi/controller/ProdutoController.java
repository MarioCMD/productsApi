package com.mariocmd.springboot.produtosapi.controller;

import com.mariocmd.springboot.produtosapi.model.Produto;
import com.mariocmd.springboot.produtosapi.reporitory.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Criando o produto: " + produto);
        String uuid = UUID.randomUUID().toString();
        produto.setId(uuid);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto getProduto(@PathVariable String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

}
