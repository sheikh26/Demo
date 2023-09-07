package com.example.demo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) throws BeansException {
		//SpringApplication.run(DemoApplication.class, args);
		
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		StudentRepository studentRepository= context.getBean(StudentRepository.class);
	// Add student//

	//	Student student = new Student();
//	//student.setId((long) 1);
//	student.setFirstName("Faruk");
//	student.setLastName("Khan");
//	student.setEmailId("Mic@gmail.com");
//	
//	Student st = studentRepository.save(student);
//	System.out.println("Saved User"+st);
	
	// Get student//
//	List<Student> 	student =  studentRepository.findByFirstName("Faruk");
//	student.forEach(e->System.out.println(e));
	
	// Get All student by jpa Query//
//	List<Student> 	student =  studentRepository.getAllStudents();
//	student.forEach(e->System.out.println(e));
	
	
	// Get All student by jpa Query//
		List<Student> 	student =  studentRepository.getStudentByFirstName("Faruk");
		student.forEach(e->
		System.out.println(e));
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Student> 	student= studentRepository.getAllStudents();
		student.forEach(e->
		System.out.println(e));
	}

}
