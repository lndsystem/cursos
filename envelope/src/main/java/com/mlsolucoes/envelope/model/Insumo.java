package com.mlsolucoes.envelope.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Insumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String codigo;

	private String descricao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idTamanho")
	private Tamanho tamanho;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idGramatura")
	private Gramatura gramatura;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idColor")
	private Color color;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idImpressao")
	private Impressao impressao;

	public Insumo(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
