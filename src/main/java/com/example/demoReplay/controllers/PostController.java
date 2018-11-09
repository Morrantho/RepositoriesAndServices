package com.example.demoReplay.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoReplay.models.Post;
import com.example.demoReplay.models.User;
import com.example.demoReplay.services.PostService;
import com.example.demoReplay.services.UserService;

@Controller
@RequestMapping("/posts")
public class PostController {
	private PostService postService;
	private UserService userService;

	public PostController(PostService postService,UserService userService){
		this.postService = postService;
		this.userService = userService;
	}
	
	@GetMapping("")
	public String root( Model model, @ModelAttribute("post") Post post, HttpSession session ){
		if( session.getAttribute("user") == null ) return "redirect:/users";
		model.addAttribute("posts",postService.findAll());
		return "posts";
	}
	
	@PostMapping("")
	public String CreatePost( @Valid @ModelAttribute("post") Post post, BindingResult res, HttpSession session ) {
		if( session.getAttribute("user") == null ) return "redirect:/users";
		if( res.hasErrors() ) return "posts";
		
		Long userId = (Long) session.getAttribute("user");
		User user = userService.findById(userId);

		post.setUser(user);
		postService.create(post);
		return "redirect:/posts";
	}
}