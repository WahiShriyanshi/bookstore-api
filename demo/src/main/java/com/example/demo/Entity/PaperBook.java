package com.example.demo.Entity;

public class PaperBook extends Book {
	private String bindingType;
	private int stockQuantity;

	public PaperBook(int bookId, String bookName, String bookAuthor, int bookPrice, String bookPublisher,
			int bookTotalPages,
			String genre, int totalPages, String bindingType, int stockQuantity) {
		super(bookId, bookName, bookAuthor, bookPrice, bookPublisher, bookTotalPages, genre, totalPages);
		this.bindingType = bindingType;
		this.stockQuantity = stockQuantity;
	}

	public String getBindingType() {
		return bindingType;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setBindiString(String bindingType) {
		this.bindingType = bindingType;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
