package com.algaworks.model.builder;

import com.algaworks.model.PedidoVenda;

public class PedidoVendaBuilderValido {

	private PedidoVenda instance;

	public PedidoVendaBuilderValido(PedidoVenda instance) {
		this.instance = instance;
	}

	public PedidoVenda construir() {
		return this.instance;
	}

}
