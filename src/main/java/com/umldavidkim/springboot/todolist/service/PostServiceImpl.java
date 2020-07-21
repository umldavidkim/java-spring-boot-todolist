package com.umldavidkim.springboot.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umldavidkim.springboot.todolist.dao.PostDAO;
import com.umldavidkim.springboot.todolist.entity.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	@Qualifier("postDAOImpl")
	PostDAO postDAO;
	
	@Override
	@Transactional
	public List<Post> findAll() {
		return postDAO.findAll();
	}
	
	@Override
	@Transactional
	public List<Post> findAllOrderByPriority() {
		return postDAO.findAllOrderByPriority();
	}

	@Override
	@Transactional
	public Post findById(int theId) {
		return postDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Post thePost) {
		postDAO.save(thePost);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		postDAO.deleteById(theId);
	}

}
