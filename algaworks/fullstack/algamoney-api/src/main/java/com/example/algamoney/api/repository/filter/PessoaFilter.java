package com.example.algamoney.api.repository.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFilter {
	private String nome;
	private String uf;
	private boolean ativo = true;
}
