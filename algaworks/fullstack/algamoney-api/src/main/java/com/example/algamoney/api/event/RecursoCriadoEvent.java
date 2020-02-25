package com.example.algamoney.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2064530064807991908L;

	private HttpServletResponse response;
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

}
