package com.example.gamecollection.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByUsername(String username);

}
