package com.example.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
