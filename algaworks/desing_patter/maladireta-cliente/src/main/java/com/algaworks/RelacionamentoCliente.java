package com.algaworks;

import javax.swing.JOptionPane;

import com.algaworks.maladireta.MalaDireta;
import com.algaworks.maladireta.xml.MalaDiretaXML;

public class RelacionamentoCliente {
	public static void main(String[] args) {

		//MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
		MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
		String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");

		boolean status = malaDireta.enviarEmail(mensagem);

		JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);

	}
}
