package com.bookmanagementsystem.dto;

public class BookDTO {
	
	private int id;
	private String name;
	private String author;
	private String description;
	
	public BookDTO(){}

	public BookDTO( String name, String author, String description) {	
		this.name = name;
		this.author = author;
		this.description = description;
	}
	
	public BookDTO(int id, String name, String author, String description) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", description=" + description + "]";
	}
}
