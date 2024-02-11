package com.example.recordlabel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recordlabel.model.RecordLabel;

@Repository
public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer>{

}
