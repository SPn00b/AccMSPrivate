package com.example.demo.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	private final PostRepository postRepository;

	public PostController(PostRepository postRepository) {
		// TODO Auto-generated constructor stub
		this.postRepository = postRepository;
	}

	@GetMapping("")
	List<Post> findAll() {
		// return null;
		return postRepository.findAll();
	}
}
