package com.example.gamecollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//provides CRUD functionality for the entity class
//interface extending Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

	// query methods on the interface
	// finds object by specific name from the database
	 List<Genre> findByName(String name);

}
