package com.example.apigatewayuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.apigatewayuser.model.User;
import com.example.apigatewayuser.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayUserApplication.class, args);
	}

	@Bean
	UserRepository repository() {
		UserRepository repository = new UserRepository();
		repository.add(new User(1L, "S", " P"));
		repository.add(new User(2L, "T", " P"));
		repository.add(new User(3L, "A", " P"));
		repository.add(new User(4L, "J", " P"));
		repository.add(new User(5L, "M", " P"));
		repository.add(new User(6L, "B", " P"));
		repository.add(new User(7L, "K", " P"));
		return repository;
	}

}
