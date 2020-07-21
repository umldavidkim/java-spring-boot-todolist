package com.umldavidkim.springboot.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="description cannot be empty")
	@Column(name="description")
	private String description;
	
	@Column(name="priority")
	private String priority;
	
	public Post() {
		
	}

	public Post(int id, String description, String priority) {
		this.id = id;
		this.description = description;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", priority=" + priority + "]";
	}
		

}
