package com.sap.tanwar.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.tanwar.football.domain.Team;
import com.sap.tanwar.football.service.TeamService;

@RestController
@RequestMapping("/countries")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping(path = "/{country-id}/leagues/{league-id}/teams")
	public List<Team> getLeagues(@PathVariable(name = "country-id", required = true) Long countryId,
			@PathVariable(name = "league-id", required = true) Long leagueId) {
		return teamService.getTeam(countryId, leagueId);

	}

}
