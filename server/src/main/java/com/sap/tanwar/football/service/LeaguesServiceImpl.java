package com.sap.tanwar.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sap.tanwar.football.domain.Country;
import com.sap.tanwar.football.domain.League;
import com.sap.tanwar.football.exception.CountryNotFoundException;

@Service
public class LeaguesServiceImpl implements LeagueService {

	@Value("${server.url}")
	private String serverURL;

	@Value("${api.key}")
	private String apiKey;

	@Value("${league.action}")
	private String action;
	
	@Autowired
	private CountryService countryService;

	@Override
	public List<League> getLeagues(Long countryId) {
		List<Country> countries = countryService.getCountries();
		
		long matchingCountries = countries.stream().filter(country -> country.getCountryId().equals(String.valueOf(countryId))).count();
		
		if(matchingCountries == 0) {
			throw new CountryNotFoundException("country id " + countryId + " not found");
		}
		
		RestTemplate restTemplate = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host(serverURL).path("/")
				.queryParam("APIkey", apiKey).queryParam("action", action).queryParam("country_id", countryId).build();

		ResponseEntity<List<League>> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<League>>() {
				});

		return response.getBody();
	}

}
