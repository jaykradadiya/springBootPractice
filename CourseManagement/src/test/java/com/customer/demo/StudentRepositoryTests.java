package com.customer.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.demo.entity.Gardian;
import com.customer.demo.entity.Student;
import com.customer.demo.repository.StudentRepository;


@SpringBootTest
public class StudentRepositoryTests {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Test
	public void saveStudent() {
		
		Gardian gardian = new Gardian();
		gardian.setEmail("shradhdha@gmail.com");
		gardian.setMobile("1234567890");
		gardian.setName("shradhdha");
		
		Student stu = new Student();
		stu.setFirstName("jay");
		stu.setLastName("Radadiya");
		stu.setEmailId("jay@gmail.com");
		stu.setGardian(gardian);
		
		
		studentRepository.save(stu);
		
	}
	
	@Test
	public void saveStudentWithoutEmail() {
		
		Gardian gardian = new Gardian();
		gardian.setEmail("shradhdha@gmail.com");
		gardian.setMobile("1234567890");
		gardian.setName("shradhdha");
		
		Student stu = new Student();
		stu.setFirstName("jjjj");
		stu.setLastName("Radadiya");
		stu.setEmailId("jay@gmail.com");
		stu.setGardian(gardian);
		
		studentRepository.save(stu);
	}
	
	
	
	@Test
	public void displayAllStudent() {
		List<Student> students = studentRepository.findAll();
		
		System.out.println("students ");
		
		for(Student  s  : students) {
			System.out.println(s);
		}
	}
	
	@Test
	public void displayAllStudentByName() {
		List<Student> students = studentRepository.findByFirstName("jay");
		
		System.out.println("students first name jay ");
		
		for(Student  s  : students) {
			System.out.println(s);
		}
	}
	
	@Test
	public void displayAllStudentByNameContaining() {
		List<Student> students = studentRepository.findByFirstNameContaining("ay");
		
		System.out.println("students fist name contiaing ay");
		
		for(Student  s  : students) {
			System.out.println(s);
		}
	}

}
