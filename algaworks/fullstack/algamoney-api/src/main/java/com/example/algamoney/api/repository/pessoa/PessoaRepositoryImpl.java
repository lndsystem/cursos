package com.example.algamoney.api.repository.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Endereco_;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.Pessoa_;
import com.example.algamoney.api.repository.filter.PessoaFilter;
import com.example.algamoney.api.repository.util.PaginacaoUtil;

public class PessoaRepositoryImpl extends PaginacaoUtil implements PessoaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);

		Root<Pessoa> root = criteria.from(Pessoa.class);

		Predicate[] predicates = adicionarPredicates(pessoaFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Pessoa> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<Pessoa>(query.getResultList(), pageable, total(pessoaFilter));
	}

	private Long total(PessoaFilter pessoaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

		Root<Pessoa> root = criteria.from(Pessoa.class);

		Predicate[] predicates = adicionarPredicates(pessoaFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));

		return manager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] adicionarPredicates(PessoaFilter pessoaFilter, CriteriaBuilder builder, Root<Pessoa> root) {
		List<Predicate> precidates = new ArrayList<Predicate>();
		if (StringUtils.isNotBlank(pessoaFilter.getNome()))
			precidates.add(builder.like(builder.lower(root.get(Pessoa_.nome)), "%" + pessoaFilter.getNome().toLowerCase() + "%"));

		if (StringUtils.isNotBlank(pessoaFilter.getUf()))
			precidates.add(builder.equal(builder.lower(root.get(Pessoa_.endereco).get(Endereco_.estado)), pessoaFilter.getUf().toLowerCase()));

		precidates.add(builder.equal(root.get(Pessoa_.ativo), pessoaFilter.isAtivo()));

		return precidates.toArray(new Predicate[precidates.size()]);
	}

}
