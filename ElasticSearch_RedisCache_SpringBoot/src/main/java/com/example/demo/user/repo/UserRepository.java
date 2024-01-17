package com.example.demo.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
