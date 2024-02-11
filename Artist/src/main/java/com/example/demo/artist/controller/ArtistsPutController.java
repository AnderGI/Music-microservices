package com.example.demo.artist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.artist.model.Artist;
import com.example.demo.artist.service.ArtistaService;

@RestController
public class ArtistsPutController {
	@Autowired
	private ArtistaService service;
	@Autowired
	private ArtistGetController getController;
	
	@PutMapping("/artists/{id}")
	public ResponseEntity<Artist> updateArtist(@PathVariable Integer id, @RequestBody Artist artist){
		//Validamos que haya algún artista con ese id
		Artist existe = getController.getArtistById(id).getBody();
		if(existe == null) return ResponseEntity.notFound().build();
		// Artista con id existente le añadimos el id al de existente al artista que nos pasan
		// y actualizamos el registro que tiene ese id
		artist.setId(existe.getId());
		artist = service.updateArtist(artist);
		if(artist == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(artist);
		
	}
}
