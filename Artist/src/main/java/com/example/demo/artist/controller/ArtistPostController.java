package com.example.demo.artist.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.artist.model.Artist;
import com.example.demo.artist.service.ArtistaService;

@RestController
@RequestMapping("artists")
public class ArtistPostController {

	@Autowired
	private ArtistaService service;
	@Autowired
	private RestTemplate temp;
	
	@PostMapping("")
	public ResponseEntity<Artist> addArtists(@RequestBody Artist nuevo) throws URISyntaxException{
		//Verificar que existe ese recordId
		try {
			temp.getForEntity("http://recordlabelsms/records/{id}", Object.class, nuevo.getRecordId());
		}catch(HttpClientErrorException.NotFound exp) {
			return ResponseEntity.notFound().build();
		}
		// Validamos si los campos necesarios estás
		nuevo = service.addArtist(nuevo);
		if(nuevo == null) 
			return ResponseEntity.unprocessableEntity().body(nuevo);
		URI uri = new URI("artists/" + nuevo.getId());
		return ResponseEntity.created(uri).body(nuevo);
		
	}
	
}
