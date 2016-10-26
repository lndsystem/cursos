package com.algaworks.brewer.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.StatusVenda;
import com.algaworks.brewer.model.Venda;
import com.algaworks.brewer.repository.Vendas;

@Service
public class CadastroVendaService {

	@Autowired
	private Vendas vendas;

	@Transactional
	public void salva(Venda venda) {
		dataCriacao(venda);
		if (venda.getDataEntrega() != null) {
			venda.setDataHoraEntrega(LocalDateTime.of(venda.getDataEntrega(),
					venda.getHoraEntrega() != null ? venda.getHoraEntrega() : LocalTime.NOON));
		}

		vendas.save(venda);
	}

	@Transactional
	public void emitir(Venda venda) {
		dataCriacao(venda);
		venda.setStatus(StatusVenda.EMITIDO);
		vendas.save(venda);

	}

	private void dataCriacao(Venda venda) {
		if (venda.isNova()) {
			venda.setDataCriacao(LocalDateTime.now());
		}
	}

}
