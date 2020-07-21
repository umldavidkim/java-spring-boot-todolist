package com.umldavidkim.springboot.todolist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umldavidkim.springboot.todolist.entity.Post;
import com.umldavidkim.springboot.todolist.service.PostService;

@Controller
public class MainController {

	@Autowired
	@Qualifier("postServiceImpl")
	PostService postService;
	
	@GetMapping("/")
	public String list(Model theModel) {
		List<Post> posts = postService.findAll();
		theModel.addAttribute("posts", posts);
		return "list";
	}
	
	@GetMapping("/sortByPriority")
	public String listByPriority(Model theModel) {
		List<Post> posts = postService.findAllOrderByPriority();
		theModel.addAttribute("posts", posts);
		return "list";
	}
	
	@GetMapping("/showBlankForm")
	public String showBlankForm(Model theModel) {
		Post thePost = new Post();
		theModel.addAttribute("post", thePost);
		return "form";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("postId") int theId, Model theModel) {
		Post thePost = postService.findById(theId);
		if (thePost == null) {
			throw new RuntimeException("Post not found with id - " + theId);
		}
		theModel.addAttribute("post", thePost);
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("post") Post thePost, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "form";
		}
		postService.save(thePost);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deletePost(@RequestParam("postId") int theId, Model theModel) {
		Post thePost = postService.findById(theId);
		if (thePost == null) {
			throw new RuntimeException("Post not found with id - " + theId);
		}
		postService.deleteById(theId);
		return "redirect:/";
	}
}
