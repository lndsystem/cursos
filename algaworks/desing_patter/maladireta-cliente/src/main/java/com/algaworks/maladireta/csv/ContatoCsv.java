package com.algaworks.maladireta.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.contato.Contato;
import com.algaworks.contato.Contatos;
import com.opencsv.CSVReader;

public class ContatoCsv implements Contatos {

	private String nomeArquivo;

	public ContatoCsv(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public List<Contato> todos() {

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

}
