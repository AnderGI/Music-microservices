package com.example.demo.artist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.artist.model.Artist;
import com.example.demo.artist.service.ArtistaService;

@RestController
@RequestMapping("artists")
public class ArtistGetController {
	@Autowired
	private ArtistaService service;
	
	@GetMapping("")
	public ResponseEntity<List<Artist>> getAllArtist(){
		List<Artist> artists = service.getAllArtistsSortedByIdDesc();
		if(artists == null) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(artists);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artist> getArtistById(@PathVariable Integer id){
		Artist artist = service.getArtistById(id);
		if(artist == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(artist);
	}

}
