package com.example.demo;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.post.Post;
import com.example.demo.post.PostController;
import com.example.demo.post.PostNotFountException;
import com.example.demo.post.PostRepository;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.ContentType;

//@SpringBootTest
@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
public class PostControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	PostRepository postRepository;

	List<Post> posts = new ArrayList<>();

	@BeforeEach
	void setUp() {
		posts = List.of(
				new Post(1, 1, "Hello, World!", "This is my first post.", null),
				new Post(2, 1, "Second Post", "This is my second post.", null));
	}

	@Test
	void shouldFindAllPosts() throws Exception {
		String jsonResponse = """
				[
					{
						"id":1,
						"userId":1,
						"title":"Hello, World!",
						"body":"This is my first post.",
						"version":null
					},
					{
						"id":2,
						"userId":1,
						"title":"Second Post",
						"body":"This is my second post.",
						"version":null
					}
				]
				""";

		when(postRepository.findAll()).thenReturn(posts);

		mockMvc.perform(get("/api/posts")).andExpect(status().isOk())
				.andExpect(content().json(jsonResponse));
	}

	@Test
	void shouldFindPostWhenGivenValidId() throws Exception {
		when(postRepository.findById(1)).thenReturn(Optional.of(posts.get(0)));

		Post post = posts.get(0);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", post.id());
		jsonObject.put("userId", post.userId());
		jsonObject.put("title", post.title());
		jsonObject.put("body", post.body());
		jsonObject.put("version", post.version());

		mockMvc.perform(get("/api/posts/1")).andExpect(status().isOk())
				.andExpect(content().json(jsonObject.toString()));
	}

	@Test
	void shouldNotFindPostWhenGivenInvalidId() throws Exception {
		when(postRepository.findById(9999))
				.thenThrow(PostNotFountException.class);

		mockMvc.perform(get("/api/posts/9999"))
				.andExpect(status().isNotFound());
	}

	@Test
	void shouldCreateNewPostWhenPostIsValid() throws Exception {
		Post post = new Post(3, 1, "New Title", "New Body", null);
		when(postRepository.save(post)).thenReturn(post);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", post.id());
		jsonObject.put("userId", post.userId());
		jsonObject.put("title", post.title());
		jsonObject.put("body", post.body());
		jsonObject.put("version", post.version());

		mockMvc.perform(post("/api/posts").contentType("application/json")
				.content(jsonObject.toString()))
				.andExpect(status().isCreated());
	}

	@Test
	void shouldCreatePostWhenPostIsInValid() throws Exception {
		Post post = new Post(3, 1, "", "", null);
		when(postRepository.save(post)).thenReturn(post);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", post.id());
		jsonObject.put("userId", post.userId());
		jsonObject.put("title", post.title());
		jsonObject.put("body", post.body());
		jsonObject.put("version", post.version());

		mockMvc.perform(post("/api/posts").contentType("application/json")
				.content(jsonObject.toString()))
				.andExpect(status().isBadRequest());
	}

	@Test
	void shouldUpdatePostWhenGivenValidPost() throws Exception {
		Post updatePost = new Post(1, 1, "This is a new title",
				"This is a new body", 1);
		when(postRepository.findById(updatePost.id()))
				.thenReturn(Optional.of(updatePost));
		when(postRepository.save(updatePost)).thenReturn(updatePost);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", updatePost.id());
		jsonObject.put("userId", updatePost.userId());
		jsonObject.put("title", updatePost.title());
		jsonObject.put("body", updatePost.body());
		jsonObject.put("version", updatePost.version());

		mockMvc.perform(put("/api/posts/1")
				.contentType(ContentType.APPLICATION_JSON.getMimeType())
				.content(jsonObject.toString())).andExpect(status().isOk());

	}

	@Test
	void shouldDeletePostWhenGivenValidId() throws Exception {
		Post deletePost = new Post(1, 1, "Hello, World!",
				"This is my first post.", null);
		doNothing().when(postRepository).deleteById(deletePost.id());
		mockMvc.perform(delete("/api/posts/1"))
				.andExpect(status().isNoContent());
	}

}
