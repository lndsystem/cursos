package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.model.Cliente;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");

		EntityManager em = emf.createEntityManager();

		Cliente find = em.find(Cliente.class, 1l);

		System.out.println(find.toString());
	}
}
