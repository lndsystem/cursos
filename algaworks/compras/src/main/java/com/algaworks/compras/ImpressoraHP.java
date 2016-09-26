package com.algaworks.compras;

import org.springframework.stereotype.Component;

@Component
public class ImpressoraHP implements Impressora {

	@Override
	public void imprimir(String mensagem) {
		System.out.println(">>>>>>Imprimindo na HP: " + mensagem);
	}

}
