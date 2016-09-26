package com.algaworks.compras;

import org.springframework.stereotype.Component;

@Component
public class ImpressoraEpson implements Impressora{

	@Override
	public void imprimir(String mensagem) {
		System.out.println(">>>>>>Imprimindo na Epson: " + mensagem);
	}

}
