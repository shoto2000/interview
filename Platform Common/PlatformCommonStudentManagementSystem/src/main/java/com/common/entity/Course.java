package com.common.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@NotNull(message = "Course Name is Required")
	private String courseName;
	@NotNull(message = "Course Description is Required")
	private String courseDescription;
	@NotNull(message = "Course Type is Required")
	private String courseType;
	@NotNull(message = "Course Duration in Months is Required")
	private Integer courseDurationMonths;
	@NotNull(message = "Topic Name is Required")
	private String Topic;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();
}
