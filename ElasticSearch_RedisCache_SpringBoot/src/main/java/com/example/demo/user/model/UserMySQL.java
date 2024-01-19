package com.example.demo.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserMySQL {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@NotEmpty
	private String firstName;

	@NotNull
	@NotBlank
	@NotEmpty
	private String lastName;

	// @Temporal(TemporalType.TIMESTAMP)
	// @UpdateTimestamp
	// private Timestamp modificationDate;

	public UserMySQL() {
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
