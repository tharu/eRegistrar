package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;

@Controller
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value= {"/eregistrar/student/list"})
	public ModelAndView listStudents()
	{
		ModelAndView modelView= new ModelAndView();
		List<Student> students= studentService.getStudents();
		System.out.println(students);
		modelView.addObject("students",students);
		modelView.setViewName("student/list");
		return modelView;
	}
	

	@GetMapping(value= {"/eregistrar/student/add"})
	public ModelAndView addStudent(Model model)
	{
		Student student= new Student();
	    ModelAndView modelView= new ModelAndView();
		
	    modelView.addObject("student",student);
		modelView.setViewName("student/add");
		return modelView;
	}
	
	@PostMapping(value= {"/eregistrar/student/add"})
	public String addStudent(@ModelAttribute("student") Student student)
	{
		ModelAndView modelView= new ModelAndView();
		System.out.println("comes here");
		System.out.println(student.getStudentNumber());
		System.out.print(student);
		studentService.saveStudent(student);	
		modelView.addObject("student",student);
		modelView.setViewName("student/add");
		return "redirect:/eregistrar/student/list"; // Redirect back to the student list
		//return modelView;
	}
	
	
	@PostMapping(value= {"/edit/{id}"})
	public String editStudent(@PathVariable long id,@ModelAttribute("student") Student student)
	{
		System.out.println("it comes to edit");
		ModelAndView modelView= new ModelAndView();
		student.setStudentId(id);
		studentService.updateStudent(student);	
		modelView.addObject("student",student);
		modelView.setViewName("student/edit");
		return "redirect:/eregistrar/student/list"; // Redirect back to the student list
		//return modelView;
	}
	
	 @GetMapping("/edit/{id}")
	    public String editStudent(@PathVariable long id, Model model) {
	        Student student = studentService.getStudentById(id);
	        model.addAttribute("student", student);
	        return "student/edit"; // You need to create an edit form template
	    }

	    // Mapping to delete a student
	    @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable long id) {
	        studentService.deleteStudent(id);
	        return "redirect:/eregistrar/student/list"; // Redirect back to the student list
	    }
}
