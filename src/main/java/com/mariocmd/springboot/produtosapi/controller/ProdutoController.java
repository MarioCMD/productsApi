package com.mariocmd.springboot.produtosapi.controller;

import com.mariocmd.springboot.produtosapi.model.Produto;
import com.mariocmd.springboot.produtosapi.reporitory.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        produtoRepository.save(produto);
        return produto;
    }

}
