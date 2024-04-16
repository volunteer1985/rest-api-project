package com.api.restcourseapp.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.restcourseapp.course.bean.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
