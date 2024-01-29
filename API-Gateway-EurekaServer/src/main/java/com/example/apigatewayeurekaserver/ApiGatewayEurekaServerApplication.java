package com.example.apigatewayeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiGatewayEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayEurekaServerApplication.class, args);
	}

}
