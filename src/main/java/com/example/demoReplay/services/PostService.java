package com.example.demoReplay.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoReplay.models.Post;
import com.example.demoReplay.repositories.PostRepository;

@Service
public class PostService {
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post create(Post post) {
		return postRepository.save(post);
	}
	
	public ArrayList<Post> findAll(){
		return (ArrayList<Post>) postRepository.findAll();
	}
	
	public Post findById(Long postId) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) return post.get();
		return null;
	}
	
	public Post update(Post post) {
		return postRepository.save(post);
	}
	
	public void destroy(Long postId){
		postRepository.deleteById(postId);
	}
}
