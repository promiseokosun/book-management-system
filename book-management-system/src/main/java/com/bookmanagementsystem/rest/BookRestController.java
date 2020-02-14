package com.bookmanagementsystem.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookmanagementsystem.dto.BookDTO;
import com.bookmanagementsystem.service.IBookService;

@RestController
public class BookRestController {
	
	private IBookService bookService;
	
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(path="/books")
	public List<BookDTO> findAllBooks() {
		List<BookDTO> books = null;
		try {
			books = bookService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	@GetMapping(value="/books/{id}")
	public BookDTO findBook(@PathVariable int id) {
		BookDTO bookDTO = null;
		try {
			bookDTO = bookService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return bookDTO;
	}
	
	@DeleteMapping(path="/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		
		try {
			 if(bookService.deleteById(id)){
				 return ResponseEntity.noContent().build(); // return no content
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build(); // return page not found
	}
	
	@RequestMapping(value="/books",method=RequestMethod.PUT)
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO book) {
		
		
		try {
			if(bookService.save(book)){
				return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<BookDTO>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value="/books", method=RequestMethod.POST)
	public ResponseEntity<Void> saveOneBook(@RequestBody BookDTO book) {
		try {
			if(bookService.save(book)){
				//return new ResponseEntity<Void>(HttpStatus.OK);
				// build a uri
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}").buildAndExpand(book.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
