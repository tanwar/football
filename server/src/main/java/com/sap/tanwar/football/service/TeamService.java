package com.sap.tanwar.football.service;

import java.util.List;

import com.sap.tanwar.football.domain.Team;

public interface TeamService {
	
	List<Team> getTeam(Long countryId, Long leagueId);

}
