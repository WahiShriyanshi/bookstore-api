package com.example.demo.Service;

import java.util.*;
import com.example.demo.Entity.*;

public interface BookService {
	public List<Book> showBooks();

	public List<Book> showBookByName(String book);

	public Book showBookById(int id);

	public String addBook(Book b);

	public String deleteBook(int id);

	public String isType(int id);

	public List<Book> searchByGenre(String Genre);
}
