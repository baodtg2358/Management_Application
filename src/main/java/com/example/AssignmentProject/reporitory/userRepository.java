package com.example.AssignmentProject.reporitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssignmentProject.entity.Users;

@Repository
public interface userRepository extends JpaRepository<Users, String>{

		@Query(value = "select*from Users us where us.Username = :Username",nativeQuery = true)
		Users findByUsers(@Param("Username") String username);

}
