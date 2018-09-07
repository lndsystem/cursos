package com.algaworks.maladireta;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.contato.Contato;

public class MalaDireta {

	public boolean enviarEmail(String string, String mensagem) {

		List<Contato> contatos = new ArrayList<>();

		System.out.println("Conectando no servidor SMTP...");
		System.out.println("Mensagem a ser enviada: " + mensagem);
		System.out.println();

		for (Contato contato : contatos) {
			System.out.println("From: <contato@algaworks.com>");
			System.out.printf("To: [%s] <%s\n>", contato.getNome(), contato.getEmail());
			System.out.println(mensagem);
			System.out.println();
		}

		return true;
	}

}
