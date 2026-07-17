package com.example.demo.Exception;

public class NoBookPresentException extends Exception {

	public NoBookPresentException() {
		super("No books are present");
	}
}
