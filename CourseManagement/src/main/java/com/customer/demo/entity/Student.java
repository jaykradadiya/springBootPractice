package com.customer.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tbl_student",uniqueConstraints = 
		@UniqueConstraint(name="email_address_unique",columnNames = "email_address")
)
public class Student {
	
	@Id
	@SequenceGenerator(name="student_id_sequence",sequenceName = "student_id_sequence",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id_sequence")
	private long studentId;
	private String firstName;
	private String lastName;
	@Column(name="email_address",nullable = false)
	private String emailId;
	
	@Embedded
	private Gardian gardian;
}
