package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.Entity.*;
import com.example.demo.Exception.BookNotFoundExecption;
import com.example.demo.Exception.InvalidAddBookRequestException;
import com.example.demo.Exception.NoBookPresentException;
import com.example.demo.Service.BookService;

@RestController
public class BookController {
	@Value("${spring.application.name}")
	private String appName;
	// List<Book> list = new ArrayList<>();
	@Value("${spring.application.version}")
	private double version;

	private final BookService bookService;

	BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/appname")
	public ResponseEntity<String> getAppName() {
		return ResponseEntity.ok(appName + "version:" + version);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> showBooks() throws NoBookPresentException {
		return ResponseEntity.ok(bookService.showBooks());
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> showBookById(@PathVariable int id) throws BookNotFoundExecption {
		Book b = bookService.showBookById(id);
		return ResponseEntity.ok(b);
	}

	@GetMapping("/bookname")
	public ResponseEntity<List<Book>> showBookByName(@RequestParam(required = false) String name)
			throws BookNotFoundExecption {
		return ResponseEntity.ok(bookService.showBookByName(name));
	}

	@GetMapping("/bookgenre")
	public ResponseEntity<List<Book>> showBookByGenre(@RequestParam(required = false) String genre)
			throws BookNotFoundExecption {
		return ResponseEntity.ok(bookService.searchByGenre(genre));
	}

	@GetMapping("/booktype/{id}")
	public ResponseEntity<String> isType(@PathVariable int id) throws BookNotFoundExecption {

		return ResponseEntity.ok(bookService.isType(id));

	}

	@PostMapping("/books")
	public ResponseEntity<String> addBook(@RequestBody Book b) throws InvalidAddBookRequestException {
		return ResponseEntity.ok(bookService.addBook(b));

	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) throws BookNotFoundExecption {
		return ResponseEntity.ok(bookService.deleteBook(id));
	}
}