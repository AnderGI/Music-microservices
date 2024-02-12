package com.example.demo.artist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.artist.model.Artist;
import com.example.demo.artist.service.ArtistaService;

@RestController
@RequestMapping("artists")
public class ArtistDeleteController {
	@Autowired
	private ArtistaService service;
	@Autowired
	private ArtistGetController getController;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Artist> deleteArtist(@PathVariable Integer id){
		Artist toDeleteArtist = getController.getArtistById(id).getBody();
		// Validamos si el artista existe
		if(toDeleteArtist == null) return ResponseEntity.notFound().build();
		service.removeArtist(toDeleteArtist.getId());
		return ResponseEntity.ok(toDeleteArtist);
	}
}
