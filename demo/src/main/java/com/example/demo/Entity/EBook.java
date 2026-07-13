package com.example.demo.Entity;

public class EBook extends Book {
	private double fileSize;
	private String downloadLink;

	public EBook(int bookId, String bookName, String bookAuthor, int bookPrice, String bookPublisher,
			int bookTotalPages, String genre, int totalPages, double fileSize, String downloadLink) {
		super(bookId, bookName, bookAuthor, bookPrice, bookPublisher, bookTotalPages, genre, totalPages);
		this.fileSize = fileSize;
		this.downloadLink = downloadLink;
	}

	public double getFileSize() {
		return fileSize;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
}
