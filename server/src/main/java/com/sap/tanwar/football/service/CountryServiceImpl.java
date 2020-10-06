package com.sap.tanwar.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sap.tanwar.football.domain.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Value("${server.url}")
	private String serverURL;

	@Value("${api.key}")
	private String apiKey;

	@Value("${country.action}")
	private String action;

	@Override
	public List<Country> getCountries() {
		RestTemplate restTemplate = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host(serverURL).path("/")
				.queryParam("APIkey", apiKey).queryParam("action", action).build();

		ResponseEntity<List<Country>> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Country>>() {
				});

		return response.getBody();
	}

}
