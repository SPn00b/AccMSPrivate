package com.example.demo.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.user.model.UserMySQL;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserMySQL, Long> {

}
