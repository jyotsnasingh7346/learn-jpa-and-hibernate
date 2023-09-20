package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	/*		--CUSTOM METHODS BELOW--	*/
	
	// These methods do not need any other implementation
	List<Course> findByAuthor(String author);
	
	List<Course> findByName(String name);

}
