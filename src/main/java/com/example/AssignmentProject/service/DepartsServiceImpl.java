package com.example.AssignmentProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssignmentProject.entity.Departs;
import com.example.AssignmentProject.reporitory.departsRepository;

@Service
public class DepartsServiceImpl implements DepartsService {

	@Autowired
	private departsRepository repo;
	
	@Override
	public List<Departs> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Departs> search(Integer ID) {
		
		return repo.findById(ID);
	}

	@Override
	public void save(Departs departs) {
		repo.save(departs);
		
	}

	@Override
	public void delete(Integer ID) {
		repo.deleteById(ID);
		
	}

}
