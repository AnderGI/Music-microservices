package com.example.recordlabel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.service.RecordLabelService;



@RestController
@RequestMapping("records")
public class RecordLabelGetController {
	
	@Autowired
	private RecordLabelService service;
	
	@GetMapping("")
	public ResponseEntity<List<RecordLabel>> getRecordLabels(){
		return ResponseEntity.ok(service.getAllRecords());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RecordLabel> getRecordLabel(@PathVariable Integer id) {
		RecordLabel record = service.getRecordById(id);
		if(record == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(record);
	}
}
