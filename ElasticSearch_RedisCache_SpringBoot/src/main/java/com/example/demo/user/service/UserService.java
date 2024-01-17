package com.example.demo.user.service;

import java.util.List;
import java.util.Optional;

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
	public UserMySQL create(UserMySQL user) {
		UserElasticSearch userElasticSearch = new UserElasticSearch();
		userElasticSearch.setId(user.getId());
		userElasticSearch.setFirstName(user.getFirstName());
		userElasticSearch.setLastName(user.getLastName());
		userElasticSearch.setModificationDate(user.getModificationDate());
		userRepository.save(user);
		userElasticSearchRepository.save(userElasticSearch,
				RefreshPolicy.IMMEDIATE);
		return user;
	}

	@Transactional
	public UserMySQL update(UserMySQL user) throws UserNotFoundException {
		Optional<UserElasticSearch> optionalUser = userElasticSearchRepository
				.findById(user.getId());
		if (optionalUser.isPresent()) {
			UserElasticSearch u = optionalUser.get();
			UserMySQL userMySQL = new UserMySQL();
			userMySQL.setId(optionalUser.get().getId());
			userMySQL.setFirstName(optionalUser.get().getFirstName());
			userMySQL.setLastName(optionalUser.get().getLastName());
			userMySQL.setModificationDate(
					optionalUser.get().getModificationDate());
			userRepository.save(userMySQL);
			userElasticSearchRepository.save(u, RefreshPolicy.IMMEDIATE);
			return user;
		}
		throw new UserNotFoundException(
				"User not found with id " + user.getId());
	}

	@Transactional
	public List<UserElasticSearch> getAllUsers() {
		return (List<UserElasticSearch>) userElasticSearchRepository.findAll();
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
	public UserMySQL delete(long id) throws UserNotFoundException {
		Optional<UserElasticSearch> optionalUser = userElasticSearchRepository
				.findById(id);
		if (optionalUser.isPresent()) {
			UserElasticSearch u = optionalUser.get();
			UserMySQL userMySQL = new UserMySQL();
			userMySQL.setId(optionalUser.get().getId());
			userMySQL.setFirstName(optionalUser.get().getFirstName());
			userMySQL.setLastName(optionalUser.get().getLastName());
			userMySQL.setModificationDate(
					optionalUser.get().getModificationDate());
			userElasticSearchRepository.deleteById(u.getId(),
					RefreshPolicy.IMMEDIATE);
			userRepository.deleteById(u.getId());
			return userMySQL;
		}
		throw new UserNotFoundException(
				"User not found with id for deletion" + id);
	}

}
