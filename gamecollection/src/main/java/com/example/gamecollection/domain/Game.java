package com.example.gamecollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonManagedReference;

//a table in database aka task table
@Entity
public class Game {
	//id column of the table
	@Id
	// automatically generates a unique primary key for every new object 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String publisher;
	private int year;
	private double price;
	private String platform;
	private String completion;
	
	@ManyToOne // many-to-one relationship between task and category entities
	@JsonManagedReference // stops endless loop in entity relationship 
	@JoinColumn(name = "genreid") // defines entity as the owner of the relationship
	private Genre genre;

	public Game() {}

	public Game(String title, String publisher, int year, double price, String platform, String completion, Genre genre) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
		this.platform = platform;
		this.completion = completion;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getCompletion() {
		return completion;
	}

	public void setcompletion(String completion) {
		this.completion = completion;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
	if (this.genre != null)
		return "Game [id=" + id + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", price="
				+ price + ", platform=" + platform + ", completion=" + completion + this.getGenre() + "]";
		else
			return "Game [id=" + id + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", price="
			+ price + ", platform=" + platform + ", completion=" + completion + "]";
	}
	

}
