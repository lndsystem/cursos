package com.example.algamoney.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.CategoriaRepository;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.CategoriaInexistenteException;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Lancamento salvar(Lancamento lancamento) {
		validarLancamento(lancamento);

		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento buscarLancamentoPeloCodigo(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return lancamento;
	}

	public Lancamento atualizar(Long codigo, @Valid Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoPeloCodigo(codigo);

		validarLancamento(lancamento);
		
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		lancamentoRepository.save(lancamentoSalvo);


		return lancamentoSalvo;
	}
	
	private void validarLancamento(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if (pessoa.isPresent() == false || pessoa.get().isInativo())
			throw new PessoaInexistenteOuInativaException();
		
		Optional<Categoria> categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo());
		if(categoria.isPresent() == false)
			throw new CategoriaInexistenteException();
	}
}
