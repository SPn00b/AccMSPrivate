package com.example.demo.user.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.user.model.User;

public interface UserElasticSearchRepository
		extends
			ElasticsearchRepository<User, Long> {

}
