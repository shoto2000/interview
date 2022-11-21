package com.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.common.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{
	public Optional<Course> findByCourseName(String cname);
}
