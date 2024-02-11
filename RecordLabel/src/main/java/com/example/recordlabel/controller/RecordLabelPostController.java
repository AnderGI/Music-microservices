package com.example.recordlabel.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.service.RecordLabelService;

@RestController
public class RecordLabelPostController {
	@Autowired
	private  RecordLabelService service;
	
	@PostMapping("/records")
	public  ResponseEntity<RecordLabel> addRecord(@RequestBody RecordLabel record) throws URISyntaxException{
		record = service.addRecord(record);
		if(record == null) {
			return ResponseEntity.unprocessableEntity().body(record);
		}
		
		URI uri = new URI("/records/" + record.getId());
		return ResponseEntity.created(uri).build();
	}
}
