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

import com.sap.tanwar.football.domain.League;
import com.sap.tanwar.football.domain.Team;
import com.sap.tanwar.football.exception.LeagueNotFoundException;

@Service
public class TeamServiceImpl implements TeamService {

	@Value("${server.url}")
	private String serverURL;

	@Value("${api.key}")
	private String apiKey;

	@Value("${teams.action}")
	private String action;
	
	@Autowired
	private LeagueService leagueService;

	@Override
	public List<Team> getTeam(Long countryId, Long leagueId) {
		
		List<League> leagues = leagueService.getLeagues(countryId);
		
		long matchingLeagues = leagues.stream().filter(league -> league.getLeagueId().equals(String.valueOf(leagueId))).count();
		
		if(matchingLeagues == 0) {
			throw new LeagueNotFoundException("league id: " + leagueId + " not found");
		}
		
		RestTemplate restTemplate = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host(serverURL).path("/")
				.queryParam("APIkey", apiKey).queryParam("action", action).queryParam("league_id", leagueId).build();

		ResponseEntity<List<Team>> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Team>>() {
				});

		return response.getBody();
	}

}
