package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * The below commented lines work for CourseJdbcRepository & 
		 * CourseJpaRepository, both.
		 * For CourseSpringDataJpaRepository,
		 * insert() becomes save() & 
		 * deleteById() & findById() arguments require to be casted to Long
		 * */
		
//		repository.insert(new Course(1, "Learn AWS", "in28minutes"));
//		repository.insert(new Course(2, "Learn Azure", "in28minutes"));
//		repository.insert(new Course(3, "Learn DevOps", "in28minutes"));
//		
//		repository.deleteById(1);
//		
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
		
		/* 		---SPRING DATA JPA from this point on---	 */
		
		repository.save(new Course(1, "Learn AWS", "in28minutes"));
		repository.save(new Course(2, "Learn Azure", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps", "in28minutes"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		/*		---CUSTOM METHODS BELOW---	*/
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn AWS"));	// empty[] will be printed as its deleted
		System.out.println(repository.findByName("Learn Azure"));
		
	}

}
