package com.algaworks.vendas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.vendas.model.Cliente;
import com.algaworks.vendas.repository.ClienteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClientesResource {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> listar() {
	return repository.findAll();
    }
}
