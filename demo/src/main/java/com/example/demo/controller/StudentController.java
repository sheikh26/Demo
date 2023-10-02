package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
//@RequestMapping("student")
@Component
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
//   @RequestMapping("/empform")  
//   public String showform(Model m){  
//   	m.addAttribute("command", new Emp());
//   	return "empform"; 
//   } 
   
   @GetMapping(value = {"/","/registration"})
   public String registration(Model model) {
      model.addAttribute("student", new StudentDTO());
      return "student-add-update";
   }
   
//   @PostMapping("/registerStudent")
//   public String createStudent(@ModelAttribute("student") StudentDTO studentDto) {
//	   
//	   if(studentDto != null) {
//		   studentService.createOrUpdateStudent(studentDto);
//	   }
////	   logger.debug("This is a DEBUG statement");
////		logger.warn("This is a WARN statement");
////		logger.error("This is a ERROR statement");
//     
//      return "redirect:/list";   
//   }
   
   
//   @RequestMapping(value = UrlHandler.GET_AUTHENTICATION, 
//		    produces = {"application/json"}, 
//		    consumes = {"application/json"}, 
//		    method = RequestMethod.POST
//		)
   @ResponseBody
   @RequestMapping(value="/registerStudent",method = RequestMethod.POST , consumes = "application/xml" , produces = "application/xml")  
   public StudentDTO createStudent(@RequestBody StudentDTO studentDto){  
	   studentService.createOrUpdateStudent(studentDto);
	      return studentDto;   
   }  
   
   //using post man
//   @PostMapping("/registerStudent")
//   @ResponseBody
//   public String createStudent(@RequestBody StudentDTO studentDto) {
//	   logger.debug("This is a DEBUG statement");
//		logger.warn("This is a WARN statement");
//		logger.error("This is a ERROR statement");
//      studentService.createOrUpdateStudent(studentDto);
//      return studentDto.getFirstName();   
//   }
   
	 @Scheduled(initialDelay = 10000, fixedDelay = 30000 )
	 @Scheduled(cron = "0 0 * * * *")
	 public void markExpired() { 
	  logger.info("Welcome to my channel : {}", new Date());
	 }
   @GetMapping("/list")
   public String listOfStudent(Model model) {
	    logger.fatal("This is a list method");
	    logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      List<StudentDTO> studentList = studentService.getAllStudent();
      model.addAttribute("studentList", studentList);
      logger.info("This is a studentList arif "+studentList.size());
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
	   logger.info("This is a delete Method");
	   logger.debug("This is a DEBUG statement");
		logger.warn("This is a WARN statement");
		logger.error("This is a ERROR statement");
      studentService.deleteStudent(Long.parseLong(id));
      logger.debug("Deleted ID is -> "+ id);
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
