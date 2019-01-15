package com.example.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
