package com.mlsolucoes.envelope.repository.cunstom;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mlsolucoes.envelope.dto.ConsumoDto;
import com.mlsolucoes.envelope.filter.ConsumoFilter;

public class ConsumoRepositoryImpl implements ConsumoCustom {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ConsumoDto> pesquisarConsumo(ConsumoFilter consumoFilter) {

		StringBuilder query = new StringBuilder();
		boolean filtro = false;

		query.append("\nselect");
		query.append("\n	CAST(t.id AS SIGNED INTEGER) idTam,t.descricao tam,");
		query.append("\n	CAST(g.id AS SIGNED INTEGER) idGra, g.descricao gram,");
		query.append("\n	CAST(cor.id AS SIGNED INTEGER) idCor, cor.descricao cor,gp.sequencia,");
		query.append("\n	sum(c.qtdFornecido*1000) qtd,sum(c.valorTotal) vlr");
		query.append("\nfrom Consumo c");
		query.append("\n	join Insumo i on c.idInsumo=i.id");
		query.append("\n	left join Tamanho t on i.idTamanho=t.id");
		query.append("\n	left join Gramatura g on i.idGramatura=g.id");
		query.append("\n	left join Color cor on i.idColor=cor.id");
		query.append("\n	join Grupo gp on ");
		query.append("\n		gp.idColor=cor.id and");
		query.append("\n		gp.idGramatura=g.id and ");
		query.append("\n		gp.idTamanho=t.id");
		query.append("\nwhere");
		query.append("\n	t.id is not null and g.id is not null and cor.id is not null");
		if (consumoFilter != null) {
			if (consumoFilter.getColor() != null) {
				query.append("\n	and cor.id=" + consumoFilter.getColor().getId());
				filtro = true;
			}

			if (consumoFilter.getGramatura() != null) {
				query.append("\n	and g.id=" + consumoFilter.getGramatura().getId());
				filtro = true;
			}

			if (consumoFilter.getTamanho() != null) {
				query.append("\n	and t.id=" + consumoFilter.getTamanho().getId());
				filtro = true;
			}
		}
		query.append("\ngroup by");
		query.append("\n	t.id,t.descricao,g.id,g.descricao,cor.id,cor.descricao,gp.sequencia");
//		query.append("\n/*order by");
//		query.append("\n	cor.descricao desc,");
//		query.append("\n	t.id,");
//		query.append("\n	g.descricao*/");

		if (filtro == false) {
			query.append("\nunion");
			query.append("\nselect ");
			query.append("\n	COALESCE(t.id, 0) idTam,COALESCE(t.descricao,'Unknow') tam,");
			query.append("\n	COALESCE(g.id, 0) idGra, COALESCE(g.descricao,'Unknow')gram,");
			query.append("\n	COALESCE(cor.id, 0) idCor, COALESCE(cor.descricao, 'Unknow') cor,0 sequencia,");
			query.append("\n	sum(c.qtdFornecido*1000) qtd,sum(c.valorTotal) vlr");
			query.append("\nfrom Consumo c");
			query.append("\n	join Insumo i on c.idInsumo=i.id");
			query.append("\n	left join Tamanho t on i.idTamanho=t.id");
			query.append("\n	left join Gramatura g on i.idGramatura=g.id");
			query.append("\n	left join Color cor on i.idColor=cor.id");
			query.append("\nwhere");
			query.append("\n	t.id is null or g.id is null or cor.id is null");
			query.append("\ngroup by");
			query.append("\n	t.id,t.descricao,g.id,g.descricao,cor.id,cor.descricao");
		}
//		query.append("\n/*order by");
//		query.append("\n	cor.descricao desc,");
//		query.append("\n	t.id,");
//		query.append("\n	g.descricao*/");

		Query createNamedQuery = manager.createNativeQuery(query.toString());

		List<Object[]> resultList = createNamedQuery.getResultList();

		if (consumoFilter != null && consumoFilter.getColor() == null && consumoFilter.getGramatura() == null
				&& consumoFilter.getTamanho() == null) {
			return resultList.stream()
					.map(o -> new ConsumoDto((BigInteger) o[0], (String) o[1], (BigInteger) o[2], (String) o[3],
							(BigInteger) o[4], (String) o[5], (BigInteger) o[6], (BigDecimal) o[7], (BigDecimal) o[8]))
					.collect(Collectors.toList());
		} else {
			return resultList.stream()
					.map(o -> new ConsumoDto((BigInteger) o[0], (String) o[1], (BigInteger) o[2], (String) o[3],
							(BigInteger) o[4], (String) o[5], new BigInteger(((Integer) o[6]).toString()),
							(BigDecimal) o[7], (BigDecimal) o[8]))
					.collect(Collectors.toList());
		}

	}

}
