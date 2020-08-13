package com.encore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.service.BookService;
import com.encore.rest.vo.Book;

@RestController
@RequestMapping("api")
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("book")
	public ResponseEntity selectAll() {
		try {
			List<Book> list = bookService.getAllBook();
			return new ResponseEntity(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("book/{isbn}")
	public ResponseEntity selectOne(@PathVariable String isbn) {
		try {
			Book book = bookService.getBook(isbn);
			return new ResponseEntity(book,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("book")
	public ResponseEntity insertBook(@RequestBody Book book){
		try {
			boolean b = bookService.insertBook(book);
			return new ResponseEntity(HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("book")
	public ResponseEntity updateBook(@RequestBody Book book) {
		try {
			boolean b = bookService.updateBook(book);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("book/{isbn}")
	public ResponseEntity deleteBook(@PathVariable String isbn) {
		try {
			boolean b = bookService.deleteBook(isbn);
			return new ResponseEntity(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
