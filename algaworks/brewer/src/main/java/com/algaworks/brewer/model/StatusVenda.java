package com.algaworks.brewer.model;

public enum StatusVenda {
	ORCAMENTO ("Orçamento"),
	EMITIDO ("Emitido"),
	CANCELADO("Cancelado");
	
	private final String descricao;
	
	StatusVenda(final String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
