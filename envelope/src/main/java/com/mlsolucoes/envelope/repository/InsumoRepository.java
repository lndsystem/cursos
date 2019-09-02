package com.mlsolucoes.envelope.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mlsolucoes.envelope.model.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

	public Optional<Insumo> findByCodigo(String codigo);

	@Query(value = "SELECT * FROM Insumo WHERE id=:id", nativeQuery = true)
	public Optional<Insumo> pesquisarPorId(@Param("id") Integer id);

}
