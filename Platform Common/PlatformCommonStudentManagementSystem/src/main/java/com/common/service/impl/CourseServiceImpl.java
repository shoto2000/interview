package com.common.service.impl;

import java.time.LocalDate;
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
import com.common.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private AdminSessionRepo adminSessionRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Course uploadCourse(Course course, String uuid) throws CourseException, LoginException{
		
		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);
		
		if(!currAdminOpt.isPresent()) {
			throw new LoginException("Admin is not logged in to perform this operation or the uuid is incorrect");
		}
		
		Optional<Course> opt1 = courseRepo.findByCourseName(course.getCourseName());
		if(opt1.isPresent()) {
			throw new CourseException("Course Already present with given name");
		}
		
		List<Student> students = course.getStudents();

		for (Student student : students) {

			// associating each student with course
			student.getCourses().add(course);

		}

		return courseRepo.save(course);
	}

	@Override
	public Course registerCourseToStudent(String uniqueCode, Course course, String uuid)
			throws StudentException, LoginException {
		Optional<CurrentAdminSession> currAdminOpt = adminSessionRepo.findByUuid(uuid);

		if (currAdminOpt.isPresent()) {
			Student student = studentRepo.findByUniqueStudentCode(uniqueCode);
			if(course!=null) {
				
				course.getStudents().add(student);
				student.getCourses().add(course);
				
				return courseRepo.save(course);
			}
			else
				throw new StudentException("Student not found with Student unique code");
		}
		else {
			throw new LoginException("Admin is not logged in to perform this operation or the uuid is incorrect");
		}
	}

	@Override
	public List<Course> allCoursesAssignedToStudent(Integer id, LocalDate dob)
			throws StudentException, CourseException {
		Optional<Student> student= studentRepo.findStudentByIdAndDOB(id, dob);
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with given id and dob");
		}
		
		List<Course> courselist= student.get().getCourses();
		
		if(courselist.isEmpty()) {
			throw new CourseException("No course assigned to the student");
		}	
		
		return courselist;
	}

	@Override
	public List<Course> removeCoursefromStudent(Integer stuid, LocalDate dob, Integer courseId)
			throws StudentException, CourseException {
		
       Optional<Student> student= studentRepo.findStudentByIdAndDOB(stuid, dob);
		
		if(student.isEmpty()) {
			throw new StudentException("No student found with given id and Date of Birth");
		}
		
      Optional<Course> course= courseRepo.findById(courseId);
		
		if(course.isEmpty()) {
			throw new CourseException("No course found with given courseid");
		}
		
		boolean flag=true;
		List<Course> courselist=student.get().getCourses();
		
		for(int i=0;i<courselist.size();i++) {
			
			if(courselist.get(i).getCourseId()==courseId) {
				student.get().getCourses().remove(i);
				flag=false;
			}
		}
		if(flag) {
			
			throw new StudentException("Student have not been assigned to the given course");
		}
		
      List<Student> studentlist=course.get().getStudents();
		
		for(int i=0;i<studentlist.size();i++) {
			
			if(studentlist.get(i).getStudentId()==stuid) {
				course.get().getStudents().remove(i);
			}
		}
		
		Student updatedStudent= studentRepo.save(student.get());
		
		if(updatedStudent.getCourses().isEmpty()) {
			throw new CourseException("Course removed successfully, no courses left for the given student");
		}
		
		return updatedStudent.getCourses();
	}	

}
