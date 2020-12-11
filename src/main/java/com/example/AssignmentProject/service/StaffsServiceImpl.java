package com.example.AssignmentProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssignmentProject.entity.Staffs;
import com.example.AssignmentProject.reporitory.staffsRepository;

@Service
public class StaffsServiceImpl implements staffsService {

	@Autowired
	private staffsRepository repo;
	
	@Override
	public Iterable<Staffs> findAll() {
		
		return repo.findAll();
	}

	@Override
	public List<Staffs> search(String name) {
		
		return repo.findByName(name);
	}



	@Override
	public void save(Staffs staffs) {
		repo.save(staffs);
		
	}

	@Override
	public void delete(String ID) {
		repo.deleteById(ID);
		
	}

	@Override
	public Optional<Staffs> findByID(String ID) {
		
		return repo.findById(ID);
	}

}
