package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.respository.StudentRepository;

@Service
public class StudentService implements IStudentService
{
	@Autowired
	StudentRepository studentRepository;
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student updateStudent(Student student) {
		Student currentStudent= studentRepository.getById(student.getStudentId());
		currentStudent.setFirstName(student.getFirstName());
		currentStudent.setLastName(student.getLastName());
		currentStudent.setCgpa(student.getCgpa());
		currentStudent.setMiddleName(student.getMiddleName());
		currentStudent.setDateOfEnrollment(student.getDateOfEnrollment());
		currentStudent.setStudentNumber(student.getStudentNumber());	
		return studentRepository.save(currentStudent);
	}
	public Student getStudentById(long id) {
		return studentRepository.getById(id);
	}
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
		
	}
}
