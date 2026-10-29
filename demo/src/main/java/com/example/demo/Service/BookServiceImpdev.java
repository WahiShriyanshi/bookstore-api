package com.example.demo.Service;

import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.EBook;
import com.example.demo.Entity.PaperBook;
import com.example.demo.Exception.BookNotFoundExecption;
import com.example.demo.Exception.InvalidAddBookRequestException;
import com.example.demo.Exception.NoBookPresentException;

@Service
// @Profile("dev")
@Primary
public class BookServiceImpdev implements BookService {
	private HashMap<Integer, Book> books = new HashMap<>();

	public BookServiceImpdev() {
		Book b0 = new Book(2, "ABCD", "Gillian Flynn", 399, "Crown Publishing", 415, "Thriller", 415);
		EBook e2 = new EBook(5, "From", "Stephen King", 550, "Viking Press", 1138, "Horror", 1138, 22.3,
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

	public List<Book> showBooks() throws NoBookPresentException {
		if (books.isEmpty()) {
			throw new NoBookPresentException();
		}
		return new ArrayList<>(books.values());
	}

	public List<Book> showBookByName(String name) throws BookNotFoundExecption {
		List<Book> list = new ArrayList<>();
		books.values().stream()
				.filter(u -> u.getBookName().toLowerCase().contains(name.toLowerCase()))
				.forEach(u -> list.add(u));
		if (list.isEmpty()) {
			throw new BookNotFoundExecption("No book with this name is present");
		}
		return list;
	}

	public List<Book> searchByGenre(String Genre) throws BookNotFoundExecption {
		List<Book> list = new ArrayList<>();
		books.values().stream()
				.filter(u -> u.getGenre().toLowerCase().contains(Genre.toLowerCase()))
				.forEach(u -> list.add(u));
		if (list.isEmpty()) {
			throw new BookNotFoundExecption("No book of this genre is present");
		}
		return list;

	}

	public Book showBookById(int id) throws BookNotFoundExecption {
		Book a = books.get(id);
		if (a == null) {
			throw new BookNotFoundExecption("No book with this id is present");
		}
		return a;
	}

	public String addBook(Book b) throws InvalidAddBookRequestException {
		if (b.getBookId() == 0 || b.getBookName() == null || b.getBookAuthor() == null) {
			throw new InvalidAddBookRequestException("Bookid,BookName,BookAuthor cannot be 0 or null respectively");
		}
		books.put(b.getBookId(), b);
		return "Book has been added";
	}

	public String deleteBook(int id) throws BookNotFoundExecption {
		if (!books.containsKey(id)) {
			throw new BookNotFoundExecption("Cannot delete book with id" + id + "As book not present");
		} else {
			books.remove(id);
			return "Book has been deleted";
		}
	}

	public String isType(int id) throws BookNotFoundExecption {
		if (!books.containsKey(id)) {
			throw new BookNotFoundExecption("No such Book present");
		} else {
			Book b = books.get(id);
			if (b instanceof EBook) {
				return "Ebook";
			} else {
				return "PaperBook";
			}
		}
	}
}