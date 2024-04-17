package com.api.restcourseapp.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restcourseapp.course.bean.Course;
import com.api.restcourseapp.course.repository.CourseRepository;

@RestController
public class CourseRestConrtoller {
	
	@Autowired
	CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
	}
	
	@GetMapping("courses/{id}")
	public Course getCourseById(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("No Course present with id=" + id);
		}
		return course.get();
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PutMapping("courses/{id}")
	public void updateCourseById(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
	
	@DeleteMapping("courses/{id}")
	public void deleteCourseById(@PathVariable long id) {
		Optional<Course> courseToDelete = repository.findById(id);
		if(courseToDelete.isEmpty()) {
			throw new RuntimeException("No Course present with id=" + id + "\nNothing to delete");
		}
		repository.deleteById(id);
	}
}
