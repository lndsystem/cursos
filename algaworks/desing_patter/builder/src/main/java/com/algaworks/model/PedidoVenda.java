package com.algaworks.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PedidoVenda {

	private String numero;
	private Cliente cliente;
	private List<ItemPedido> itensPedido;
	private Date dataEmissao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;

		for (ItemPedido item : itensPedido) {
			valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
		}

		// se o cliente for vip, 4% de desconto
		if (cliente.isVip()) {
			valorTotal = valorTotal.multiply(new BigDecimal("0.96"));
		}

		return valorTotal;
	}
}
