package com.mlsolucoes.envelope.filter;

import com.mlsolucoes.envelope.model.Color;
import com.mlsolucoes.envelope.model.Gramatura;
import com.mlsolucoes.envelope.model.Tamanho;

import lombok.Data;

@Data
public class ConsumoFilter {

	private Color color;
	private Gramatura gramatura;
	private Tamanho tamanho;
}
