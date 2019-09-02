package com.mlsolucoes.envelope.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlsolucoes.envelope.dto.ConsumoDto;
import com.mlsolucoes.envelope.exception.InsumoJaExiste;
import com.mlsolucoes.envelope.filter.ConsumoFilter;
import com.mlsolucoes.envelope.model.Color;
import com.mlsolucoes.envelope.model.Gramatura;
import com.mlsolucoes.envelope.model.Impressao;
import com.mlsolucoes.envelope.model.Insumo;
import com.mlsolucoes.envelope.model.Tamanho;
import com.mlsolucoes.envelope.repository.ColorRepository;
import com.mlsolucoes.envelope.repository.ConsumoRepository;
import com.mlsolucoes.envelope.repository.GramaturaRepository;
import com.mlsolucoes.envelope.repository.ImpressaoRepository;
import com.mlsolucoes.envelope.repository.InsumoRepository;
import com.mlsolucoes.envelope.repository.TamanhoRepository;

@Service
public class WebServices {

	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private GramaturaRepository gramaturaRepository;
	@Autowired
	private TamanhoRepository tamanhoRepository;
	@Autowired
	private ImpressaoRepository impressaoRepository;
	@Autowired
	private InsumoRepository insumoRepository;
	@Autowired
	private ConsumoRepository consumoRepository;

	public List<Color> getAllColor() {
		return colorRepository.findAll();
	}

	public List<Gramatura> getAllGramatura() {
		return gramaturaRepository.findAll();
	}

	public List<Tamanho> getAllTamanho() {
		return tamanhoRepository.findAll();
	}

	public List<Impressao> getAllImpressao() {
		return impressaoRepository.findAll();
	}

	public Insumo saveInsumo(Insumo insumo) {
		Optional<Insumo> codigoDb = insumoRepository.findByCodigo(insumo.getCodigo());

		if (codigoDb.isPresent() && insumo.getId() == null)
			throw new InsumoJaExiste(String.format("O código '%s' já existe.", insumo.getCodigo()));

		return insumoRepository.save(insumo);
	}

	public List<Insumo> pesquisarInsumo() {
		return insumoRepository.findAll();
	}

	public Optional<Insumo> pesquisarInsumo(Integer id) {
		Optional<Insumo> pesquisarPorId = insumoRepository.pesquisarPorId(id);
		return insumoRepository.findById(id);
	}

	public Optional<Insumo> pesquisarInsumo(String codigo) {
		return insumoRepository.findByCodigo(codigo);
	}

	public void saveList(List<Insumo> insumos) {
		insumoRepository.saveAll(insumos);
	}

	public List<ConsumoDto> pesquisarConsumo(ConsumoFilter consumoFilter) {
		return consumoRepository.pesquisarConsumo(consumoFilter);
	}
}
