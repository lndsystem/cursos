package com.example.algamoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@ConfigurationProperties(prefix = "algamoney")
public class AlgamoneyApiProperty {

	private final Seguranca seguranca = new Seguranca();

	private String origemPermitida = "http://localhost:4200";

	@Getter
	@Setter
	public static class Seguranca {
		private boolean enableHttps;
	}

}
