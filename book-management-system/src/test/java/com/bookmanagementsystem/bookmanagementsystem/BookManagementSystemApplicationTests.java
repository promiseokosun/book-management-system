package com.bookmanagementsystem.bookmanagementsystem;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookmanagementsystem.bookmanagementsystem.dto.BookDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookManagementSystemApplicationTests {
	
	@Autowired
	private BookService bookService;

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void findAllBookTest() {
		List<BookDTO> books = bookService.findAll();
		assertNotNull(books);
	}
	
	@Test
	public void findByIdBookTest() {
		int id = 2;
		BookDTO book = bookService.findById(id);
		assertNotNull(book);
	}
	
	@Test
	public void deleteByIdBookTest() {
		int id = 3;
		boolean result = false;
		result = bookService.deleteById(id);
		assertTrue(result);
	}
	
	@Test
	public void saveBookTest() {
		BookDTO book = new BookDTO();
		boolean result = bookService.save(book);
		assertTrue(result);
	}
	

}
