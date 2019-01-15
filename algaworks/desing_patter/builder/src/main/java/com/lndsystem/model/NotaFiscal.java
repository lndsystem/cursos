package com.lndsystem.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class NotaFiscal {

	private Integer numero;
	private Date dataEmissao;
	private List<Produto> produtos;
	private Cliente cliente;

	public abstract BigDecimal calcularImposto(BigDecimal valorTotal);

	public BigDecimal getValorTotal() {
		return produtos.stream().map(p -> p.getValor().multiply(new BigDecimal(p.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
