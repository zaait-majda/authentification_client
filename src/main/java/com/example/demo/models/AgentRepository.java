package com.example.demo.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AgentRepository extends MongoRepository<UserModel, String> {
	
	//UserModel findBynom(String nom);
	UserModel findBytel(String tel);

}
