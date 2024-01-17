package com.example.demo.user.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("/user/api/v1")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@Cacheable
	@GetMapping("/{id}")
	User findById(@PathVariable long id) {
		try {
			return userService.findById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping
	@Cacheable
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@CacheEvict
	@DeleteMapping("/delete/{id}")
	User deleUser(@PathVariable long id) {
		try {
			return userService.delete(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping
	@CachePut
	User createUser(@RequestBody User user) {
		return userService.create(user);
	}

	@PostMapping
	@CachePut
	User updateUser(@RequestBody User user) {
		try {
			return userService.update(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
