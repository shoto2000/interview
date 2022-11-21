package com.common.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.entity.AdminLogin;
import com.common.entity.AdminSignin;
import com.common.entity.Course;
import com.common.entity.Student;
import com.common.exception.CourseException;
import com.common.exception.LoginException;
import com.common.exception.LogoutException;
import com.common.exception.SigninException;
import com.common.exception.StudentException;
import com.common.service.AdminLoginService;
import com.common.service.AdminService;
import com.common.service.CourseService;
import com.common.service.StudentService;

@RestController
public class Controller {
	@Autowired
	private AdminLoginService adminLoginService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/admin")
	public AdminSignin saveAdmin(@RequestBody AdminSignin admin) throws SigninException {
		return adminService.createAdmin(admin);
	}
	
	@PostMapping("/adminLogin")
	public String loginAdmin(@RequestBody AdminLogin admin) throws LoginException {
		return adminLoginService.loginAdminAccount(admin);
	}
	
	@PatchMapping("/adminLogout")
	public String logoutAdmin(@RequestParam(required = false) String uuid) throws LogoutException {
		return adminLoginService.logoutAdminAccount(uuid);
	}
	
	@PostMapping("/admin/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student,@RequestParam String uuid) throws StudentException, Exception{
		Student addedStudent = studentService.admitNewStudent(student, uuid);
		
		return new ResponseEntity<>(addedStudent,HttpStatus.CREATED);
	}
	
	@PostMapping("/admin/courses")
	public ResponseEntity<Course> saveCourseHandler(@RequestBody Course course, @RequestParam String uuid) throws Exception, CourseException, LoginException{
		
		Course savedCourse= courseService.uploadCourse(course,uuid);
		
		
		return new ResponseEntity<Course>(savedCourse,HttpStatus.CREATED);
	}
	
	@PostMapping("/admin/students/{cname}")
	public ResponseEntity<Student> registerStudentInCourseHandler(@PathVariable("cname") String cname, @RequestBody Student student, @RequestParam String uuid) throws Exception, CourseException, LoginException{
		
		
		
		Student enrolledStudent= studentService.registerStudentInCourse(cname, student, uuid);
		
		
		return new ResponseEntity<Student>(enrolledStudent, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/admin/students/{name}")
	public List<Student> getStudentByNameHandler(@PathVariable String name, @RequestParam String uuid) throws StudentException, LoginException {
	
		return  studentService.getStudentsByName(name, uuid);
		
	}
	
	@PostMapping("/admin/courses/{uniqueCode}")
	public ResponseEntity<Course> registerCourseInStudentHandler(@PathVariable("uniqueCode") String uniqueCode, @RequestBody Course course, @RequestParam String uuid) throws CourseException, LoginException, StudentException{
		
		
		
		Course enrolledCourse = courseService.registerCourseToStudent(uniqueCode, course, uuid);
		
		
		return new ResponseEntity<Course>(enrolledCourse, HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/student/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student updatedStudent= studentService.updateStudentDetails(student);
		
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		
	}
	
	@GetMapping("/student/courses")
	public ResponseEntity<List<Course>> coursesAssignedToStudentHandler(@RequestHeader ("id") Integer id, @RequestHeader ("dob") String dob) throws StudentException, CourseException{
		
		LocalDate dateOfBirth= LocalDate.parse(dob);
		
		List<Course> courselist= courseService.allCoursesAssignedToStudent(id,dateOfBirth);
		
		return new ResponseEntity<List<Course>>(courselist,HttpStatus.OK);
			
	}
	
	@DeleteMapping("/student/removecourse/{courseId}")
	public ResponseEntity<List<Course>> removecoursfromAssignedStudentHandler(@PathVariable Integer courseId,@RequestHeader ("id") Integer id, @RequestHeader ("dob") String dob) throws StudentException, CourseException{
		
		LocalDate dateOfBirth= LocalDate.parse(dob);
		
		List<Course> courselist= courseService.removeCoursefromStudent(id, dateOfBirth, courseId);
		
		return new ResponseEntity<List<Course>>(courselist,HttpStatus.OK);
			
	}
}
