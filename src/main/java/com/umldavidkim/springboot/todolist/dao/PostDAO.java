package com.umldavidkim.springboot.todolist.dao;

import java.util.List;

import com.umldavidkim.springboot.todolist.entity.Post;

public interface PostDAO {
	
	List<Post> findAll();
	Post findById(int theId);
	void save(Post thePost);
	void deleteById(int theId);
	List<Post> findAllOrderByPriority();
}
