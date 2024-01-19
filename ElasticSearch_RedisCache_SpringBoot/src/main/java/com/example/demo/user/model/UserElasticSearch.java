package com.example.demo.user.model;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Document(indexName = "user")
@Setting(replicas = 2, shards = 3)
// @RedisHash
public class UserElasticSearch implements Serializable {
	private static final long serialVersionUID = 2725532028955182268L;

	@Field(type = FieldType.Long)
	private Long id;

	@NotNull
	@NotBlank
	@NotEmpty
	@Field(type = FieldType.Text)
	private String firstName;

	@NotNull
	@NotBlank
	@NotEmpty
	@Field(type = FieldType.Text)
	private String lastName;

	// @Field(type = FieldType.Date_Nanos)
	// @Temporal(TemporalType.TIMESTAMP)
	// @UpdateTimestamp
	// private Timestamp modificationDate;

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

	// public Timestamp getModificationDate() {
	// return modificationDate;
	// }
	//
	// public void setModificationDate(Timestamp modificationDate) {
	// this.modificationDate = modificationDate;
	// }
}