package com.cropLogin.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.cropLogin.model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
	
	public UserModel findByEmail(String username);

}
