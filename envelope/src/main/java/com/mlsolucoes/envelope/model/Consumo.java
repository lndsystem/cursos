package com.mlsolucoes.envelope.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Consumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idInsumo")
	private Insumo insumo;

	private Date entradaNotaFiscal;

	private BigDecimal qtdFornecido;

	private BigDecimal valorTotal;

	@Enumerated(EnumType.STRING)
	private TipoMaterial tipoMaterial;

}
