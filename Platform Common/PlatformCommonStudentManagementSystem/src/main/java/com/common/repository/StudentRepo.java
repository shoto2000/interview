package com.common.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.common.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	public List<Student> findByName(String name);
	
	public Student findByUniqueStudentCode(String uniqueCode);
	
	@Query("from com.common.entity.Student s where s.studentId=?1 and s.dob=?2")
	public Optional<Student> findStudentByIdAndDOB(Integer Id, LocalDate dob);
}
