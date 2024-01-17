package com.example.demo.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.RefreshPolicy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.user.model.User;
import com.example.demo.user.repo.UserElasticSearchRepository;
import com.example.demo.user.repo.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private UserElasticSearchRepository userElasticSearchRepository;

	@Autowired
	public UserService(UserRepository userRepository,
			UserElasticSearchRepository userElasticSearchRepository) {
		this.userRepository = userRepository;
		this.userElasticSearchRepository = userElasticSearchRepository;
	}

	@Transactional
	public User create(User user) {
		userRepository.save(user);
		userElasticSearchRepository.save(user, RefreshPolicy.IMMEDIATE);
		return user;
	}

	@Transactional
	public User update(User user) throws UserNotFoundException {
		Optional<User> optionalUser = userElasticSearchRepository
				.findById(user.getId());
		if (optionalUser.isPresent()) {
			User u = optionalUser.get();
			userRepository.save(u);
			userElasticSearchRepository.save(u, RefreshPolicy.IMMEDIATE);
			return user;
		}
		throw new UserNotFoundException(
				"User not found with id " + user.getId());
	}

	@Transactional
	public List<User> getAllUsers() {
		return (List<User>) userElasticSearchRepository.findAll();
	}

	@Transactional
	public User findById(long id) throws UserNotFoundException {
		Optional<User> optionalUser = userElasticSearchRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UserNotFoundException("User not found with id " + id);
	}

	@Transactional
	public User delete(long id) throws UserNotFoundException {
		Optional<User> optionalUser = userElasticSearchRepository.findById(id);
		if (optionalUser.isPresent()) {
			User u = optionalUser.get();
			userElasticSearchRepository.delete(u, RefreshPolicy.IMMEDIATE);
			userRepository.delete(u);
			return u;
		}
		throw new UserNotFoundException(
				"User not found with id for deletion" + id);
	}

}
