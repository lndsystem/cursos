package com.algaworks.hibernate.jpa.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection<T, ID> {

    private EntityManagerFactory emf;
    private EntityManager em;

    private Class<?> clazz;

    public Connection(Class<?> clazz, String unit) {
	if (emf == null) {
	    emf = Persistence.createEntityManagerFactory(unit);
	}

	if (em == null || em.isOpen() == false) {
	    em = emf.createEntityManager();
	}
	this.clazz = clazz;

    }

    public void close() {
	if (em.isOpen()) {
	    em.close();
	}

	if (emf.isOpen()) {
	    em.close();
	}
    }

    public T save(T o) {
	em.getTransaction().begin();
	em.persist(o);
	em.getTransaction().commit();

	return o;
    }

    public T findOne(ID id) {
	return (T) em.find(clazz, id);
    }

    public T update(T o) {
	em.getTransaction().begin();
	em.persist(o);
	em.getTransaction().commit();

	return o;
    }

    public void remove(ID id) {
	T findOne = findOne(id);
	if (findOne != null) {
	    em.getTransaction().begin();
	    em.remove(findOne);
	    em.getTransaction().commit();
	}
    }

}
