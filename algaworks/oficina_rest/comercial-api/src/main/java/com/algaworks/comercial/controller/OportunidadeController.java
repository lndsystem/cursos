package com.algaworks.comercial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.repository.OportunidadeRepository;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

	@Autowired
	private OportunidadeRepository repository;

	@GetMapping
	public List<Oportunidade> listar() {
		return repository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oportunidade salvar(@Valid @RequestBody Oportunidade oportunidade) {

		if (repository.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto())
				.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe uma Oportunidade com este prospecto com a mesma descrição.");
		}

		return repository.save(oportunidade);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {
		Optional<Oportunidade> findById = repository.findById(id);

		if (findById.isPresent())
			return ResponseEntity.ok(findById.get());

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Oportunidade update(@PathVariable Long id, @Valid @RequestBody Oportunidade oportunidade) {

		Optional<Oportunidade> findById = repository.findById(id);
		if (findById.isPresent() == false)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id da oportunidade não existe!");
		else if (oportunidade.getId() != null && oportunidade.getId().longValue() != id.longValue())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id da URL é diferente do Objeto");

		oportunidade.setId(findById.get().getId());
		return repository.save(oportunidade);
	}
}
