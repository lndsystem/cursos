package com.algaworks.brewer.repository.helper.venda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.algaworks.brewer.model.StatusVenda;
import com.algaworks.brewer.model.Venda;
import com.algaworks.brewer.repository.filter.VendaFilter;
import com.algaworks.brewer.repository.paginacao.PaginacaoUtil;

public class VendasImpl implements VendasQueries {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Venda.class);

		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);

		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private void adicionarFiltro(VendaFilter filtro, Criteria criteria) {
		criteria.createAlias("cliente", "c");

		if (!StringUtils.isEmpty(filtro.getCodigo())) {
			criteria.add(Restrictions.eq("codigo", filtro.getCodigo()));
		}
		if (filtro.getDesde() != null) {
			LocalDateTime deste = LocalDateTime.of(filtro.getDesde(), LocalTime.of(0, 0));
			criteria.add(Restrictions.ge("dataCriacao", deste));
		}
		if (filtro.getAte() != null) {
			LocalDateTime ate = LocalDateTime.of(filtro.getAte(), LocalTime.of(23, 59));
			criteria.add(Restrictions.le("dataCriacao", ate));
		}
		if (filtro.getValorMinimo() != null) {
			criteria.add(Restrictions.ge("valorTotal", filtro.getValorMinimo()));
		}
		if (filtro.getValorMaximo() != null) {
			criteria.add(Restrictions.le("valorTotal", filtro.getValorMaximo()));
		}
		if (filtro.getStatus() != null) {
			criteria.add(Restrictions.eq("status", filtro.getStatus()));
		}
		if (!StringUtils.isEmpty(filtro.getNomeCliente())) {
			criteria.add(Restrictions.like("c.nome", filtro.getNomeCliente(), MatchMode.START));
		}
		if (!StringUtils.isEmpty(filtro.getCpfOuCnpj())) {
			criteria.add(Restrictions.eq("c.cpfOuCnpj", filtro.getCpfOuCnpjSemFormatacao()));
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Venda buscarComItens(Long codigo) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Venda.class);
		criteria.createAlias("itens", "i", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("codigo", codigo));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Venda) criteria.uniqueResult();
	}

	@Override
	public BigDecimal valorTotalNoAno() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(valorTotal) from Venda where year(dataCriacao) = :ano and status = :status",
						BigDecimal.class)
				.setParameter("status", StatusVenda.EMITIDO).setParameter("ano", Year.now().getValue())
				.getSingleResult());
		return optional.orElse(BigDecimal.ZERO);
	}

	private Long total(VendaFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Venda.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	@Override
	public BigDecimal valorTotalNoMes() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(valorTotal) from Venda where month(dataCriacao) = :mes and status = :status",
						BigDecimal.class)
				.setParameter("status", StatusVenda.EMITIDO).setParameter("mes", MonthDay.now().getMonthValue())
				.getSingleResult());
		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public BigDecimal valorTicketMedioAno() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery(
						"select sum(valorTotal)/count(*) from Venda where year(dataCriacao) = :ano and status = :status",
						BigDecimal.class)
				.setParameter("status", StatusVenda.EMITIDO).setParameter("ano", Year.now().getValue())
				.getSingleResult());
		return optional.orElse(BigDecimal.ZERO);
	}

	@Override
	public Long totalClientes() {
		Optional<Long> optional = Optional
				.ofNullable((Long) manager.createQuery("select count(*) from Cliente").getSingleResult());
		return optional.orElse(0l);
	}

	@Override
	public Long totalItensNoEstoque() {
		Optional<Long> optional = Optional
				.ofNullable((Long) manager.createQuery("select sum(quantidadeEstoque) from Cerveja").getSingleResult());
		return optional.orElse(0l);
	}

	@Override
	public BigDecimal valorTotalDoEstoque() {
		Optional<BigDecimal> optional = Optional.ofNullable(manager
				.createQuery("select sum(quantidadeEstoque*valor) from Cerveja", BigDecimal.class)
				.getSingleResult());
		return optional.orElse(BigDecimal.ZERO);
	}
}
