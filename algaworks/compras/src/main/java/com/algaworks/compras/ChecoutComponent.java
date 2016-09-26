package com.algaworks.compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ChecoutComponent {

	private int count;

	@Autowired
	@Qualifier("impressoraEpson")
	private Impressora impressora;

	public ChecoutComponent(Impressora impressora) {
		this.impressora = impressora;
	}

	public void finalizar() {
		this.impressora.imprimir("compra10.csv");
		count++;
	}

	public int getQuantidadePedidosFinalizados() {
		return count;
	}

}
