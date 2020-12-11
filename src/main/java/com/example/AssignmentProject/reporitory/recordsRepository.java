package com.example.AssignmentProject.reporitory;

import com.example.AssignmentProject.entity.Records;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface recordsRepository extends JpaRepository<Records, Integer> {
	
	@Query(value = "select * from Records rc where rc.Staffs_ID = :StaffsID", nativeQuery = true)
	public List<Records> findAllByStaffsID(@Param("StaffsID") String ID);
}
