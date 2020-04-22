package com.example.gamecollection.domain;

import org.springframework.data.repository.CrudRepository;

//provides CRUD functionality for the entity class
//interface extending Repository
public interface UserRepository extends CrudRepository<Kayttaja, Long> {
	
	// finds object by specific username from the database
	Kayttaja findByUsername(String username);

}
