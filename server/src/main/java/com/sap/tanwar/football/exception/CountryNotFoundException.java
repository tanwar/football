package com.sap.tanwar.football.exception;

public class CountryNotFoundException extends RuntimeException {

	private String message;

	public CountryNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
