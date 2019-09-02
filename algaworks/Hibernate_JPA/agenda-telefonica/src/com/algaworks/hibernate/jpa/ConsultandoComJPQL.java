package com.algaworks.hibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.hibernate.jpa.modelo.Agenda;

public class ConsultandoComJPQL {

    public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaPU");

	EntityManager em = emf.createEntityManager();

	List<Agenda> resultList = em.createQuery("from Agenda", Agenda.class).getResultList();

	resultList.forEach(System.out::println);
    }
}
