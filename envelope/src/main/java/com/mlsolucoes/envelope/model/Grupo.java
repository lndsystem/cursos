package com.mlsolucoes.envelope.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "idTamanho", "idGramatura", "idColor", "sequencia"}))
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idTamanho")
	private Tamanho tamanho;

	@ManyToOne
	@JoinColumn(name = "idGramatura")
	private Gramatura gramatura;

	@ManyToOne
	@JoinColumn(name = "idColor")
	private Color color;

	private Integer sequencia;
}
