package com.example.demo.user.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.example.demo.user.model.UserElasticSearch;

@EnableElasticsearchRepositories
public interface UserElasticSearchRepository
		extends
			ElasticsearchRepository<UserElasticSearch, Long> {

}
