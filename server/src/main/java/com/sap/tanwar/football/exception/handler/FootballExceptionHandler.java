package com.sap.tanwar.football.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.sap.tanwar.football.domain.Error;
import com.sap.tanwar.football.exception.CountryNotFoundException;
import com.sap.tanwar.football.exception.LeagueNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class FootballExceptionHandler {
	
	@ExceptionHandler(value = CountryNotFoundException.class)
	public ResponseEntity<Error> handleCountryNotFoundException(CountryNotFoundException countryNotFoundException) {
		Error error = new Error();
		error.setMessage(countryNotFoundException.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value =  LeagueNotFoundException.class)
	public ResponseEntity<Error> handleLeagueNotFoundException(LeagueNotFoundException leagueNotFoundException) {
		Error error = new Error();
		error.setMessage(leagueNotFoundException.getMessage());
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}

}
