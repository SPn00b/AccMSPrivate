package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableCaching
// @EnableScheduling
public class ElasticSearchRedisCacheSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(ElasticSearchRedisCacheSpringBootApplication.class, args);
	}

}
