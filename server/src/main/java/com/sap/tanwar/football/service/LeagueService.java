package com.sap.tanwar.football.service;

import java.util.List;

import com.sap.tanwar.football.domain.League;

public interface LeagueService {
	
	List<League> getLeagues(Long countryId);

}
