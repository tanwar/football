package com.sap.tanwar.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.tanwar.football.domain.League;
import com.sap.tanwar.football.service.LeagueService;

@RestController
@RequestMapping("/countries")
public class LeagueController {

	@Autowired
	private LeagueService leagueService;

	@GetMapping(path = "/{country-id}/leagues")
	public List<League> getLeagues(@PathVariable(name = "country-id", required = true) Long countryId) {
		return leagueService.getLeagues(countryId);

	}

}
