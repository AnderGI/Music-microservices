package com.example.demo.artist.service;

import java.util.List;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.demo.artist.model.Artist;
import com.example.demo.artist.repository.ArtistaRepository;

@Repository
public class ArtistaService {

	@Autowired
	private ArtistaRepository repository;
	
	public Artist getArtistById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Artist> getAllArtistsSortedByIdDesc(){
		return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	public Artist addArtist(Artist nuevo) {
		if(nuevo.getName() == null || nuevo.getRecordId() == null) return null;
		return repository.save(nuevo);
	}
	
	public Artist removeArtist(Integer id) {
		Artist toRemove = getArtistById(id);
		if(toRemove == null) return null;
		repository.delete(toRemove);
		return toRemove;
	}
	
	public Artist updateArtist(Artist toUpdate){
		// Valorar que el artista tenga todos los campos
		// Y que no sean nulos
		boolean invalidArtist = toUpdate.getId() == null || 
				toUpdate.getName() == null || toUpdate.getRecordId() == null;
		if(invalidArtist) return null;
		
		return repository.save(toUpdate);
	}
	
}
