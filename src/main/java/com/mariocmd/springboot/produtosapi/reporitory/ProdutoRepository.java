package com.mariocmd.springboot.produtosapi.reporitory;

import com.mariocmd.springboot.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
