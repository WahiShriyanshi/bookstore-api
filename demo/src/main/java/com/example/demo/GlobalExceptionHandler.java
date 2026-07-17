package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.NoBookPresentException;
import com.example.demo.Exception.BookNotFoundExecption;
import com.example.demo.Exception.InvalidAddBookRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoBookPresentException.class)
	public ResponseEntity<String> handleNoBookPresent(NoBookPresentException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(BookNotFoundExecption.class)
	public ResponseEntity<String> handleBookNotFound(BookNotFoundExecption e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(InvalidAddBookRequestException.class)
	public ResponseEntity<String> handleInvalidEntry(InvalidAddBookRequestException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.internalServerError().body("Error Occured " + e.getMessage());
	}
}