package com.bookmanagementsystem.bookmanagementsystem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookmanagementsystem.dto.BookDTO;
import com.bookmanagementsystem.service.IBookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookManagementSystemApplicationTests {
	
	@Autowired
	private IBookService bookService;

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void findAllBookTest() {
		List<BookDTO> books = null;
		try {
			books = bookService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(books);
	}
	
	@Test
	public void findByIdBookTest() {
		int id = 2;
		BookDTO book = null;
		try {
			book = bookService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(book);
	}
	
	@Test
	public void deleteByIdBookTest() {
		int id = 3;
		boolean result = false;
		try {
			result = bookService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result);
	}
	
	@Test
	public void saveBookTest() {
		BookDTO book = new BookDTO("Rich dad Poor dad", "Kenneth Cole", "Inspirational Book");
		boolean result = false;
		try {
			result = bookService.save(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result);
	}
	

}
