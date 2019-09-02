package com.mlsolucoes.envelope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlsolucoes.envelope.model.Consumo;
import com.mlsolucoes.envelope.repository.cunstom.ConsumoCustom;

public interface ConsumoRepository extends JpaRepository<Consumo, Long>, ConsumoCustom {

}
