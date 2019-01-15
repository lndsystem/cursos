package com.algaworks.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
