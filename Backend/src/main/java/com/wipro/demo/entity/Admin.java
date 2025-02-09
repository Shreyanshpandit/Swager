package com.wipro.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Admin {

	@Schema(description = "The unique username of the admin", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Schema(description = "The unique username of the admin", example = "admin")
	@NotNull
	@Size(min = 4, max = 20, message = "Username should be between 4 to 20 characters")
	@Column(unique = true)
	private String username;

	@Schema(description = "The password of the admin", example = "12345678")
	@NotNull
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id,
			@NotNull @Size(min = 4, max = 20, message = "Username should be between 4 to 20 characters") String username,
			@NotNull @Size(min = 8, message = "Password should be at least 8 characters") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
