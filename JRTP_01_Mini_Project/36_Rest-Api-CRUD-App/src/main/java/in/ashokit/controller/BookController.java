package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Book;
import in.ashokit.serviceImpl.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	private BookServiceImpl serviceImpl;

	@PostMapping(value = "/book", produces = { "application/json" })
	public ResponseEntity<String> storeAndUpdateBook(@RequestBody Book book) {

		String msg = serviceImpl.upsertBook(book);
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	

	}

	@GetMapping("/getbook")
	public ResponseEntity<List<Book>> getBookData() {
		List<Book> books = serviceImpl.getBook();

		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<String> deteteBookData(@PathVariable("bookId") Book bookId) {
      
		String msg = serviceImpl.deleteBook(bookId);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
