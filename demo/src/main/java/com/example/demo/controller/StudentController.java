package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	 private static final Logger logger = LogManager.getLogger(StudentController.class);

   @Autowired
   private StudentService studentService;
   
//   @GetMapping(value = {"/"})
//   //@GetMapping(value = {"/","/registration"})
//   public String registration() {
//      //model.put("student", new StudentDTO());
//      return "student-add-update";
//   }
   
   @GetMapping(value = {"/","/registration"})
   public String registration(Map<String, Object> model) {
      model.put("student", new StudentDTO());
      return "student-add-update";
   }
   
   @PostMapping("/home")
   public String createStudent(StudentDTO studentDto) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      studentService.createOrUpdateStudent(studentDto);
      return "redirect:/list";   
   }
   
   //using post man
//   @PostMapping("/home")
//   @ResponseBody
//   public String createStudent(@RequestBody StudentDTO studentDto) {
//	   logger.debug("This is a DEBUG statement");
//		logger.warn("This is a WARN statement");
//		logger.error("This is a ERROR statement");
//      studentService.createOrUpdateStudent(studentDto);
//      return studentDto.getFirstName();   
//   }
   
   @GetMapping("/list")
   public String listOfStudent(Model model) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      List<StudentDTO> studentList = studentService.getAllStudent();
      model.addAttribute("studentList", studentList);
      return "student-list";
   }
   @GetMapping("/search")
   public String search(Model model) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      return "user-search";
   }
   
   @GetMapping("/byFirstName")
   public String byFirstName(Model model) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      return "user-search-by-name";
   }
   
   @GetMapping("/searchUserByName")
   public String searchUserByName(Model model,@RequestParam("rollNo") Long rollNo) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
	   System.out.println("searchUserByName--method----"+rollNo);
	   List<StudentDTO> studentList = null;
	   studentList = studentService.getStudentByName(rollNo);
	   model.addAttribute("studentList", studentList);
	   return "student-list";
   }
   
   @GetMapping("/findByFirstName")
   public String findByFirstName(Model model,@RequestParam("firstName") String firstName) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
	   System.out.println("searchUserByName--method----"+firstName);
	   List<StudentDTO> studentList = null;
	   studentList = studentService.findByFirstName(firstName);
	   model.addAttribute("studentList", studentList);
	   return "student-list";
   }
  
   
   @PostMapping("/delete")
   public String deleteStudent(@RequestParam("id") String id) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      studentService.deleteStudent(Long.parseLong(id));
      return "redirect:/list";      
   }
   
   @GetMapping("/edit")
   public String editStudent(
         @RequestParam("id") String id, Map<String, Object> model) {
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      StudentDTO studentDTO = studentService
            .editStudent(Long.parseLong(id));
      model.put("student", studentDTO);
      return "student-add-update";
   }
   
}
