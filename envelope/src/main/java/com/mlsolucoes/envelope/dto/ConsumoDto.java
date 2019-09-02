package com.mlsolucoes.envelope.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ConsumoDto {

	private final Integer[] medidas = { 1000, 5000, 15000, 30000, 50000, 70000, 100000, 300000, 500000, 750000,
			1000000, 2000000, 3000000, 99999999 };

	private BigInteger idTamanho;
	private String tamanho;
	private BigInteger idGramatura;
	private String gramatura;
	private BigInteger idCor;
	private String cor;
	private BigInteger projeto;
	private BigDecimal qtde;
	private BigDecimal valor;

	private List<QtdVlrDto> valores;

	public ConsumoDto(BigInteger idTamanho, String tamanho, BigInteger idGramatura, String gramatura, BigInteger idCor,
			String cor, BigInteger projeto, BigDecimal qtde, BigDecimal valor) {
		this.idTamanho = idTamanho;
		this.tamanho = tamanho;
		this.idGramatura = idGramatura;
		this.gramatura = gramatura;
		this.idCor = idCor;
		this.cor = cor;
		this.projeto = projeto;
		this.qtde = qtde;
		this.valor = valor;

		this.valores = new ArrayList<>();
		boolean add = true;
		for (int i = 0; i < 14; i++) {
			if (qtde.intValue() <= medidas[i] && add) {
				valores.add(new QtdVlrDto(this.qtde.intValue(), this.valor));
				add = false;
			} else
				valores.add(new QtdVlrDto(0, new BigDecimal("0.00")));
		}
	}
}
