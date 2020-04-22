package com.example.gamecollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity //a table in database aka task table
public class Game {
	
	@Id //id column of the table
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generates a unique primary key for every new object 
	private Long id;
	private String title;
	private String publisher;
	private int year;
	private double price;
	private String platform;
	private String status;
	
	@ManyToOne // many-to-one relationship between task and category entities
	@JsonManagedReference // stops endless loop in entity relationship 
	@JoinColumn(name = "genreid") // defines entity as the owner of the relationship
	private Genre genre;

	public Game() {}  

	// constructor using fields
	public Game(String title, String publisher, int year, double price, String platform, String status, Genre genre) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
		this.platform = platform;
		this.status = status;
		this.genre = genre;
	}

	// getters and setters
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
	
	public String getStatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	//toString
	@Override
	public String toString() {
	if (this.genre != null)
		return "Game [id=" + id + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", price="
				+ price + ", platform=" + platform + ", status=" + status + this.getGenre() + "]";
		else
			return "Game [id=" + id + ", title=" + title + ", publisher=" + publisher + ", year=" + year + ", price="
			+ price + ", platform=" + platform + ", status=" + status + "]";
	}
	

}
