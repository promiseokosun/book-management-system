package com.bookmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookmanagementsystem.dto.BookDTO;

@Service
public class BookService {
	
	private static List<BookDTO> books = new ArrayList<BookDTO>();
	private static int idCounter = 0;
	
	static {
		books.add(new BookDTO(++idCounter, "Things Fall Apart", "Chino Achebe", "A Story of a great warrior"));
		books.add(new BookDTO(++idCounter, "How to Make your money grow", "Okosun Promise", "Big men's secret"));
		books.add(new BookDTO(++idCounter, "Dating made easy", "Larry Hensaw", "A love novel"));
		books.add(new BookDTO(++idCounter, "Master Spring boot", "Brandan Jones", "A solid guide to spring boot"));		
	}

	public List<BookDTO> findAll() {
		// TODO Auto-generated method stub
		return books;
	}

	public BookDTO findById(int id) {
		// TODO Auto-generated method stub
		for (BookDTO bookDTO : books) {
			if(bookDTO.getId() == id) {
				return bookDTO;
			}
		}
		return null;
	}

	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		BookDTO bookDTO = findById(id);
		boolean isDeleted = false;
		isDeleted = books.remove(bookDTO);
		return isDeleted;
	}

	public boolean save(BookDTO book) {
		// TODO Auto-generated method stub
		boolean isAdded = false;
		book.setId(++idCounter); // auto increment id
		isAdded = books.add(book);
		
		return isAdded;
	}

}
