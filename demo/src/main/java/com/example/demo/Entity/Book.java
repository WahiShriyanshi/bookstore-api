package com.example.demo.Entity;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private String bookPublisher;
	private int bookTotalPages;
	private String genre;
	private int totalPages;

	public Book(int bookId, String bookName, String bookAuthor, int bookPrice, String bookPublisher, int bookTotalPages,
			String genre, int totalPages) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
		this.bookTotalPages = bookTotalPages;
		this.genre = genre;
		this.totalPages = totalPages;
	}

	// getters
	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public int getBookTotalPages() {
		return bookTotalPages;
	}

	public String getGenre() {
		return genre;
	}

	public int getTotalPages() {
		return totalPages;
	}

	// setters
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void getBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public void setBookTotalPages(int bookTotalPages) {
		this.bookTotalPages = bookTotalPages;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
