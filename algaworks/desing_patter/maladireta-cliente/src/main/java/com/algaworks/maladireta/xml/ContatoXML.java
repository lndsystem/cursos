package com.algaworks.maladireta.xml;

import java.net.URL;
import java.util.List;

import com.algaworks.contato.Contato;
import com.algaworks.contato.Contatos;
import com.thoughtworks.xstream.XStream;

public class ContatoXML implements Contatos {

	private String nomeArquivo;

	public ContatoXML(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contato> todos() {
		XStream xstream = new XStream();
		xstream.alias("contatos", List.class);
		xstream.alias("contato", Contato.class);

		URL url = this.getClass().getResource("/" + nomeArquivo);
		return (List<Contato>) xstream.fromXML(url);
	}

}
