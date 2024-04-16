package com.api.restcourseapp.course.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long id;
	
	private String author;
	
	private String name;
	
	public Course() {
		}

	public Course(long id, String author, String name) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", author=" + author + ", name=" + name + "]";
	}
	
	
}
