package com.sap.tanwar.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.tanwar.football.domain.Country;
import com.sap.tanwar.football.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping(path = "/")
	public List<Country> getCountries() {
		return countryService.getCountries();

	}

}
