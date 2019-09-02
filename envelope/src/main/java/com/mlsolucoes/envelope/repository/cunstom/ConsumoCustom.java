package com.mlsolucoes.envelope.repository.cunstom;

import java.util.List;

import com.mlsolucoes.envelope.dto.ConsumoDto;
import com.mlsolucoes.envelope.filter.ConsumoFilter;

public interface ConsumoCustom {

	public List<ConsumoDto> pesquisarConsumo(ConsumoFilter consumoFilter);
}
