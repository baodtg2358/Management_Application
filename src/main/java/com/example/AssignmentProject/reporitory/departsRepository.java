package com.example.AssignmentProject.reporitory;

import com.example.AssignmentProject.entity.Departs;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface departsRepository extends JpaRepository<Departs, Integer> {

}
