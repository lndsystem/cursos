package com.lndsystem;

import com.lndsystem.dao.DAO;
import com.lndsystem.domain.Person;

import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;

public class PersonCrud implements CrudHandler {

	private DAO dao;

	public PersonCrud(DAO dao) {
		this.dao = dao;
	}

	@Override
	public void create(Context arg0) {
		Person person = arg0.bodyAsClass(Person.class);
		this.dao.save(person);
		arg0.json(person);
	}

	@Override
	public void delete(Context arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAll(Context arg0) {
		arg0.json(this.dao.findAll());
	}

	@Override
	public void getOne(Context arg0, String id) {
		arg0.json(this.dao.findById(Integer.parseInt(id)));
	}

	@Override
	public void update(Context arg0, String arg1) {
		// TODO Auto-generated method stub

	}

}
