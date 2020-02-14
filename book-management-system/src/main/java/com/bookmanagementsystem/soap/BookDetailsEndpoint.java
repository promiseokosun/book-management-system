package com.bookmanagementsystem.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bookmanagementsystem.dto.BookDTO;
import com.bookmanagementsystem.service.BookService;

import bookmanagementsystem.books.BookDetails;
import bookmanagementsystem.books.GetBookDetailsRequest;
import bookmanagementsystem.books.GetBookDetailsResponse;

@Endpoint
public class BookDetailsEndpoint {
	
	@Autowired
	private BookService bookService;
	
	@PayloadRoot(namespace="bookmanagementsystem/books", localPart="GetBookDetailsRequest")
	@ResponsePayload
	public GetBookDetailsResponse processBookDetails(@RequestPayload GetBookDetailsRequest request) {
		
		BookDTO bookDTO = bookService.findById(request.getId());
		
		BookDetails bookDetails = new BookDetails();
		bookDetails.setId(bookDTO.getId());
		bookDetails.setName(bookDTO.getName());
		bookDetails.setAuthor(bookDTO.getAuthor());
		bookDetails.setDescription(bookDTO.getDescription());
		
		GetBookDetailsResponse response = new GetBookDetailsResponse();
		response.setBookDetails(bookDetails);
		
		return response;
	}
	

}
