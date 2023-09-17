package edu.mum.cs.cs425.demowebapps.eregistrar.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	@NotEmpty(message="Please enter a stduent number.")
	private String studentNumber;
	@NotEmpty(message="Please enter a first name.")
	private String firstName;
	private String middleName;
	@NotEmpty(message="Please enter a last name.")
	private String lastName;
	private double cgpa;
	@NotNull(message="Please provide an enrollment date.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfEnrollment;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transcript_id")
	private Transcript transcript;
	
	
	public Student()
	{
		
	}
	public Student(long studentId,String studentNumber,String firstName,String lastName,double cgpa, LocalDate dateOfEnrollment)
	{
		this.studentId=studentId;
		this.studentNumber=studentNumber;
		this.firstName=firstName;
		this.lastName=lastName;
		this.cgpa=cgpa;
		this.dateOfEnrollment= dateOfEnrollment;
	}
	
	public Student(long studentId,String studentNumber,String firstName,String middleName,String lastName,double cgpa, LocalDate dateOfEnrollment)
	{
		this.studentId=studentId;
		this.studentNumber=studentNumber;
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.cgpa=cgpa;
		this.dateOfEnrollment= dateOfEnrollment;	
	}
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studenId) {
		this.studentId = studenId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}		
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

}