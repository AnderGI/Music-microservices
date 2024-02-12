package com.example.recordlabel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.service.RecordLabelService;

@RestController
@RequestMapping("records")
public class RecordLabelPutController {
	@Autowired
	private RecordLabelService service;
	
	@Autowired
	private RecordLabelGetController getController;
	
	@PutMapping("/{id}")
	public ResponseEntity<RecordLabel> updateRecord(@PathVariable Integer id, @RequestBody RecordLabel toUpdate) {
		// Valido si existe record en ese id que me pasan
		RecordLabel record = getController.getRecordLabel(id).getBody();
		if(record == null) return ResponseEntity.notFound().build();
		// Record existe 
		// Como nos lo pasan como un request body pueden no pasarnos el id
		// Le añadimos el id del path variabl
		toUpdate.setId(id);
		// LLamamos al servicio para que intente actualizar
		toUpdate = service.updateRecord(toUpdate);
		
		if(toUpdate == null) return ResponseEntity.unprocessableEntity().body(toUpdate);
		
		return ResponseEntity.ok(toUpdate);
		
		
	}
}
