package com.example.demo.Service;

import java.util.*;
import com.example.demo.Entity.*;
import com.example.demo.Exception.BookNotFoundExecption;
import com.example.demo.Exception.InvalidAddBookRequestException;
import com.example.demo.Exception.NoBookPresentException;

public interface BookService {
	public List<Book> showBooks() throws NoBookPresentException;

	public List<Book> showBookByName(String book) throws BookNotFoundExecption;

	public Book showBookById(int id) throws BookNotFoundExecption;

	public String addBook(Book b) throws InvalidAddBookRequestException;

	public String isType(int id) throws BookNotFoundExecption;

	public List<Book> searchByGenre(String Genre) throws BookNotFoundExecption;

	public String deleteBook(int id) throws BookNotFoundExecption;
}
