package com.example.demo.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.EBook;
import com.example.demo.Entity.PaperBook;

@Service
public class BookServiceImp implements BookService {
	private HashMap<Integer, Book> books = new HashMap<>();

	public BookServiceImp() {
		Book b0 = new Book(2, "Gone Girl", "Gillian Flynn", 399, "Crown Publishing", 415, "Thriller", 415);
		EBook e2 = new EBook(5, "It", "Stephen King", 550, "Viking Press", 1138, "Horror", 1138, 22.3,
				"www.example.com/it.pdf");
		PaperBook p1 = new PaperBook(4, "Atomic Habits", "James Clear", 350, "Penguin", 320, "Self-help", 320,
				"Paperback", 50);
		PaperBook p2 = new PaperBook(6, "The Silent Patient", "Alex Michaelides", 450, "Celadon Books", 336,
				"Psychological Horror", 336, "Hardcover", 35);
		books.put(b0.getBookId(), b0);
		books.put(e2.getBookId(), e2);
		books.put(p1.getBookId(), p1);
		books.put(p2.getBookId(), p2);

	}

	public List<Book> showBooks() {
		return new ArrayList<>(books.values());
	}

	public List<Book> showBookByName(String name) {
		List<Book> list = new ArrayList<>();
		books.values().stream()
				.filter(u -> u.getBookName().toLowerCase().contains(name.toLowerCase()))
				.forEach(u -> list.add(u));
		return list;
	}

	public List<Book> searchByGenre(String Genre) {
		List<Book> list = new ArrayList<>();
		books.values().stream()
				.filter(u -> u.getGenre().toLowerCase().contains(Genre.toLowerCase()))
				.forEach(u -> list.add(u));
		return list;

	}

	public Book showBookById(int id) {
		return books.get(id);
	}

	public String addBook(Book b) {
		books.put(b.getBookId(), b);
		return "Book has been added";
	}

	public String deleteBook(int id) {
		books.remove(id);
		return "Book has been deleted";
	}

	public String isType(int id) {
		Book book = books.get(id);
		if (book == null) {
			return "Book not found";
		} else if (book instanceof EBook) {
			return "Ebook";
		} else {
			return "PaperBook";
		}
	}
}