package com.sap.tanwar.football.exception;

public class LeagueNotFoundException extends RuntimeException {

	private String message;

	public LeagueNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
