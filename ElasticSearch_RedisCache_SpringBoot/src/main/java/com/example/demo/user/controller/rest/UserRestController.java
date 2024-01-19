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
import com.example.demo.user.model.UserElasticSearch;
import com.example.demo.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user/api/v1")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@Cacheable(value = "user", key = "#id")
	@GetMapping("/{id}")
	UserElasticSearch findById(@PathVariable long id) {
		try {
			return userService.findById(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping
	@Cacheable(cacheNames = "users")
	List<UserElasticSearch> getAllUsers() {
		return userService.getAllUsers();
	}

	@CacheEvict(cacheNames = "user", key = "#id", beforeInvocation = false)
	@DeleteMapping("/delete/{id}")
	UserElasticSearch deleUser(@PathVariable long id) {
		try {
			return userService.delete(id);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping
	@CachePut(cacheNames = "user", key = "#user.getId")
	UserElasticSearch createUser(@RequestBody @Valid UserElasticSearch user) {
		return userService.create(user);
	}

	@PostMapping("/{id}")
	@CachePut(cacheNames = "user", key = "#id")
	UserElasticSearch updateUser(@PathVariable long id,
			@RequestBody @Valid UserElasticSearch user) {
		try {
			return userService.update(id, user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
