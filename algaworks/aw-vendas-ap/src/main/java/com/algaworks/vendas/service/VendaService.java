package com.algaworks.vendas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.vendas.model.Venda;
import com.algaworks.vendas.repository.ProdutosRepository;
import com.algaworks.vendas.repository.VendasRepository;

@Service
public class VendaService {

    @Autowired
    private VendasRepository repositoryVenda;

    @Autowired
    private ProdutosRepository repositoryProduto;

    public Venda adicionar(Venda venda) {
	venda.setCadastro(LocalDateTime.now());
	venda.getItens().forEach(i -> {
	    i.setVenda(venda);
	    i.setProduto(repositoryProduto.findById(i.getProduto().getId()).get());
	});

	BigDecimal totalItens = venda.getItens().stream().map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
		.reduce(BigDecimal.ZERO, BigDecimal::add);

	venda.setTotal(totalItens.add(venda.getFrete()));

	return repositoryVenda.save(venda);

    }
}
