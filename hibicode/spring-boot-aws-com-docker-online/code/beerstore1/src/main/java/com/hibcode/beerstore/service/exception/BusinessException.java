package com.hibcode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -3858051181511063248L;

	private final String code;
	private final HttpStatus status;
}
