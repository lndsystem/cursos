package com.example.vendas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendas.model.Produto;
import com.example.vendas.model.Venda;
import com.example.vendas.repository.ProdutoRepository;
import com.example.vendas.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Venda adicionar(Venda venda) {
		venda.setCadastro(LocalDateTime.now());
		venda.getItens().forEach(i -> {
			Produto produto = produtoRepository.findById(i.getProduto().getId()).get();
			i.setVenda(venda);
			i.setProduto(produto);
			i.setValorUnitario(produto.getValor());
		});

		BigDecimal total = venda.getItens().stream().map(i -> i.getValorUnitario().multiply(new BigDecimal(i.getQuantidade()))).reduce(BigDecimal.ZERO, BigDecimal::add);
		venda.setTotal(total.add(venda.getFrete()));

		return vendaRepository.save(venda);
	}
}
