package com.cropLogin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="USERS")
public class UserModel {
	
	
	@Id
	private String id;
	private String email;
	private String password;
	
	public UserModel() {
		
	}

	public String getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
