package com.example.recordlabel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.repository.RecordLabelRepository;


@Service
public class RecordLabelService {
	@Autowired
	private RecordLabelRepository repository;
	
	public List<RecordLabel> getAllRecords(){
		return repository.findAll();
	}
	
}
