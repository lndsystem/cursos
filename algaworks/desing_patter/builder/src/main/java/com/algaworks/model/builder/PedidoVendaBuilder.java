package com.algaworks.model.builder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.algaworks.model.Cliente;
import com.algaworks.model.ItemPedido;
import com.algaworks.model.PedidoVenda;

public class PedidoVendaBuilder {

	private PedidoVenda instance;

	public PedidoVendaBuilder() {
		instance = new PedidoVenda();
	}

	public PedidoVendaBuilder comClienteVip(String nome) {
		definirCliente(nome, true);
		return this;
	}

	public PedidoVendaBuilder comClienteNormal(String nome) {
		definirCliente(nome, false);
		return this;
	}

	public PedidoVendaBuilder comDataEmissao(String dataEmissao) {
		try {
			this.instance.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(dataEmissao));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public PedidoVendaBuilder comItem(String nome, Integer quantidade, Double valorUnitario) {
		ItemPedido item = new ItemPedido();
		item.setNome(nome);
		item.setQuantidade(quantidade);
		item.setValorUnitario(new BigDecimal(valorUnitario));

		if (this.instance.getItensPedido() == null)
			this.instance.setItensPedido(new ArrayList<ItemPedido>());

		this.instance.getItensPedido().add(item);

		return this;
	}

	public PedidoVendaBuilder comItem(String nome, Integer quantidade, String valorUnitario) {
		return comItem(nome, quantidade, new BigDecimal(valorUnitario).doubleValue());
	}

	public PedidoVendaBuilderValido comNumero(String numero) {
		this.instance.setNumero(numero);
		return new PedidoVendaBuilderValido(instance);
	}

	private void definirCliente(String nome, boolean vip) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setVip(vip);
		this.instance.setCliente(cliente);
	}
}
