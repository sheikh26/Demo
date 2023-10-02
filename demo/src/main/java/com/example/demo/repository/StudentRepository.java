 package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


	@Repository
	public interface StudentRepository extends JpaRepository<Student, Long>{

	
	public List<Student> findByFirstName(String firstName);
	
	@Query("select s from Student s")
	public List<Student> getAllStudents();
	
	@Query("select s from Student s WHERE 	s.firstName =:n")
	public List<Student> getStudentByFirstName(@Param("n") String name);
}
