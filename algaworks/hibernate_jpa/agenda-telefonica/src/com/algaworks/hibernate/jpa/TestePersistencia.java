package com.algaworks.hibernate.jpa;

import java.util.Date;

import com.algaworks.hibernate.jpa.modelo.Agenda;
import com.algaworks.hibernate.jpa.modelo.Connection;

public class TestePersistencia {
    public static void main(String[] args) {

	Connection<Agenda, Long> conn = new Connection<>(Agenda.class, "agendaPU");

	Agenda a = new Agenda();
	a.setNome("Leandro");
	a.setTelefone("11985473588");
	a.setDataRegistro(new Date());

	a = conn.save(a);

	System.out.println(a.toString());

	Agenda findOne = conn.findOne(a.getCodigo().longValue() - 1);
	System.out.println("Find One: " + findOne.toString());

	conn.remove(findOne.getCodigo());
    }
}
