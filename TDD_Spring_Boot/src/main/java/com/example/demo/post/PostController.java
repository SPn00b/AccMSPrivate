package com.example.demo.post;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	// @Autowired
	private final PostRepository postRepository;

	//
	public PostController(PostRepository postRepository) {
		// TODO Auto-generated constructor stub
		this.postRepository = postRepository;
	}

	@GetMapping("")
	List<Post> findAll() {
		// return null;
		return postRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Post> findById(@PathVariable Integer id) {
		return Optional.of(postRepository.findById(id)
				.orElseThrow(PostNotFountException::new));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Post create(@RequestBody @Valid Post post) {
		// TODO: process POST request
		return postRepository.save(post);
	}

	@PutMapping("/{id}")
	Post update(@PathVariable Integer id, @RequestBody @Valid Post post) {
		Optional<Post> existingPost = postRepository.findById(id);
		if (existingPost.isPresent()) {
			Post updatedPost = new Post(existingPost.get().id(),
					existingPost.get().userId(), post.title(), post.body(),
					existingPost.get().version());
			return postRepository.save(updatedPost);
		}
		throw new PostNotFountException();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer id) {
		postRepository.deleteById(id);
	}

}
