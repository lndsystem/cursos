package com.mlsolucoes.envelope.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QtdVlrDto {

	private Integer qtd;
	private BigDecimal valor;
}
