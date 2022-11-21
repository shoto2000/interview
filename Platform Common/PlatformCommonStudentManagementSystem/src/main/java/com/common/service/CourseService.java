package com.common.service;


import java.time.LocalDate;
import java.util.List;

import com.common.entity.Course;
import com.common.exception.CourseException;
import com.common.exception.LoginException;
import com.common.exception.StudentException;

public interface CourseService {
	public Course uploadCourse(Course course, String uuid) throws Exception, CourseException, LoginException;
	
	public Course registerCourseToStudent(String uniqueCode, Course course,String uuid) throws StudentException, LoginException;
	
	public List<Course> allCoursesAssignedToStudent(Integer id, LocalDate dob)throws StudentException,CourseException;
	
	public List<Course> removeCoursefromStudent(Integer stuid, LocalDate dob, Integer courseId)throws StudentException,CourseException;
}
