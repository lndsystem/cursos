package com.mlsolucoes.envelope.exception;

public class InsumoJaExiste extends RuntimeException {

	private static final long serialVersionUID = 7107388056942734430L;

	private String mensagem;

	public InsumoJaExiste(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
