package com.example.demo.user.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.model.elasticsearch.UserModel;

@Repository
public interface UserESRepo extends ElasticsearchRepository<UserModel, Long> {

}
