package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloTest {
	@GetMapping("/Hello")
	   public String Hello() {
		  System.out.println("Arif sheikh");
	      return "student-list";   
	   }

}
