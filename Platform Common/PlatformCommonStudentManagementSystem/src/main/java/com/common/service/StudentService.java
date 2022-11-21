package com.common.service;

import java.util.List;

import com.common.entity.Student;
import com.common.exception.CourseException;
import com.common.exception.LoginException;
import com.common.exception.StudentException;

public interface StudentService {
	public Student admitNewStudent(Student student, String uuid) throws Exception, LoginException;
	
	public Student registerStudentInCourse(String cname, Student student,String uuid) throws CourseException, LoginException, Exception;
	
	public List<Student> getStudentsByName(String name,String uuid) throws StudentException, LoginException;
	
	public Student updateStudentDetails(Student student)throws StudentException;
}
