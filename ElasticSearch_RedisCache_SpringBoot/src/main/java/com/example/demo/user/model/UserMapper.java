package com.example.demo.user.model;

import java.util.List;

import com.example.demo.user.model.elasticsearch.UserDTO;
import com.example.demo.user.model.elasticsearch.UserModel;

public interface UserMapper {

	UserDTO toUserDTO(User user);

	List<UserDTO> toUserDtos(List<User> users);

	User toUser(UserDTO userDTO);

	List<User> toUsers(List<UserDTO> userDTOS);

	UserModel toUserModel(User user);
}
