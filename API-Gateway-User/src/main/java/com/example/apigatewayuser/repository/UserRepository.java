package com.example.apigatewayuser.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.springframework.data.repository.ListCrudRepository;

import com.example.apigatewayuser.model.User;

//public interface UserRepository extends ListCrudRepository<User, Long> {
//
//}

public class UserRepository {
	private List<User> userList = new ArrayList<>();

	public User add(User user) {
		user.setUserId(userList.size() + 1);
		userList.add(user);
		return user;
	}

	public List<User> findAll() {
		return userList;
	}

	public List<User> findByDepartment(Long portalId) {
		// return userList.stream()
		// .filter(a -> a.getDepartmentId().equals(departmentId))
		// .toList();
		return null;
	}

	public Optional<User> findById(long userId) {
		return userList.stream().filter(u -> u.getUserId() == userId)
				.findFirst();
	}

}
