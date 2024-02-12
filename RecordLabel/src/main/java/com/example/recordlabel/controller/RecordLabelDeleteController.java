package com.example.recordlabel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.service.RecordLabelService;

@RestController
@RequestMapping("records")
public class RecordLabelDeleteController {
	@Autowired
	private RecordLabelService service;
	
	@Autowired
	private RecordLabelGetController getController;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RecordLabel> deleteRecord(@PathVariable Integer id){
		RecordLabel toRemove = getController.getRecordLabel(id).getBody();
		if(toRemove == null) return ResponseEntity.notFound().build();
		service.deleteRecord(id);
		return ResponseEntity.ok(toRemove);
	}
}
