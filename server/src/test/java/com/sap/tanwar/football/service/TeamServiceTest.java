package com.sap.tanwar.football.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.sap.tanwar.football.domain.League;
import com.sap.tanwar.football.exception.LeagueNotFoundException;

public class TeamServiceTest {
	@InjectMocks
	private TeamServiceImpl teamService;
	
	@Mock
	private LeagueService leagueService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(teamService, "serverURL", "apiv2.apifootball.com/");
		ReflectionTestUtils.setField(teamService, "apiKey", "9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		ReflectionTestUtils.setField(teamService, "action", "get_teams");
	}
	
	@Test
	public void shouldReturnTeamsForCountryAndLeague() {
		Mockito.when(leagueService.getLeagues(41L)).thenReturn(getLeague("149"));
		Assert.assertNotNull(teamService.getTeam(41L, 149L));
	}
	
	@Test(expected = LeagueNotFoundException.class)
	public void shouldThrowLeagueNotFoundException() {
		Mockito.when(leagueService.getLeagues(41L)).thenReturn(new ArrayList<>());
		teamService.getTeam(41L, 149L);
	}
	
	private List<League> getLeague(String leagueId){
		List<League> leagues = new ArrayList<>();
		League league = new League();
		league.setLeagueId(leagueId);
		leagues.add(league);
		
		return leagues;
		
	}

}
