package com.example.demo.user.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "user")
@Setting(replicas = 2, shards = 3)
// @RedisHash
public class UserElasticSearch implements Serializable {
	@Field(type = FieldType.Long)
	private Long id;

	@Field(type = FieldType.Text)
	private String firstName;

	@Field(type = FieldType.Text)
	private String lastName;

	@Field(type = FieldType.Date)
	private Date modificationDate;

	public UserElasticSearch() {
		// do nothing
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
}