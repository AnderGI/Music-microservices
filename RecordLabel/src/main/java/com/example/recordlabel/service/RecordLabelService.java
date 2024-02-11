package com.example.recordlabel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.repository.RecordLabelRepository;


@Service
public class RecordLabelService {
	@Autowired
	private RecordLabelRepository repository;
	
	public List<RecordLabel> getAllRecords(){
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public RecordLabel getRecordById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public RecordLabel addRecord(RecordLabel newRecord) {
		if(newRecord.getName() == null) return null;
		return repository.save(newRecord);
	}
	
	public void deleteRecord(Integer id) {
		repository.deleteById(id);
	}
	
	public RecordLabel updateRecord(RecordLabel toUpdate) {
		boolean invalidRecord = toUpdate.getId() == null || toUpdate.getName() == null;
		if(invalidRecord) return null;
		return repository.save(toUpdate);
	}
}
