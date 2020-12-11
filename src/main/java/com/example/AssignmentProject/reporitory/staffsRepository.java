package com.example.AssignmentProject.reporitory;


import com.example.AssignmentProject.entity.Staffs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface staffsRepository extends JpaRepository<Staffs, String> {

	@Query(value = "select * form Staffs st where st.Fullname like %:Fullname%",nativeQuery = true)
	public List<Staffs> findByName(@Param("Fullname") String Name);
}

