package com.lndsystem.model;

import java.math.BigDecimal;

public class NotaFiscalPessaoJuridica extends NotaFiscal {

	private static final BigDecimal porcentagem = new BigDecimal("0.04");

	@Override
	public BigDecimal calcularImposto(BigDecimal valorTotal) {
		return valorTotal.multiply(porcentagem);
	}

}
