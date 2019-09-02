package com.mlsolucoes.envelope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlsolucoes.envelope.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
