package com.lndsystem.model;

import java.math.BigDecimal;

public class NotaFiscalPessoaFisica extends NotaFiscal {

	private static final BigDecimal porcentagem = new BigDecimal("0.07");

	@Override
	public BigDecimal calcularImposto(BigDecimal valorTotal) {
		return valorTotal.multiply(porcentagem);
	}

}
