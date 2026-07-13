package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.demo.Entity.*;
import com.example.demo.Service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookController {
	List<Book> list = new ArrayList<>();

	private final BookService bookService;

	BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> showBooks() {
		list = bookService.showBooks();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> showBookById(@PathVariable int id) {

		Book b = bookService.showBookById(id);
		if (b == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(b);
	}

	@GetMapping("/bookname")
	public List<Book> showBookByName(@RequestParam(required = false) String name) {
		return bookService.showBookByName(name);
	}

	@GetMapping("/bookgenre")
	public List<Book> showBookByGenre(@RequestParam(required = false) String genre) {
		return bookService.searchByGenre(genre);
	}

	@GetMapping("/book/{id}")
	public String isType(@PathVariable int id) {
		return bookService.isType(id);
	}

	@PostMapping("/books")
	public ResponseEntity<String> addBook(Book b) {
		// if (b.getBookId() == 0 || b.getBookName() == null || b.getBookAuthor() ==
		// null) {
		// return ResponseEntity.badRequest().build();
		// }
		return ResponseEntity.created(null).body(bookService.addBook(b));
	}

	@DeleteMapping("/books{id}")
	public String deleteBook(int id) {
		return bookService.deleteBook(id);
	}
}
