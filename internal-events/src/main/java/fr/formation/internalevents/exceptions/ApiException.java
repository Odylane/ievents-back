package fr.formation.internalevents.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiException {

	private LocalDateTime timestamp = LocalDateTime.now();

	private String message;

	private HttpStatus httpStatus;

	private List<String> errors = new ArrayList<>();

	public ApiException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public ApiException(String message, HttpStatus httpStatus, List<String> errors) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.errors = errors;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public List<String> getErrors() {
		return errors;
	}

}
