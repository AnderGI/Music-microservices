package com.example.demo.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.artist.model.Artist;

public interface ArtistaRepository extends JpaRepository<Artist, Integer> {

}
