package com.example.AssignmentProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssignmentProject.entity.Records;
import com.example.AssignmentProject.reporitory.recordsRepository;
@Service
public class RecordsServiceImpl implements RecordsService {

	@Autowired
	private recordsRepository repo;
	
	@Override
	public List<Records> findAll(String StaffsID) {
		
		return repo.findAllByStaffsID(StaffsID);
	}

	@Override
	public void save(Records record) {
		repo.save(record);
		
	}

}
