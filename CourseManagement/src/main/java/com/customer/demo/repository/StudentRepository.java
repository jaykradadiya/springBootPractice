package com.customer.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String name);
	
	List<Student> findByFirstNameContaining(String name);

	List<Student> findByGardianIsNull();
	
	List<Student> findByGardianName(String gardianName);
	
	Student findByFirstNameAndLastName(String firstName,String lastName);
	
	@Query("Select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	@Query("Select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	
	
	@Query(value="select * from tbl_student s where s.email_address = ?1 ",nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);
	
	
}
