package com.example.AssignmentProject.service;

import java.util.List;
import java.util.Optional;

import com.example.AssignmentProject.entity.Departs;


public interface DepartsService {
	
	List<Departs> findAll();
	
	Optional<Departs> search(Integer ID);
	void save(Departs departs);
	void delete(Integer ID);

}
