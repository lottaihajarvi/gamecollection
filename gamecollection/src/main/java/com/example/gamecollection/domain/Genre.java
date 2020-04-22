package com.example.gamecollection.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Genre {
	@Id //id column
    @GeneratedValue(strategy=GenerationType.AUTO) // automatically generates a unique primary key for every new object 
	private Long genreid;
	private String name;
	
	// one-to-many relationship between task and category entities
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre") 
	@JsonBackReference //  keeps connection between entities functional over REST API
	// list of games;
	private List<Game> games;

	public Genre() {}
	
	// constructor using fields
	public Genre(String name) {
		this.name = name;
	}

	// getters and setters
	public Long getGenreid() {
		return genreid;
	}

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
		
}
	//toString
	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", name=" + name + "]";
	}
	
}
