package com.example.demo.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.RefreshPolicy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.user.model.UserElasticSearch;
import com.example.demo.user.model.UserMySQL;
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
	public UserElasticSearch create(UserElasticSearch userElasticSearch) {
		UserMySQL userMySQL = new UserMySQL();
		userMySQL.setFirstName(userElasticSearch.getFirstName());
		userMySQL.setLastName(userElasticSearch.getLastName());
		UserMySQL userMySQLAdded = userRepository.save(userMySQL);
		userElasticSearch.setId(userMySQLAdded.getId());
		return userElasticSearchRepository.save(userElasticSearch,
				RefreshPolicy.IMMEDIATE);
	}

	@Transactional
	public UserElasticSearch update(long id,
			UserElasticSearch userElasticSearch) throws UserNotFoundException {
		Optional<UserElasticSearch> optionalUser = userElasticSearchRepository
				.findById(id);
		if (optionalUser.isPresent()) {
			UserElasticSearch u = optionalUser.get();
			u.setId(id);
			u.setFirstName(userElasticSearch.getFirstName());
			u.setLastName(userElasticSearch.getLastName());
			UserMySQL userMySQL = new UserMySQL();
			userMySQL.setId(id);
			userMySQL.setFirstName(u.getFirstName());
			userMySQL.setLastName(u.getLastName());
			userRepository.save(userMySQL);
			return userElasticSearchRepository.save(u, RefreshPolicy.IMMEDIATE);
		}
		throw new UserNotFoundException(
				"User not found with id " + userElasticSearch.getId());
	}

	@Transactional
	public List<UserElasticSearch> getAllUsers() {
		Iterable<UserElasticSearch> iterableElasticSearch = userElasticSearchRepository
				.findAll();

		// List<UserElasticSearch> listUserElasticSearch =
		return StreamSupport.stream(iterableElasticSearch.spliterator(), false)
				.collect(Collectors.toList());
	}

	@Transactional
	public UserElasticSearch findById(long id) throws UserNotFoundException {
		Optional<UserElasticSearch> optionalUser = userElasticSearchRepository
				.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UserNotFoundException("User not found with id " + id);
	}

	@Transactional
	public UserElasticSearch delete(long id) throws UserNotFoundException {
		Optional<UserElasticSearch> optionalUser = userElasticSearchRepository
				.findById(id);
		if (optionalUser.isPresent()) {
			UserElasticSearch u = optionalUser.get();
			userElasticSearchRepository.deleteById(id, RefreshPolicy.IMMEDIATE);
			userRepository.deleteById(id);
			return u;
		}
		throw new UserNotFoundException(
				"User not found with id for deletion" + id);
	}

}
