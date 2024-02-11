package com.example.recordlabel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recordlabel.model.RecordLabel;
import com.example.recordlabel.service.RecordLabelService;



@RestController
public class RecordLabelGetController {
	
	@Autowired
	private RecordLabelService service;
	
	@GetMapping("/records")
	public List<RecordLabel> getRecordLabels(){
		return service.getAllRecords();
	}
}
