package com.example.gamecollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//provides CRUD functionality for the entity class
//interface extending Repository
//inherits methods for saving, deleting, and finding Game entities
public interface GameRepository extends CrudRepository<Game, Long>{

	// query methods on the interface
	// finds object by title from the database
	List<Game> findByTitle(String title);

}
