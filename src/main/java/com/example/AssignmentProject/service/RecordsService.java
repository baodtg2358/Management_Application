package com.example.AssignmentProject.service;

import java.util.List;

import com.example.AssignmentProject.entity.Records;

public interface RecordsService {
	
	List<Records> findAll(String StaffsID);
	
	void save(Records record);
}
