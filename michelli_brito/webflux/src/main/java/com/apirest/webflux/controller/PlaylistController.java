package com.apirest.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class PlaylistController {

	@Autowired
	public PlaylistService service;

	@GetMapping(value = "/playlist")
	public Flux<Playlist> getPlaylist() {
		return service.findAll();
	}

	@GetMapping(value = "/playlist/{id}")
	public Mono<Playlist> getPlaylistId(@PathVariable String id) {
		return service.findById(id);
	}

	@PostMapping(value = "/playlist")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Playlist> save(@RequestBody Playlist playlist) {
		return service.save(playlist);
	}

}
