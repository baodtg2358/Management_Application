package com.example.AssignmentProject.service;

import java.util.List;
import java.util.Optional;

import com.example.AssignmentProject.entity.Staffs;

public interface staffsService  {

	Iterable<Staffs> findAll();
	
	List<Staffs> search(String name);
	
	Optional<Staffs> findByID(String ID);
	
	void save(Staffs staffs);
	void delete(String ID);
}
