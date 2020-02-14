package com.bookmanagementsystem.service;

import java.util.List;

import com.bookmanagementsystem.dto.BookDTO;

public interface IBookService {

	/**
	 * find and return a list of books
	 * @return books
	 */
	List<BookDTO> findAll() throws Exception;

	/**
	 * find book by id
	 * @param id
	 * @return a book
	 */
	BookDTO findById(int id) throws Exception;

	/**
	 * delete book by id
	 * @param id
	 * @return true / false
	 */
	boolean deleteById(int id) throws Exception;

	/**
	 * add book a book
	 * @param book
	 * @return true / false
	 */
	boolean save(BookDTO book) throws Exception;

}