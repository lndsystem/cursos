package com.algaworks.curso.jpa2.service;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException(Exception e) {
		super(e);
	}

	public NegocioException(String e) {
		super(e);
	}

}
