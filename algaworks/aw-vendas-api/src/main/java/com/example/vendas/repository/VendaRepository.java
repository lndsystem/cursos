package com.example.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

}
