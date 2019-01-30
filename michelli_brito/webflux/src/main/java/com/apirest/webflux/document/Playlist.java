package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Document
public class Playlist {

	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String nome;
}
