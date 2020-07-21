package com.umldavidkim.springboot.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.umldavidkim.springboot.todolist.entity.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Post> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<Post> posts = currentSession.createQuery("FROM Post").getResultList();
		return posts;		
	}
	
	@Override
	public List<Post> findAllOrderByPriority() {
		Session currentSession = entityManager.unwrap(Session.class);
		List<Post> posts = currentSession.createQuery("FROM Post ORDER BY priority, description ASC").getResultList();
		return posts;	
	}

	@Override
	public Post findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Post thePost = currentSession.get(Post.class, theId);
		return thePost;
	}

	@Override
	public void save(Post thePost) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thePost);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("DELETE FROM Post WHERE id=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();
	}


}
