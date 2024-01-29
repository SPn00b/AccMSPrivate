package com.example.apigatewayportal;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.apigatewayportal.model.Portal;
import com.example.apigatewayportal.model.User;
import com.example.apigatewayportal.repository.PortalRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayPortalApplication.class, args);
	}

	List<com.example.apigatewayportal.model.User> p1Users = List
			.of(new User(1L, "S", " P"), new User(2L, "T", " P"));

	List<com.example.apigatewayportal.model.User> p2Users = List.of(
			new User(3L, "A", " P"), new User(4L, "J", " P"),
			new User(5L, "M", " P"), new User(6L, "B", " P"),
			new User(7L, "K", " P"));

	@Bean
	PortalRepository repository() {
		PortalRepository repository = new PortalRepository();
		repository.add(new Portal(1L, p1Users));
		repository.add(new Portal(2L, p2Users));
		return repository;
	}

}
