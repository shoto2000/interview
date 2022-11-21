package com.common.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.common.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	
	@NotNull(message = "First Name is required")
	private String name;
	
	@NotNull(message = "Date of Birth is required")
	private LocalDate dob;
	
	@NotNull(message = "Gender is required")
	private Gender gender;
	
	@Column(unique = true)
	@NotNull(message = "code should be unique")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String uniqueStudentCode;
	
	private String fatherName;
	private String motherName;
	private String mobileNo;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	List<Course> courses = new ArrayList<>();
}

