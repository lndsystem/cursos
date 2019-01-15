package com.algaworks.agenda.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.agenda.modal.Agenda;

public class AgendaTeste {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaPU");

		EntityManager em = emf.createEntityManager();

		Agenda agenda = new Agenda();
		agenda.setNome("Leandro Coelho e Silva");
		agenda.setTelefone("11985473588");
		agenda.setDataRegistro(new Date());

		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();

		System.out.println(agenda.toString());

	}
}
