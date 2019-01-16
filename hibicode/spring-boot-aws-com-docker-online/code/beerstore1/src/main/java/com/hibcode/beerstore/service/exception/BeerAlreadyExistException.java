package com.hibcode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

public class BeerAlreadyExistException extends BusinessException {

	private static final long serialVersionUID = 49467394730095618L;

	public BeerAlreadyExistException() {
		super("beers-5", HttpStatus.BAD_REQUEST);
	}

}
