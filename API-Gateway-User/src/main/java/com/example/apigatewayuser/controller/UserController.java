package com.example.apigatewayuser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apigatewayuser.model.User;
import com.example.apigatewayuser.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	User getUserById(@PathVariable long userId) throws Exception {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new Exception("optional User is not present!");
	}

}
