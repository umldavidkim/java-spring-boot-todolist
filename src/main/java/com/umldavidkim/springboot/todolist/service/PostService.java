package com.umldavidkim.springboot.todolist.service;

import java.util.List;

import com.umldavidkim.springboot.todolist.entity.Post;

public interface PostService {

	List<Post> findAll();
	Post findById(int theId);
	void save(Post thePost);
	void deleteById(int theId);
	List<Post> findAllOrderByPriority();
}
