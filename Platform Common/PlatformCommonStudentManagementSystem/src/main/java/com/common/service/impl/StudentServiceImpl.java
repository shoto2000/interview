package com.common.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.entity.Course;
import com.common.entity.CurrentAdminSession;
import com.common.entity.Student;
import com.common.exception.CourseException;
import com.common.exception.LoginException;
import com.common.exception.StudentException;
import com.common.repository.AdminSessionRepo;
import com.common.repository.CourseRepo;
import com.common.repository.StudentRepo;
import com.common.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private AdminSessionRepo adminSessionRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public Student admitNewStudent(Student student, String uuid) throws Exception, LoginException {

		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);

		if (currAdminOpt.isPresent()) {
			
			List<Student> listStu = studentRepo.findAll();
			
			for(Student stu:listStu) {
				if(stu.getUniqueStudentCode().equals(student.getUniqueStudentCode())) {
					throw new Exception("unique Student code already Exist: "+student.getUniqueStudentCode());
				}
			}
			
			return studentRepo.save(student);
		}
		else {
			throw new LoginException("Admin not Logged in");
		}
	}

	@Override
	public Student registerStudentInCourse(String cname, Student student, String uuid) throws CourseException, LoginException, Exception {
		
		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);

		if (currAdminOpt.isPresent()) {
			Optional<Course> courseOpt = courseRepo.findByCourseName(cname);
			List<Student> listStu = studentRepo.findAll();
			
			for(Student stu:listStu) {
				if(stu.getUniqueStudentCode().equals(student.getUniqueStudentCode())) {
					throw new Exception("unique Student code already Exist: "+student.getUniqueStudentCode());
				}
			}
			
			if(courseOpt.isPresent()) {
				
				courseOpt.get().getStudents().add(student);
				student.getCourses().add(courseOpt.get());
				
				return studentRepo.save(student);
			}
			else
				throw new CourseException("Course not found with name "+cname);
		}
		else {
			throw new LoginException("Admin is not logged in to perform this operation or the uuid is incorrect");
		}
	
	}

	@Override
	public List<Student> getStudentsByName(String name, String uuid) throws StudentException, LoginException {
		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);
		
		if(currAdminOpt.isPresent()) {
			List<Student> students= studentRepo.findByName(name);
			
			
			if(students.size() > 0)
				return students;
			else
				throw new StudentException("Student does not exist with Name "+name);
			
		
		}
		else {
			throw new LoginException("Admin is not logged in to perform this operation or the uuid is incorrect");
		}
	}

	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		Optional<Student> opt= studentRepo.findById(student.getStudentId());
		
		
		if(opt.isPresent()) {
			
			return studentRepo.save(student);
			
			
			//here save method will perform as saveOrUpdate based on Id field
			
		}
		else
			throw new StudentException("Invalid Student details");
	}

}
