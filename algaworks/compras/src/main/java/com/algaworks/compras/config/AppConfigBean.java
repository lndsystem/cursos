package com.algaworks.compras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.compras.Checkout;
import com.algaworks.compras.Impressora;
import com.algaworks.compras.ImpressoraHP;

@Configuration
public class AppConfigBean {

	@Bean
	public Impressora impressora() {
		return new ImpressoraHP();
	}

	@Bean
	public Checkout checkout(Impressora impressora) {
		return new Checkout(impressora);
	}
}
