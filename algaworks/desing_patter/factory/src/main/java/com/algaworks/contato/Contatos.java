package com.algaworks.contato;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.thoughtworks.xstream.XStream;

public class Contatos {

	public List<Contato> recuperarContatosCSV(String nomeArquivo) {
		List<Contato> contatos = new ArrayList<>();

		CSVReader reader = null;
		try {
			URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();

			reader = new CSVReader(new FileReader(new File(uri)));
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				contatos.add(new Contato(nextLine[0].split(";")[0], nextLine[0].split(";")[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
				}
		}

		return contatos;
	}

	@SuppressWarnings("unchecked")
	public List<Contato> recuperarContatoXML(String nomeArquivo) {
		XStream xstream = new XStream();
		xstream.alias("contatos", List.class);
		xstream.alias("contato", Contato.class);

		URL url = this.getClass().getResource("/" + nomeArquivo);
		return (List<Contato>) xstream.fromXML(url);
	}

}
